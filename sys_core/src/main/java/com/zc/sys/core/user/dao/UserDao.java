package com.zc.sys.core.user.dao;
import com.zc.sys.common.dao.BaseDao;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.core.user.entity.User;
import com.zc.sys.core.user.model.UserModel;
/**
 * 用户
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public interface UserDao extends BaseDao<User> {
	/**
	 * 列表
	 * @param model
	 * @return
	 */
	PageDataList<User> list(UserModel model);	
}