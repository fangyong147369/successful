package com.zc.sys.core.user.dao.impl;
import org.springframework.stereotype.Repository;

import com.zc.sys.common.dao.jpa.BaseDaoImpl;
import com.zc.sys.common.model.jpa.QueryParam;
import com.zc.sys.common.util.validate.StringUtil;
import com.zc.sys.core.user.dao.UserIdentifyDao;
import com.zc.sys.core.user.entity.UserIdentify;
import com.zc.sys.core.user.model.UserIdentifyModel;
/**
 * 用户认证
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Repository
public class UserIdentifyDaoImpl extends BaseDaoImpl<UserIdentify> implements UserIdentifyDao {

	/**
	 * 计数
	 * @param model
	 * @return
	 */
	@Override
	public int countByModel(UserIdentifyModel model) {
		QueryParam param = QueryParam.getInstance();
		if (model != null) {
			if (!StringUtil.isBlank(model.getMobile())) {
				param.addParam("user.mobile", model.getMobile());
			}
			if(!StringUtil.isBlank(model.getCardNo())){
				param.addParam("user.cardNo", model.getCardNo());
			}
			if(model.getRealNameState() != 0){
				param.addParam("realNameState", model.getRealNameState());
			}
		}
		return super.countByCriteria(param);
	}
}