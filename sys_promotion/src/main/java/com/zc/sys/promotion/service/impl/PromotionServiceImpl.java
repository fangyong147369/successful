package com.zc.sys.promotion.service.impl;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zc.sys.common.form.Result;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.promotion.dao.PromotionDao;
import com.zc.sys.promotion.entity.Promotion;
import com.zc.sys.promotion.model.PromotionModel;
import com.zc.sys.promotion.service.PromotionService;
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
	public Result update(PromotionModel model){
		
		return null;
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result getById(PromotionModel model){

		return null;
	}

}