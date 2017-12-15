package com.zc.sys.core.user.dao;
import com.zc.sys.common.dao.BaseDao;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.core.user.entity.UserIdentify;
import com.zc.sys.core.user.model.UserIdentifyModel;
/**
 * 用户认证
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public interface UserIdentifyDao extends BaseDao<UserIdentify> {
	
	/**
	 * 计数
	 * @param model
	 * @return
	 */
	int countByModel(UserIdentifyModel model);
	/**
	 * 列表
	 * @param model
	 * @return
	 */
	PageDataList<UserIdentify> list(UserIdentifyModel model);
	
}