package com.zc.sys.core.common.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zc.sys.common.cache.RedisCacheUtil;
import com.zc.sys.common.exception.BusinessException;
import com.zc.sys.common.form.Result;
import com.zc.sys.common.util.calculate.BigDecimalUtil;
import com.zc.sys.common.util.date.DateUtil;
import com.zc.sys.common.util.validate.RandomUtil;
import com.zc.sys.common.util.validate.StringUtil;
import com.zc.sys.core.common.constant.BaseConstant;
import com.zc.sys.core.common.executer.Executer;
import com.zc.sys.core.common.executer.NoticeMessageExecuter;
import com.zc.sys.core.common.global.BeanUtil;
import com.zc.sys.core.common.global.Global;
import com.zc.sys.core.common.interest.CalculatorModel;
import com.zc.sys.core.common.interest.EachPlan;
import com.zc.sys.core.common.interest.InterestCalculator;
import com.zc.sys.core.common.interest.OnetimeRepaymentCalculator;
import com.zc.sys.core.common.model.CommonModel;
import com.zc.sys.core.common.service.CommonService;
import com.zc.sys.core.manage.dao.NoticeMessageDao;
import com.zc.sys.core.manage.dao.OrderTaskDao;
import com.zc.sys.core.manage.entity.OrderTask;
import com.zc.sys.core.manage.model.NoticeMessageModel;
import com.zc.sys.core.manage.model.OrderTaskModel;

/**
 * 公共接口
 * 
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月15日
 */
@Service
public class CommonServiceImpl implements CommonService {

	@Resource
	private RedisCacheUtil redisCacheUtil;
	@Resource
	private OrderTaskDao orderTaskDao;
	@Resource
	private NoticeMessageDao noticeMessageDao;

	/**
	 * 生成唯一请求标识
	 * token
	 * @param model
	 * @return
	 */
	@Override
	public Result getToken() {
		String token = StringUtil.getSerialNumber();
		redisCacheUtil.setCode("token_" + token, "token_" + token, 60 * 30);
		return Result.success().setData(token);
	}

	/**
	 * 校验token
	 * @param token
	 * @return
	 */
	@Override
	public void checkToken(String token) {
		String key = "token_" + token;
		String ckToken = redisCacheUtil.getCache(key, String.class);
		if(StringUtil.isBlank(ckToken)){
			redisCacheUtil.delCode(key);
		}else {
			throw new BusinessException("表单Token未设定，请刷新页面后重试。");
		}
	}

	/**
	 * 发送短信验证码
	 * @param model
	 * @return
	 */
	@Override
	public Result getMobileCode(CommonModel model) {
		model.checkSMS();//短信发送校验
		
		String value = RandomUtil.code();
		String key = "SMS_" + model.getHandleSmsType() + "_" + model.getMobile();
		String cacheCode = redisCacheUtil.getCache(key, String.class);
		if(StringUtil.isNotBlank(cacheCode)){
			return Result.error("短信请求频繁，请稍后操作");
		}
		redisCacheUtil.setCode(key, "123456", 60*3);
		if(!Global.sysState()){
			//测试环境不发送短信
			return Result.success("本次测试短信为：" + value);
		}
		OrderTask orderTask = new OrderTask(null, "SMS_reg", StringUtil.getSerialNumber(), BaseConstant.BUSINESS_STATE_WAIT, "", DateUtil.getNow());
		orderTaskDao.save(orderTask);
		NoticeMessageModel noticeModel = new NoticeMessageModel("SMS_reg",1, orderTask.getOrderNo(), OrderTaskModel.instance(orderTask),model.getMobile());
		//短信任务
		Executer smsExecuter = BeanUtil.getBean(NoticeMessageExecuter.class);
		smsExecuter.execute(noticeModel);
		return Result.success("短信请求成功");
	}
	
	/**
	 * 校验短信验证码
	 * @param mobile
	 * @param code
	 * @return
	 */
	@Override
	public void checkMobileCode(String mobile,String mobileCode,int handleSmsType) {
		String key = "SMS_" + handleSmsType + "_" + mobile;
		String cacheCode = redisCacheUtil.getCache(key, String.class);
		redisCacheUtil.delCode(key);
		if(StringUtil.isBlank(cacheCode) || !mobileCode.equals(cacheCode)){
			throw new BusinessException("短信验证码校验失败");
		}
	}

	/**
	 * 利息计算器
	 * @param model
	 * @return
	 */
	@Override
	public void calculator(CommonModel model) {
		model.checkAndInitCalculator();
		InterestCalculator ic = null;
		List<EachPlan> list = new ArrayList<EachPlan>();
		List<CalculatorModel> list_ = new ArrayList<CalculatorModel>();
		if(model.getPeriodUnit() == BaseConstant.PERIODUNIT_DAY){//天
			if(model.getRepaymentType() == BaseConstant.REPAYMENT_WAY_ONETIME){//一次性
				ic = new OnetimeRepaymentCalculator(model.getAmount(), BigDecimalUtil.mul(model.getRate(),365), model.getStartTime(), 1, 0);
				list = ic.calculator(model.getPeriod());
			}
		}
		
		int i = 0;
		for (EachPlan eachPlan : list) {
			CalculatorModel calculatorModel = new CalculatorModel();
			calculatorModel.setCapital(eachPlan.getCapital());
			calculatorModel.setInterest(eachPlan.getInterest());
			calculatorModel.setPeriod(i+1);
			calculatorModel.setPeriodTotal(eachPlan.getNetTotal());
			calculatorModel.setRepayTime(eachPlan.getRepayTime());
			double needRepay = eachPlan.getNeedRepay();
			calculatorModel.setNeedRepay(needRepay);
			
			list_.add(calculatorModel);

			//还款利息总额
			model.setInterestTotal(BigDecimalUtil.add(eachPlan.getInterest(),model.getInterestTotal()));
			i++;
		}
		//还款总额
		model.setTotal(BigDecimalUtil.add(model.getInterestTotal(), model.getAmount()));
		model.setCalculatorModelList(list_);
		model.setInterestTotal(BigDecimalUtil.round(model.getInterestTotal(), 2));
		model.setTotal(BigDecimalUtil.round(model.getTotal(), 2));
	}

}
