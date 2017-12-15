package com.zc.sys.core.account.dao;
import com.zc.sys.common.dao.BaseDao;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.core.account.entity.Account;
import com.zc.sys.core.account.model.AccountModel;
/**
 * 资金账户
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public interface AccountDao extends BaseDao<Account> {
	/**
	 * 列表
	 * @param model
	 * @return
	 */
	PageDataList<Account> list( AccountModel model);
}