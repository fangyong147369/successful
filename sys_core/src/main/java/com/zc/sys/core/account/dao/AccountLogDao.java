package com.zc.sys.core.account.dao;
import com.zc.sys.common.dao.BaseDao;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.core.account.entity.AccountLog;
import com.zc.sys.core.account.model.AccountLogModel;
/**
 * 资金日志
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public interface AccountLogDao extends BaseDao<AccountLog> {
	/**
	 * 列表
	 * @param model
	 * @return
	 */
	PageDataList<AccountLog> list(AccountLogModel model);
}