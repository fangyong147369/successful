package com.zc.sys.core.user.service.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zc.sys.common.form.Result;
import com.zc.sys.common.model.jpa.QueryParam;
import com.zc.sys.common.model.jpa.SearchFilter;
import com.zc.sys.common.model.jpa.SearchFilter.Operators;
import com.zc.sys.common.util.date.DateUtil;
import com.zc.sys.common.util.encrypt.MD5;
import com.zc.sys.common.util.validate.StringUtil;
import com.zc.sys.core.account.dao.AccountDao;
import com.zc.sys.core.account.entity.Account;
import com.zc.sys.core.account.model.AccountModel;
import com.zc.sys.core.common.constant.BaseConstant;
import com.zc.sys.core.common.executer.Executer;
import com.zc.sys.core.common.global.BeanUtil;
import com.zc.sys.core.common.queue.pojo.QueueModel;
import com.zc.sys.core.common.queue.service.QueueProducerService;
import com.zc.sys.core.credit.dao.CreditScoreDao;
import com.zc.sys.core.credit.entity.CreditScore;
import com.zc.sys.core.credit.model.CreditScoreModel;
import com.zc.sys.core.integral.dao.IntegralAccountDao;
import com.zc.sys.core.integral.entity.IntegralAccount;
import com.zc.sys.core.integral.model.IntegralAccountModel;
import com.zc.sys.core.manage.dao.OrderTaskDao;
import com.zc.sys.core.manage.entity.OrderTask;
import com.zc.sys.core.manage.model.OrderTaskModel;
import com.zc.sys.core.user.dao.UserDao;
import com.zc.sys.core.user.dao.UserIdentifyDao;
import com.zc.sys.core.user.dao.UserInfoDao;
import com.zc.sys.core.user.entity.User;
import com.zc.sys.core.user.entity.UserIdentify;
import com.zc.sys.core.user.entity.UserInfo;
import com.zc.sys.core.user.executer.UserInviteExecuter;
import com.zc.sys.core.user.executer.UserLoginExecuter;
import com.zc.sys.core.user.executer.UserRegExecuter;
import com.zc.sys.core.user.model.UserIdentifyModel;
import com.zc.sys.core.user.model.UserInfoModel;
import com.zc.sys.core.user.model.UserModel;
import com.zc.sys.core.user.service.UserService;
/**
 * 用户
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;
	@Resource
	private UserInfoDao userInfoDao;
	@Resource
	private UserIdentifyDao userIdentifyDao;
	@Resource
	private AccountDao accountDao;
	@Resource
	private OrderTaskDao orderTaskDao;
	@Resource
	private IntegralAccountDao integralAccountDao;
	@Resource
	private CreditScoreDao creditScoreDao;
	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result list(UserModel model){

		return null;
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result add(UserModel model){

		return null;
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result update(UserModel model){

		return null;
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result getById(UserModel model){
		
		return null;
	}

	/**
 	 * 注册
 	 * @param model
 	 * @return
 	 */
	@Override
	@Transactional
	public Result regRequest(UserModel model) {
		//注册信息校验
		model.checkReg();
		//初始化注册
		model.initReg();
		User user = model.prototype();
		//保存用户
		userDao.save(user);
		model.setId(user.getId());
		
		//发送队列处理实名
		QueueProducerService queueProducerService = BeanUtil.getBean(QueueProducerService.class);
		OrderTask orderTask = new OrderTask(user,"userReg", StringUtil.getSerialNumber(), BaseConstant.BUSINESS_STATE_WAIT, "", DateUtil.getNow());
		orderTaskDao.save(orderTask);
		model.setOrderTask(orderTask);
		queueProducerService.send(new QueueModel("user", OrderTaskModel.instance(orderTask), model));
		
		UserModel returnModel = UserModel.instance(user);
		returnModel.initReturn();
		return Result.success().setData(returnModel);
	}
	
	/**
	 * 注册处理
	 * @param model
	 * @return
	 */
	@Override
	@Transactional
	public Result regDeal(UserModel model){
		User user = userDao.find(model.getId());
		//初始化用户基本信息
		UserInfoModel infoModel = new UserInfoModel();
		infoModel.setUser(user);
		infoModel.initReg(model);//初始化
		UserInfo userInfo = infoModel.prototype();
		userInfoDao.save(userInfo);
		model.setInfoModel(infoModel);
		
		//初始化认证信息
		UserIdentifyModel identifyModel = new UserIdentifyModel();
		identifyModel.setUser(user);
		identifyModel.initReg(model);//初始化
		UserIdentify userIdentify = identifyModel.prototype();
		userIdentifyDao.save(userIdentify);
		
		//初始化账户信息
		AccountModel accountModel = new AccountModel();
		accountModel.setUser(user);
		accountModel.initReg(model);//初始化
		Account account = accountModel.prototype();
		accountDao.save(account);
		
		//积分账户初始化
		IntegralAccountModel integralAccountModel = new IntegralAccountModel();
		integralAccountModel.setUser(user);
		integralAccountModel.initReg(model);//初始化注册
		IntegralAccount integralAccount = integralAccountModel.prototype();
		integralAccountDao.save(integralAccount);
		
		//信用账户初始化
		CreditScoreModel creditScoreModel = new CreditScoreModel();
		creditScoreModel.setUser(user);
		creditScoreModel.initReg(model);//初始化注册
		CreditScore creditScore = creditScoreModel.prototype();
		creditScoreDao.save(creditScore);
		
		//订单处理
		OrderTask orderTask = orderTaskDao.find(model.getOrderTask().getId());
		orderTask.setDoTime(DateUtil.getNow());
		orderTask.setDoResult("注册成功");
		orderTask.setState(BaseConstant.BUSINESS_STATE_YES);
		orderTaskDao.update(orderTask);
		
		//注册任务
		Executer regExecuter = BeanUtil.getBean(UserRegExecuter.class);
		regExecuter.execute(model);
		//邀请任务
		Executer inviteExecuter = BeanUtil.getBean(UserInviteExecuter.class);
		inviteExecuter.execute(infoModel);
		return Result.success();
	}

	/**
 	 * 登录
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result login(UserModel model) {
		model.checkLogin();//登录信息校验
		String loginName = StringUtil.isNull(model.getLoginName());
		String pwd = MD5.toMD5(StringUtil.isNull(model.getPwd()));
		QueryParam param = QueryParam.getInstance();
		SearchFilter orFilter1 = new SearchFilter("userName", Operators.EQ, loginName);
		SearchFilter orFilter2 = new SearchFilter("email", Operators.EQ, loginName);
		SearchFilter orFilter3 = new SearchFilter("mobile", Operators.EQ, loginName);
		param.addOrFilter(orFilter1, orFilter2,orFilter3);
		param.addParam("pwd", pwd);
		List<User> userList = userDao.findByCriteria(param);
		if(userList.size() != 1){
			return Result.error("登录失败，用户名或密码有误");
		}
		User user = userList.get(0);
		model = UserModel.instance(user);
		
		//登录任务
		Executer loginExecuter = BeanUtil.getBean(UserLoginExecuter.class);
		loginExecuter.execute(model);
		
		UserModel returnModel = UserModel.instance(user);
		returnModel.initReturn();
		return Result.success().setData(returnModel);
	}

	@Override
	public Result updatePayPwd(UserModel model) {
		
		return null;
	}

	@Override
	public Result updatePwd(UserModel model) {
		User user = model.checkUpdatePwd();//校验修改登录密码
		return null;
	}
	
	

}