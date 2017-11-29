package com.zc.sys.promotion.service.impl;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zc.sys.common.exception.BusinessException;
import com.zc.sys.common.form.Result;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.core.common.global.BeanUtil;
import com.zc.sys.promotion.constant.BasePromotionConstant.PromotionWay;
import com.zc.sys.promotion.dao.PromotionDao;
import com.zc.sys.promotion.entity.Promotion;
import com.zc.sys.promotion.model.PromotionModel;
import com.zc.sys.promotion.service.PromotionService;
import com.zc.sys.promotion.way.PromotionWayService;
/**
 * 活动推广
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Service
public class PromotionServiceImpl implements PromotionService {

	@Resource
	private PromotionDao promotionDao;
	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result list(PromotionModel model){
		PageDataList<Promotion> pageDataList = promotionDao.list(model);
		PageDataList<PromotionModel> pageDataList_ = new PageDataList<PromotionModel>();
		pageDataList_.setPage(pageDataList.getPage());
		List<PromotionModel> list = new ArrayList<PromotionModel>();
		if(pageDataList != null && pageDataList.getList().size() > 0){
			for (Promotion promotion : pageDataList.getList()) {
				PromotionModel model_ = PromotionModel.instance(promotion);
				list.add(model_);
			}
		}
		pageDataList_.setList(list);
		return Result.success().setData(pageDataList_);
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@Override
	@Transactional
	public Result add(PromotionModel model){
		model.validAdd();//校验添加参数
		model.initAdd();//初始化添加
		Promotion promotion = model.prototype();
		promotionDao.save(promotion);
		return Result.success();
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@Override
	@Transactional
	public Result update(PromotionModel model){
		Promotion promotion = model.validUpdate();//校验修改参数
		model.initUpdate(promotion);//初始化修改
		promotionDao.update(promotion);
		return Result.success();
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result getById(PromotionModel model){
		if(model.getId() <= 0){
			throw new BusinessException("参数错误");
		}
		return Result.success().setData(promotionDao.find(model.getId()));
	}

	/**
	 * 活动处理
	 * @param model
	 */
	@Override
	@Transactional
	public void handlePromotion(PromotionModel model) {
		model.validParam();//参数校验
		model.initParam();//初始化参数
		List<Promotion> usePromotionList = promotionDao.findUse(model);
		if(usePromotionList.size() <= 0){
			throw new BusinessException("活动未配置");
		}
		
		//循环查询到的活动list
		for (Promotion promotion : usePromotionList) {
			for (PromotionWay promotionWay : PromotionWay.values()) {
				if(promotionWay.getIndex() == promotion.getWay()){
					model.setId(promotion.getId());
					PromotionWayService pwService = BeanUtil.getBean(promotionWay.toString());
					pwService.doPromotionPrize(model);
				}
			}
		}
	}
	
	

}