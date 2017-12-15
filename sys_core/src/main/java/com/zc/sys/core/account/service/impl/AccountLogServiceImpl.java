package com.zc.sys.core.account.service.impl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.zc.sys.common.form.Result;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.core.account.dao.AccountLogDao;
import com.zc.sys.core.account.entity.Account;
import com.zc.sys.core.account.entity.AccountDeduct;
import com.zc.sys.core.account.entity.AccountLog;
import com.zc.sys.core.account.model.AccountDeductModel;
import com.zc.sys.core.account.model.AccountLogModel;
import com.zc.sys.core.account.model.AccountModel;
import com.zc.sys.core.account.service.AccountLogService;
import com.zc.sys.core.user.model.UserModel;
/**
 * 资金日志
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Service
public class AccountLogServiceImpl implements AccountLogService {

	@Resource
	private AccountLogDao accountLogDao;
	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result list(AccountLogModel model){
		PageDataList<AccountLog> pageDataList =accountLogDao.list(model);
		PageDataList<AccountLogModel> pageDataList_ = new PageDataList<AccountLogModel>();
		pageDataList_.setPage(pageDataList.getPage());
		List list = new ArrayList();
		if (pageDataList != null && pageDataList.getList().size() > 0) {
			for (AccountLog article : pageDataList.getList()) {
				AccountLogModel  model_=AccountLogModel.instance(article);
				model_.setUserModel(UserModel.instance(article.getUser()));
		        model_.setToUserModel(UserModel.instance(article.getUser()));
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
	public Result add(AccountLogModel model){

		return null;
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@Override
	@Transactional
	public Result update(AccountLogModel model){

		return null;
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result getById(AccountLogModel model){
		if(model.getId() <= 0){
			return Result.error("参数错误！");
		}
		AccountLog account =accountLogDao.find(model.getId());
		AccountLogModel  model_=AccountLogModel.instance(account);
		 model_.setUserModel(UserModel.instance(account.getUser()));
		// model_=UserModel.instance(UserInfoModel.instance(user.getUserInfo()).getUser());
		return Result.success().setData(model_);
	}

}