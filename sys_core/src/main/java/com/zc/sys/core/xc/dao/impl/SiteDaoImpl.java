package com.zc.sys.core.xc.dao.impl;
import org.springframework.stereotype.Repository;
import com.zc.sys.common.dao.jpa.BaseDaoImpl;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.common.model.jpa.QueryParam;
import com.zc.sys.common.model.jpa.SearchFilter;
import com.zc.sys.common.model.jpa.OrderFilter.OrderType;
import com.zc.sys.common.model.jpa.SearchFilter.Operators;
import com.zc.sys.common.util.validate.StringUtil;
import com.zc.sys.core.xc.entity.Site;
import com.zc.sys.core.xc.model.SiteModel;
import com.zc.sys.core.xc.dao.SiteDao;
/**
 * 栏目
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Repository
public class SiteDaoImpl extends BaseDaoImpl<Site> implements SiteDao {
	/**
	 * 列表
	 * @param model
	 * @return
	 */
	@Override
	public PageDataList<Site> list(SiteModel model) {
		// TODO Auto-generated method stub
		QueryParam param = QueryParam.getInstance();
		if(StringUtil.isNotBlank(model.getSearchName())){
			SearchFilter orFilter2 = new SearchFilter("name", Operators.LIKE, model.getSearchName().trim());
			param.addOrFilter(orFilter2);
		}else {
			if (StringUtil.isNotBlank(model.getName())) {
				param.addParam("name", Operators.LIKE, model.getName().trim());
			}
			if (model.getPid() > 0) {
				param.addParam("pid", model.getPid());
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