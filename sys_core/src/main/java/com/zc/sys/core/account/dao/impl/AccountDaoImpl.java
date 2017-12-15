package com.zc.sys.core.account.dao.impl;
import org.springframework.stereotype.Repository;
import com.zc.sys.common.dao.jpa.BaseDaoImpl;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.common.model.jpa.QueryParam;
import com.zc.sys.common.model.jpa.SearchFilter;
import com.zc.sys.common.model.jpa.OrderFilter.OrderType;
import com.zc.sys.common.model.jpa.SearchFilter.Operators;
import com.zc.sys.common.util.validate.StringUtil;
import com.zc.sys.core.account.entity.Account;
import com.zc.sys.core.account.model.AccountModel;
import com.zc.sys.core.account.dao.AccountDao;
/**
 * 资金账户
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Repository
public class AccountDaoImpl extends BaseDaoImpl<Account> implements AccountDao {

	@Override
	public PageDataList<Account> list(AccountModel model) {
		QueryParam param = QueryParam.getInstance();
		if(StringUtil.isNotBlank(model.getSearchName())){
			SearchFilter orFilter1 = new SearchFilter("version", Operators.LIKE, model.getSearchName().trim());
			SearchFilter orFilter2 = new SearchFilter("total", Operators.LIKE, model.getSearchName().trim());
			param.addOrFilter(orFilter1,orFilter2);
		}
		param.addOrder(OrderType.ASC, "id");
		param.addPage(model.getPageNo(), model.getPageSize());
		return super.findPageList(param);
	}

}