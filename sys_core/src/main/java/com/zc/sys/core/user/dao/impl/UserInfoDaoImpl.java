package com.zc.sys.core.user.dao.impl;
import org.springframework.stereotype.Repository;
import com.zc.sys.common.dao.jpa.BaseDaoImpl;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.common.model.jpa.QueryParam;
import com.zc.sys.common.model.jpa.SearchFilter;
import com.zc.sys.common.model.jpa.OrderFilter.OrderType;
import com.zc.sys.common.model.jpa.SearchFilter.Operators;
import com.zc.sys.common.util.validate.StringUtil;
import com.zc.sys.core.user.entity.UserInfo;
import com.zc.sys.core.user.model.UserInfoModel;
import com.zc.sys.core.user.dao.UserInfoDao;
/**
 * 用户信息
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Repository
public class UserInfoDaoImpl extends BaseDaoImpl<UserInfo> implements UserInfoDao {

	@Override
	public PageDataList<UserInfo> list(UserInfoModel model) {
		// TODO Auto-generated method stub
		QueryParam param = QueryParam.getInstance();
		if(StringUtil.isNotBlank(model.getSearchName())){
			SearchFilter orFilter2 = new SearchFilter("name", Operators.LIKE, model.getSearchName().trim());
			param.addOrFilter(orFilter2);
		}
		param.addOrder(OrderType.ASC, "id");
		param.addPage(model.getPageNo(), model.getPageSize());
		return super.findPageList(param);
	}

}