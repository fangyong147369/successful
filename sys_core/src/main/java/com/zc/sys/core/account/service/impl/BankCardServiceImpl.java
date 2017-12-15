package com.zc.sys.core.account.service.impl;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zc.sys.common.form.Result;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.common.util.date.DateUtil;
import com.zc.sys.common.util.validate.StringUtil;
import com.zc.sys.core.account.dao.BankCardDao;
import com.zc.sys.core.account.entity.BankCard;
import com.zc.sys.core.account.executer.UserBindBCExecuter;
import com.zc.sys.core.account.model.BankCardModel;
import com.zc.sys.core.account.service.BankCardService;
import com.zc.sys.core.common.constant.BaseConstant;
import com.zc.sys.core.common.executer.Executer;
import com.zc.sys.core.common.global.BeanUtil;
import com.zc.sys.core.common.queue.pojo.QueueModel;
import com.zc.sys.core.common.queue.service.QueueProducerService;
import com.zc.sys.core.manage.dao.OrderTaskDao;
import com.zc.sys.core.manage.entity.OrderTask;
import com.zc.sys.core.manage.model.OrderTaskModel;
import com.zc.sys.core.user.dao.UserIdentifyDao;
import com.zc.sys.core.user.entity.User;
import com.zc.sys.core.user.entity.UserIdentify;
import com.zc.sys.core.user.model.UserModel;
/**
 * 银行卡
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Service
public class BankCardServiceImpl implements BankCardService {

	@Resource
	private BankCardDao bankCardDao;
	@Resource
	private OrderTaskDao orderTaskDao;
	@Resource
	private UserIdentifyDao userIdentifyDao;
	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result list(BankCardModel model){
		PageDataList<BankCard> pageDataList = bankCardDao.list(model);
		PageDataList<BankCardModel> pageDataList_ = new PageDataList<BankCardModel>();
		pageDataList_.setPage(pageDataList.getPage());
		List<BankCardModel> list = new ArrayList<BankCardModel>();
		if(pageDataList != null && pageDataList.getList().size() > 0){
			for (BankCard bankCard : pageDataList.getList()) {
				BankCardModel model_ = BankCardModel.instance(bankCard);
				model_.setUserModel(UserModel.instance(bankCard.getUser()));
				list.add(model_);
			}
		}
		pageDataList_.setList(list);
		return Result.success().setData(pageDataList_);
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@Override
	@Transactional
	public Result add(BankCardModel model){

		return null;
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@Override
	@Transactional
	public Result update(BankCardModel model){

		return null;
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result getById(BankCardModel model){
		if(model.getId() <= 0){
			return Result.error("参数错误！");
		}
		BankCard bankCard =bankCardDao.find(model.getId());
		BankCardModel  model_=BankCardModel.instance(bankCard);
		 model_.setUserModel(UserModel.instance(bankCard.getUser()));
		// model_=UserModel.instance(UserInfoModel.instance(user.getUserInfo()).getUser());
		return Result.success().setData(model_);
	}

	/**
 	 * 绑卡请求
 	 * @param model
 	 * @return
 	 */
	@Override
	@Transactional
	public Result bindBCRequest(BankCardModel model) {
		model.checkBindBC();//绑卡校验
		model.initBind();//初始化
		BankCard bankCard = model.prototype();
		bankCardDao.save(bankCard);
		model.setId(bankCard.getId());
		
		//发送队列处理绑卡
		QueueProducerService queueService = BeanUtil.getBean(QueueProducerService.class);
		OrderTask orderTask = new OrderTask(bankCard.getUser(), "bindBC", StringUtil.getSerialNumber(), BaseConstant.BUSINESS_STATE_WAIT, "", DateUtil.getNow());
		orderTask = orderTaskDao.save(orderTask);
		model.setOrderTask(orderTask);
		queueService.send(new QueueModel("user", OrderTaskModel.instance(orderTask), model));
		return Result.success("绑卡处理中...请稍后！");
	}

	/**
 	 * 绑卡处理
 	 * @param model
 	 * @return
 	 */
	@Override
	@Transactional
	public Result bindBCDeal(BankCardModel model) {
		BankCard bankCard = bankCardDao.find(model.getId());
		bankCard.setState(BaseConstant.BUSINESS_STATE_YES);
		User user = bankCard.getUser();
		UserIdentify userIdentify = userIdentifyDao.findObjByProperty("user.id", user.getId());
		userIdentify.setBindCardNum(userIdentify.getBindCardNum() + 1);
		userIdentifyDao.update(userIdentify);
		bankCard.setUser(user);
		bankCardDao.update(bankCard);
		
		//订单处理
		OrderTask orderTask = orderTaskDao.find(model.getOrderTask().getId());
		orderTask.setDoTime(DateUtil.getNow());
		orderTask.setDoResult("绑卡成功");
		orderTask.setState(BaseConstant.BUSINESS_STATE_YES);
		orderTaskDao.update(orderTask);
		
		//绑定银行卡任务
		Executer bindBCExecuter = BeanUtil.getBean(UserBindBCExecuter.class);
		bindBCExecuter.execute(model);
		return Result.success();
	}

}