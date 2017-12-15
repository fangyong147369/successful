package com.zc.sys.core.user.dao;
import com.zc.sys.common.dao.BaseDao;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.core.user.entity.UserInfo;
import com.zc.sys.core.user.model.UserInfoModel;
/**
 * 用户信息
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public interface UserInfoDao extends BaseDao<UserInfo> {
	/**
	 * 列表
	 * @param model
	 * @return
	 */
	PageDataList<UserInfo> list(UserInfoModel model);		
}