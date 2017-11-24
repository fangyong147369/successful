package com.zc.sys.cashloan.dao.impl;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.zc.sys.cashloan.dao.CashLoanRepaymentDao;
import com.zc.sys.cashloan.entity.CashLoanRepayment;
import com.zc.sys.cashloan.model.CashLoanRepaymentModel;
import com.zc.sys.common.dao.jpa.BaseDaoImpl;
import com.zc.sys.common.model.jpa.OrderFilter.OrderType;
import com.zc.sys.common.model.jpa.SearchFilter.Operators;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.common.model.jpa.QueryParam;
import com.zc.sys.common.util.validate.StringUtil;
import com.zc.sys.core.common.constant.BaseConstant;
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
			if (model.getState() != 0) {
				param.addParam("state", model.getState());
			}
		}
		param.addOrder(OrderType.ASC, "id");
		param.addPage(model.getPageNo(), model.getPageSize());
		return super.findPageList(param);
	}

	/**
	 * 当前是否为最近还款
	 * @param period
	 * @param cashLoanId
	 * @return
	 */
	@Override
	public boolean isCurrentRepayment(int period, long cashLoanId) {
		boolean flag = false;
		if(period == 1){//第一期一定为最新
			return true;
		}
		QueryParam param = QueryParam.getInstance();
		param.addParam("cashLoan.id", cashLoanId);
		param.addParam("period", period - 1);//查询上一期
		param.addParam("state", Operators.NOTEQ, BaseConstant.BUSINESS_STATE_YES);//未还款状态
		List<CashLoanRepayment> list = this.findByCriteria(param);
		if(list.size() <= 0){//上期无代还款
			flag = true;
		}
		return flag;
	}

}