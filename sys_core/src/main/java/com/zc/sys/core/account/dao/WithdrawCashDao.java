package com.zc.sys.core.account.dao;
import com.zc.sys.common.dao.BaseDao;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.core.account.entity.WithdrawCash;
import com.zc.sys.core.account.model.WithdrawCashModel;
/**
 * 提现
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public interface WithdrawCashDao extends BaseDao<WithdrawCash> {
	/**
	 * 列表
	 * @param model
	 * @return
	 */
	PageDataList<WithdrawCash> list(WithdrawCashModel model);
}