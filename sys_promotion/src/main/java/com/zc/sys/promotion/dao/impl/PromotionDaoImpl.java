package com.zc.sys.promotion.dao.impl;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.zc.sys.common.dao.jpa.BaseDaoImpl;
import com.zc.sys.common.model.jpa.OrderFilter.OrderType;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.common.model.jpa.QueryParam;
import com.zc.sys.common.model.jpa.SearchFilter;
import com.zc.sys.common.model.jpa.SearchFilter.Operators;
import com.zc.sys.common.util.date.DateUtil;
import com.zc.sys.common.util.validate.StringUtil;
import com.zc.sys.core.common.constant.BaseConstant;
import com.zc.sys.promotion.dao.PromotionDao;
import com.zc.sys.promotion.entity.Promotion;
import com.zc.sys.promotion.model.PromotionModel;
/**
 * 活动推广
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Repository
public class PromotionDaoImpl extends BaseDaoImpl<Promotion> implements PromotionDao {

	/**
	 * 列表
	 * @param model
	 * @return
	 */
	@Override
	public PageDataList<Promotion> list(PromotionModel model) {
		QueryParam param = QueryParam.getInstance();
		if(StringUtil.isNotBlank(model.getSearchName())){
			SearchFilter orFilter1 = new SearchFilter("name", Operators.LIKE, model.getSearchName().trim());
			SearchFilter orFilter2 = new SearchFilter("nid", Operators.LIKE, model.getSearchName().trim());
			param.addOrFilter(orFilter1,orFilter2);
		}else {
			if (StringUtil.isNotBlank(model.getName())) {
				param.addParam("name", Operators.LIKE, model.getName().trim());
			}
			if (model.getState() != 0) {
				param.addParam("state", model.getState());
			}
		}
		param.addOrder(OrderType.ASC, "id");
		param.addPage(model.getPageNo(), model.getPageSize());
		return super.findPageList(param);
	}

	/**
	 * 查询使用中的
	 * @param pModel
	 * @return
	 */
	@Override
	public List<Promotion> findUse(PromotionModel model) {
		QueryParam param = QueryParam.getInstance();
		param.addParam("state", BaseConstant.INFO_STATE_YES);
		param.addParam("way", model.getWay());
		param.addParam("endTime",Operators.GT, DateUtil.getNow());
		return super.findByCriteria(param);
	}

}