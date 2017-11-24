package com.zc.sys.core.sys.dao.impl;

import org.springframework.stereotype.Repository;
import com.zc.sys.common.dao.jpa.BaseDaoImpl;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.common.model.jpa.QueryParam;
import com.zc.sys.common.model.jpa.SearchFilter;
import com.zc.sys.common.model.jpa.OrderFilter.OrderType;
import com.zc.sys.common.model.jpa.SearchFilter.Operators;
import com.zc.sys.common.util.validate.StringUtil;
import com.zc.sys.core.sys.entity.Menu;
import com.zc.sys.core.sys.model.MenuModel;
import com.zc.sys.core.sys.dao.MenuDao;

/**
 * 菜单
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Repository
public class MenuDaoImpl extends BaseDaoImpl<Menu> implements MenuDao {

	/**
	 * 列表
	 * @param model
	 * @return
	 */
	@Override
	public PageDataList<Menu> list(MenuModel model) {
		QueryParam param = QueryParam.getInstance();
		if(StringUtil.isNotBlank(model.getSearchName())){
			SearchFilter orFilter2 = new SearchFilter("name", Operators.LIKE, model.getSearchName().trim());
			param.addOrFilter(orFilter2);
		}else {
			if (StringUtil.isNotBlank(model.getName())) {
				param.addParam("name", Operators.LIKE, model.getName().trim());
			}
			if (model.getParentId() > 0) {
				param.addParam("parentId", model.getParentId());
			}
			if (model.getState() != 0) {
				param.addParam("state", model.getState());
			}
		}
		param.addOrder(OrderType.ASC, "id");
		param.addPage(model.getPageNo(), model.getPageSize());
		return super.findPageList(param);
	}

}