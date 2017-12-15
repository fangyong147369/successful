package com.zc.sys.core.account.service.impl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.zc.sys.common.form.Result;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.core.account.dao.RechargeDao;
import com.zc.sys.core.account.entity.AccountDeduct;
import com.zc.sys.core.account.entity.Recharge;
import com.zc.sys.core.account.entity.WithdrawCash;
import com.zc.sys.core.account.model.AccountDeductModel;
import com.zc.sys.core.account.model.AccountLogModel;
import com.zc.sys.core.account.model.RechargeModel;
import com.zc.sys.core.account.model.WithdrawCashModel;
import com.zc.sys.core.account.service.RechargeService;
import com.zc.sys.core.user.model.UserModel;
/**
 * 充值
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Service
public class RechargeServiceImpl implements RechargeService {

	@Resource
	private RechargeDao rechargeDao;
	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result list(RechargeModel model){
		PageDataList<Recharge> pageDataList =rechargeDao.list(model);
		PageDataList<RechargeModel> pageDataList_ = new PageDataList<RechargeModel>();
		pageDataList_.setPage(pageDataList.getPage());
		List list = new ArrayList();
		if (pageDataList != null && pageDataList.getList().size() > 0) {
			for (Recharge article : pageDataList.getList()) {
				RechargeModel  model_=RechargeModel.instance(article);
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
	public Result add(RechargeModel model){

		return null;
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@Override
	@Transactional
	public Result update(RechargeModel model){

		return null;
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result getById(RechargeModel model){
		if(model.getId() <= 0){
			return Result.error("参数错误！");
		}
		Recharge recharge =rechargeDao.find(model.getId());
		RechargeModel  model_=RechargeModel.instance(recharge);
		 model_.setUserModel(UserModel.instance(recharge.getUser()));
		// model_=UserModel.instance(UserInfoModel.instance(user.getUserInfo()).getUser());
		return Result.success().setData(model_);
	}

}