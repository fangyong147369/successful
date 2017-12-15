package com.zc.sys.core.account.service.impl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.zc.sys.common.form.Result;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.core.account.dao.AccountDao;
import com.zc.sys.core.account.entity.Account;
import com.zc.sys.core.account.entity.WithdrawCash;
import com.zc.sys.core.account.model.AccountModel;
import com.zc.sys.core.account.model.WithdrawCashModel;
import com.zc.sys.core.account.service.AccountService;
import com.zc.sys.core.user.entity.UserInfo;
import com.zc.sys.core.user.model.UserInfoModel;
import com.zc.sys.core.user.model.UserModel;
/**
 * 资金账户
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Service
public class AccountServiceImpl implements AccountService {

	@Resource
	private AccountDao accountDao;
	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result list(AccountModel model){
		PageDataList<Account> pageDataList =accountDao.list(model);
		PageDataList<AccountModel> pageDataList_ = new PageDataList<AccountModel>();
		pageDataList_.setPage(pageDataList.getPage());
		List list = new ArrayList();
		if (pageDataList != null && pageDataList.getList().size() > 0) {
			for (Account article : pageDataList.getList()) {
				AccountModel  model_=AccountModel.instance(article);
				model_.setUserModel(UserModel.instance(article.getUser()));
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
	public Result add(AccountModel model){

		return null;
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@Override
	@Transactional
	public Result update(AccountModel model){

		return null;
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result getById(AccountModel model){
		if(model.getId() <= 0){
			return Result.error("参数错误！");
		}
		Account account =accountDao.find(model.getId());
		AccountModel  model_=AccountModel.instance(account);
		 model_.setUserModel(UserModel.instance(account.getUser()));
		// model_=UserModel.instance(UserInfoModel.instance(user.getUserInfo()).getUser());
		return Result.success().setData(model_);
	}

}