package com.zc.sys.core.user.dao.impl;
import org.springframework.stereotype.Repository;
import com.zc.sys.common.dao.jpa.BaseDaoImpl;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.common.model.jpa.QueryParam;
import com.zc.sys.common.model.jpa.SearchFilter;
import com.zc.sys.common.model.jpa.OrderFilter.OrderType;
import com.zc.sys.common.model.jpa.SearchFilter.Operators;
import com.zc.sys.common.util.validate.StringUtil;
import com.zc.sys.core.user.dao.UserDao;
import com.zc.sys.core.user.entity.User;
import com.zc.sys.core.user.model.UserModel;
/**
 * 用户
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	public PageDataList<User> list(UserModel model) {
		// TODO Auto-generated method stub
				QueryParam param = QueryParam.getInstance();
				if(StringUtil.isNotBlank(model.getSearchName())){
					SearchFilter orFilter2 = new SearchFilter("name", Operators.LIKE, model.getSearchName().trim());
					param.addOrFilter(orFilter2);
				}else {
					if (StringUtil.isNotBlank(model.getLoginName())) {
						param.addParam("LoginName", Operators.LIKE, model.getLoginName().trim());
					}			
					if (model.getMobileState() != 0) {
						param.addParam("MobileState", model.getMobileState());
					}
				}
				param.addOrder(OrderType.ASC, "id");
				param.addPage(model.getPageNo(), model.getPageSize());
				return super.findPageList(param);
	}

}