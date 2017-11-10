package com.zc.sys.promotion.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zc.sys.common.form.Result;
import com.zc.sys.promotion.dao.PromotionDao;
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

		return null;
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result add(PromotionModel model){

		return null;
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