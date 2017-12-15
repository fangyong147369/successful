package com.zc.sys.core.user.service.impl;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zc.sys.common.form.Result;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.common.model.jpa.QueryParam;
import com.zc.sys.common.model.jpa.SearchFilter;
import com.zc.sys.common.model.jpa.SearchFilter.Operators;
import com.zc.sys.common.util.encrypt.MD5;
import com.zc.sys.common.util.validate.StringUtil;
import com.zc.sys.core.account.dao.AccountDao;
import com.zc.sys.core.account.entity.Account;
import com.zc.sys.core.account.model.AccountModel;
import com.zc.sys.core.common.executer.Executer;
import com.zc.sys.core.common.global.BeanUtil;
import com.zc.sys.core.credit.dao.CreditScoreDao;
import com.zc.sys.core.credit.entity.CreditScore;
import com.zc.sys.core.credit.model.CreditScoreModel;
import com.zc.sys.core.integral.dao.IntegralAccountDao;
import com.zc.sys.core.integral.entity.IntegralAccount;
import com.zc.sys.core.integral.model.IntegralAccountModel;
import com.zc.sys.core.manage.dao.OrderTaskDao;
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
		PageDataList<User> pageDataList = userDao.list(model);
		PageDataList<UserModel> pageDataList_ = new PageDataList<UserModel>();
		pageDataList_.setPage(pageDataList.getPage());
		List<UserModel> list = new ArrayList<UserModel>();
		if (pageDataList != null && pageDataList.getList().size() > 0) {
			for (User user : pageDataList.getList()) {
				UserModel model_ = UserModel.instance(user);				
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
	public Result add(UserModel model){
		User user = model.prototype();
		userDao.save(user);
		return Result.success().setData(user);
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@Override
	@Transactional
	public Result update(UserModel model){
      User user = userDao.find(model.getId());
		model.setUpdateParam(user);//设置修改基本参数
		userDao.update(user);	
		return Result.success();
	}
	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result getById(UserModel model){
		if(model.getId() <= 0){
			return Result.error("参数错误！");
		}
		User user =userDao.find(model.getId());
		UserModel  model_=UserModel.instance(user);
		 model_.setInfoModel(UserInfoModel.instance(user.getUserInfo()));
		// model_=UserModel.instance(UserInfoModel.instance(user.getUserInfo()).getUser());
		return Result.success().setData(model_);
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
		
		//注册任务
		Executer regExecuter = BeanUtil.getBean(UserRegExecuter.class);
		regExecuter.execute(UserModel.instance(user));
		//邀请任务
		Executer inviteExecuter = BeanUtil.getBean(UserInviteExecuter.class);
		inviteExecuter.execute(UserInfoModel.instance(userInfo));
		
		UserModel returnModel = UserModel.instance(user);
		returnModel.initReturn();
		return Result.success().setData(returnModel);
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

	/**
	 * 修改交易密码
	 * @param model
	 * @return
	 */
	@Override
	@Transactional
	public Result updatePayPwd(UserModel model) {
		User user = model.checkUpdatePayPwd();//校验修改交易密码
		model.initUpdatePayPwd(user);//初始化信息
		userDao.update(user);
		return Result.success();
	}

	/**
	 * 修改登录密码
	 * @param model
	 * @return
	 */
	@Override
	@Transactional
	public Result updatePwd(UserModel model) {
		User user = model.checkUpdatePwd();//校验修改登录密码
		model.initUpdatePwd(user);//初始化信息
		userDao.update(user);
		return Result.success();
	}
	
	

}