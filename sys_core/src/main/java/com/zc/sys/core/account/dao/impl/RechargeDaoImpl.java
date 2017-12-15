package com.zc.sys.core.account.dao.impl;
import org.springframework.stereotype.Repository;
import com.zc.sys.common.dao.jpa.BaseDaoImpl;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.common.model.jpa.QueryParam;
import com.zc.sys.common.model.jpa.SearchFilter;
import com.zc.sys.common.model.jpa.OrderFilter.OrderType;
import com.zc.sys.common.model.jpa.SearchFilter.Operators;
import com.zc.sys.common.util.validate.StringUtil;
import com.zc.sys.core.account.entity.Recharge;
import com.zc.sys.core.account.model.RechargeModel;
import com.zc.sys.core.account.dao.RechargeDao;
/**
 * 充值
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Repository
public class RechargeDaoImpl extends BaseDaoImpl<Recharge> implements RechargeDao {

	@Override
	public PageDataList<Recharge> list(RechargeModel model) {
		QueryParam param = QueryParam.getInstance();
		if(StringUtil.isNotBlank(model.getSearchName())){
			SearchFilter orFilter1 = new SearchFilter("name", Operators.LIKE, model.getSearchName().trim());
			SearchFilter orFilter2 = new SearchFilter("nid", Operators.LIKE, model.getSearchName().trim());
			param.addOrFilter(orFilter1,orFilter2);
		}else {
			if (model.getState() != 0) {
				param.addParam("state", model.getState());
			}
		}
		param.addOrder(OrderType.ASC, "id");
		param.addPage(model.getPageNo(), model.getPageSize());
		return super.findPageList(param);
	}

}