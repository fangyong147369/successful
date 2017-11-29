package com.zc.sys.promotion.dao;
import java.util.List;

import com.zc.sys.common.dao.BaseDao;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.promotion.entity.Promotion;
import com.zc.sys.promotion.model.PromotionModel;
/**
 * 活动推广
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public interface PromotionDao extends BaseDao<Promotion> {

	/**
	 * 列表
	 * @param model
	 * @return
	 */
	PageDataList<Promotion> list(PromotionModel model);

	/**
	 * 查询使用中的
	 * @param pModel
	 * @return
	 */
	List<Promotion> findUse(PromotionModel model);
	
}