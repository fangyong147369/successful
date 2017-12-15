package com.zc.sys.core.user.service.impl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import com.zc.sys.common.form.Result;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.core.user.dao.UserInfoDao;
import com.zc.sys.core.user.entity.UserInfo;
import com.zc.sys.core.user.model.UserInfoModel;
import com.zc.sys.core.user.model.UserModel;
import com.zc.sys.core.user.service.UserInfoService;
/**
 * 用户信息
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Resource
	private UserInfoDao userInfoDao;
	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result list(UserInfoModel model){
		PageDataList<UserInfo> pageDataList = userInfoDao.list(model);
		PageDataList<UserInfoModel> pageDataList_ = new PageDataList<UserInfoModel>();
		pageDataList_.setPage(pageDataList.getPage());
		List<UserInfoModel> list = new ArrayList<UserInfoModel>();
		if (pageDataList != null && pageDataList.getList().size() > 0) {
			for (UserInfo article : pageDataList.getList()) {
				UserInfoModel  model_=UserInfoModel.instance(article);
				model_.setUserModel(UserModel.instance(article.getUser()));
				model_.setInviteUserModel(UserModel.instance(article.getUser()));
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
	public Result add(UserInfoModel model){
		UserInfo userIdentify = model.prototype();
		userInfoDao.save(userIdentify);
		return Result.success().setData(userIdentify);
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@Override
	@Transactional
	public Result update(UserInfoModel model){
		UserInfo userIdentify = userInfoDao.find(model.getId());
		model.setUpdateParam(userIdentify);//设置修改基本参数
		userInfoDao.update(userIdentify);	
		return Result.success();
	}
	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result getById(UserInfoModel model){
		if(model.getId() <= 0){
			return Result.error("参数错误！");
		}
		UserInfo userIdentify =userInfoDao.find(model.getId());		
		return Result.success().setData(userIdentify);
	}

}