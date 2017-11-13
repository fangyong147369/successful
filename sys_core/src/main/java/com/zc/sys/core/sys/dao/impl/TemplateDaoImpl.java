package com.zc.sys.core.sys.dao.impl;
import org.springframework.stereotype.Repository;

import com.zc.sys.common.dao.jpa.BaseDaoImpl;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.common.model.jpa.QueryParam;
import com.zc.sys.common.model.jpa.SearchFilter;
import com.zc.sys.common.model.jpa.OrderFilter.OrderType;
import com.zc.sys.common.model.jpa.SearchFilter.Operators;
import com.zc.sys.common.util.validate.StringUtil;
import com.zc.sys.core.sys.entity.Template;
import com.zc.sys.core.sys.model.TemplateModel;
import com.zc.sys.core.sys.dao.TemplateDao;
/**
 * 模版配置
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月08日
 */
@Repository
public class TemplateDaoImpl extends BaseDaoImpl<Template> implements TemplateDao {

	/**
	 * 列表
	 * @param model
	 * @return
	 */
	@Override
	public PageDataList<Template> list(TemplateModel model) {
		QueryParam param = QueryParam.getInstance();
		if(StringUtil.isNotBlank(model.getSearchName())){
			SearchFilter orFilter1 = new SearchFilter("name", Operators.LIKE, model.getSearchName().trim());
			SearchFilter orFilter2 = new SearchFilter("nid", Operators.LIKE, model.getSearchName().trim());
			param.addOrFilter(orFilter1,orFilter2);
		}else {
			if (StringUtil.isNotBlank(model.getName())) {
				param.addParam("name", Operators.LIKE, model.getName().trim());
			}
			if (model.getState() != null) {
				param.addParam("state", model.getState());
			}
		}
		param.addOrder(OrderType.ASC, "id");
		param.addPage(model.getPageNo(), model.getPageSize());
		return super.findPageList(param);
	}

}