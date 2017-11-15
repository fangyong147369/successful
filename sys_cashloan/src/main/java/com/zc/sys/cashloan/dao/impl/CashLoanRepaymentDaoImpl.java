package com.zc.sys.cashloan.dao.impl;
import org.springframework.stereotype.Repository;

import com.zc.sys.common.dao.jpa.BaseDaoImpl;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.common.model.jpa.QueryParam;
import com.zc.sys.common.model.jpa.SearchFilter;
import com.zc.sys.common.model.jpa.OrderFilter.OrderType;
import com.zc.sys.common.model.jpa.SearchFilter.Operators;
import com.zc.sys.common.util.validate.StringUtil;
import com.zc.sys.cashloan.entity.CashLoanRepayment;
import com.zc.sys.cashloan.model.CashLoanRepaymentModel;
import com.zc.sys.cashloan.dao.CashLoanRepaymentDao;
/**
 * 现金贷还款计划
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Repository
public class CashLoanRepaymentDaoImpl extends BaseDaoImpl<CashLoanRepayment> implements CashLoanRepaymentDao {

	/**
	 * 列表
	 * @param model
	 * @return
	 */
	@Override
	public PageDataList<CashLoanRepayment> list(CashLoanRepaymentModel model) {
		QueryParam param = QueryParam.getInstance();
		if(StringUtil.isNotBlank(model.getSearchName())){
			/*SearchFilter orFilter1 = new SearchFilter("name", Operators.LIKE, model.getSearchName().trim());
			param.addOrFilter(orFilter1);*/
		}else {
			if (model.getState() != null) {
				param.addParam("state", model.getState());
			}
		}
		param.addOrder(OrderType.ASC, "id");
		param.addPage(model.getPageNo(), model.getPageSize());
		return super.findPageList(param);
	}

}