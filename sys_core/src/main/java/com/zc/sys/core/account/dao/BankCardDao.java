package com.zc.sys.core.account.dao;
import com.zc.sys.common.dao.BaseDao;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.core.account.entity.BankCard;
import com.zc.sys.core.account.model.BankCardModel;
/**
 * 银行卡
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public interface BankCardDao extends BaseDao<BankCard> {
	
	/**
	 * 列表
	 * @param model
	 * @return
	 */
	PageDataList<BankCard> list(BankCardModel model);
}