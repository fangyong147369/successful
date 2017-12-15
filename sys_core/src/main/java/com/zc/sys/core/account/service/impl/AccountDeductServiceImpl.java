package com.zc.sys.core.account.service.impl;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zc.sys.common.form.Result;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.core.account.dao.AccountDeductDao;
import com.zc.sys.core.account.entity.AccountDeduct;
import com.zc.sys.core.account.model.AccountDeductModel;
import com.zc.sys.core.account.service.AccountDeductService;
import com.zc.sys.core.user.model.UserModel;
/**
 * 线下扣款
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Service
public class AccountDeductServiceImpl implements AccountDeductService {

	@Resource
	private AccountDeductDao accountDeductDao;
	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result list(AccountDeductModel model){
		PageDataList<AccountDeduct> pageDataList =accountDeductDao.list(model);
		PageDataList<AccountDeductModel> pageDataList_ = new PageDataList<AccountDeductModel>();
		pageDataList_.setPage(pageDataList.getPage());
		List<AccountDeductModel> list = new ArrayList<AccountDeductModel>();
		if (pageDataList != null && pageDataList.getList().size() > 0) {
			for (AccountDeduct article : pageDataList.getList()) {
				AccountDeductModel  model_=AccountDeductModel.instance(article);
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
	public Result add(AccountDeductModel model){

		return null;
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@Override
	@Transactional
	public Result update(AccountDeductModel model){

		return null;
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result getById(AccountDeductModel model){
		if(model.getId() <= 0){
			return Result.error("参数错误！");
		}
		AccountDeduct accountDeduct =accountDeductDao.find(model.getId());
		AccountDeductModel  model_=AccountDeductModel.instance(accountDeduct);
		 model_.setUserModel(UserModel.instance(accountDeduct.getUser()));
		// model_=UserModel.instance(UserInfoModel.instance(user.getUserInfo()).getUser());
		return Result.success().setData(model_);
	}

}