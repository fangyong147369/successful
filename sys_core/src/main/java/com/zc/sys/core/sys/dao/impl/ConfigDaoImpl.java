package com.zc.sys.core.sys.dao.impl;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.zc.sys.common.dao.jpa.BaseDaoImpl;
import com.zc.sys.common.model.jpa.OrderFilter.OrderType;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.common.model.jpa.QueryParam;
import com.zc.sys.common.model.jpa.SearchFilter;
import com.zc.sys.common.model.jpa.SearchFilter.Operators;
import com.zc.sys.common.util.log.LogUtil;
import com.zc.sys.common.util.validate.StringUtil;
import com.zc.sys.core.sys.dao.ConfigDao;
import com.zc.sys.core.sys.entity.Config;
import com.zc.sys.core.sys.model.ConfigModel;
/**
 * 系统参数配置
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月08日
 */
@Repository
public class ConfigDaoImpl extends BaseDaoImpl<Config> implements ConfigDao {

	@Override
	public PageDataList<Config> list(ConfigModel model) {
		QueryParam param = QueryParam.getInstance();
		if (model != null) {
			if(StringUtil.isNotBlank(model.getSearchName())){//模糊查询条件
				SearchFilter orFilter1 = new SearchFilter("name", Operators.LIKE, model.getSearchName().trim());
				SearchFilter orFilter2 = new SearchFilter("nid", Operators.LIKE, model.getSearchName().trim());
				param.addOrFilter(orFilter1, orFilter2);
			}else{ //精确查询条件
				if (model.getState() !=0 &&model.getState() != 99) {
					param.addParam("status", model.getState());
				}
				if (model.getType() != 0 &&model.getType() != 99) {
					param.addParam("type", model.getType());
				}
				if (StringUtil.isNotBlank(model.getName())) {
					param.addParam("name", Operators.LIKE, model.getName().trim());
				}
				if (StringUtil.isNotBlank(model.getNid())) {
					param.addParam("nid", Operators.LIKE, model.getNid());
				}
			}
			param.addPage(model.getPageNo(), model.getPageSize());
		}
		param.addOrder(OrderType.ASC, "id");
		return super.findPageList(param);
	}

	@Override
	public ConfigModel getConfig() {
		List<Config> list = this.findByProperty("state", 1);
		ConfigModel config = new ConfigModel(list.size());
		for (int i = 0; i < list.size(); i++) {
			Config sys = (Config) list.get(i);
			LogUtil.debug(sys.getId() + " " + sys.getValue());
			config.addConfig(sys);
			config.setConfigNid(i, sys.getNid());
		}
		return config;
	}
	
}