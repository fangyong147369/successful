package com.zc.sys.core.common.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zc.sys.common.cache.RedisCacheUtil;
import com.zc.sys.common.exception.BussinessException;
import com.zc.sys.common.form.Result;
import com.zc.sys.common.util.date.DateUtil;
import com.zc.sys.common.util.validate.RandomUtil;
import com.zc.sys.common.util.validate.StringUtil;
import com.zc.sys.core.common.executer.Executer;
import com.zc.sys.core.common.executer.NoticeMessageExecuter;
import com.zc.sys.core.common.global.BeanUtil;
import com.zc.sys.core.common.global.Global;
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
		redisCacheUtil.setCode("token_" + token, "token_" + token, 60 * 60);
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
			throw new BussinessException("表单Token未设定，请刷新页面后重试。");
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
		String key = "SMS_" + model.getMobile();
		String cacheCode = redisCacheUtil.getCache(key, String.class);
		if(StringUtil.isNotBlank(cacheCode)){
			return Result.error("短信请求频繁，请稍后操作");
		}
		redisCacheUtil.setCode(key, "123456", 60*3);
		if(!Global.sysState()){
			//测试环境不发送短信
			return Result.success("本次测试短信为：" + value);
		}
		OrderTask orderTask = new OrderTask(null, "SMS_reg", StringUtil.getSerialNumber(), 2, "", DateUtil.getNow());
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
	public void checkMobileCode(String mobile,String mobileCode) {
		String key = "SMS_" + mobile;
		String cacheCode = redisCacheUtil.getCache(key, String.class);
		redisCacheUtil.delCode(key);
		if(StringUtil.isBlank(cacheCode) || !mobileCode.equals(cacheCode)){
			throw new BussinessException("短信验证码校验失败");
		}
	}

}
