package com.zc.sys.core.account.dao;
import com.zc.sys.common.dao.BaseDao;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.core.account.entity.Recharge;
import com.zc.sys.core.account.model.RechargeModel;
/**
 * 充值
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public interface RechargeDao extends BaseDao<Recharge> {
	/**
	 * 列表
	 * @param model
	 * @return
	 */
	PageDataList<Recharge> list(RechargeModel model);
}