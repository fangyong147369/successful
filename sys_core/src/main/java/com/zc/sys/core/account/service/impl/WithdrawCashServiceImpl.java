package com.zc.sys.core.account.service.impl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.zc.sys.common.form.Result;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.core.account.dao.WithdrawCashDao;
import com.zc.sys.core.account.entity.AccountLog;
import com.zc.sys.core.account.entity.WithdrawCash;
import com.zc.sys.core.account.model.AccountLogModel;
import com.zc.sys.core.account.model.WithdrawCashModel;
import com.zc.sys.core.account.service.WithdrawCashService;
import com.zc.sys.core.user.entity.User;
import com.zc.sys.core.user.model.UserInfoModel;
import com.zc.sys.core.user.model.UserModel;
/**
 * 提现
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Service
public class WithdrawCashServiceImpl implements WithdrawCashService {

	@Resource
	private WithdrawCashDao withdrawCashDao;
	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result list(WithdrawCashModel model){
		PageDataList<WithdrawCash> pageDataList =withdrawCashDao.list(model);
		PageDataList<WithdrawCashModel> pageDataList_ = new PageDataList<WithdrawCashModel>();
		pageDataList_.setPage(pageDataList.getPage());
		List list = new ArrayList();
		if (pageDataList != null && pageDataList.getList().size() > 0) {
			for (WithdrawCash withdrawCash : pageDataList.getList()) {
				WithdrawCashModel  model_=WithdrawCashModel.instance(withdrawCash);
				model_.setUserModel(UserModel.instance(withdrawCash.getUser()));
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
	public Result add(WithdrawCashModel model){

		return null;
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@Override
	@Transactional
	public Result update(WithdrawCashModel model){

		return null;
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result getById(WithdrawCashModel model){
		if(model.getId() <= 0){
			return Result.error("参数错误！");
		}
		WithdrawCash withdrawCash =withdrawCashDao.find(model.getId());
		WithdrawCashModel  model_=WithdrawCashModel.instance(withdrawCash);
		 model_.setUserModel(UserModel.instance(withdrawCash.getUser()));
		// model_=UserModel.instance(UserInfoModel.instance(user.getUserInfo()).getUser());
		return Result.success().setData(model_);
	}

}