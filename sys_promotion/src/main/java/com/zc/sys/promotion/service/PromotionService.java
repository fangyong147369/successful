package com.zc.sys.promotion.service;
import com.zc.sys.promotion.model.PromotionModel;
import com.zc.sys.common.form.Result;
/**
 * 活动推广
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public interface PromotionService{

	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	public Result list(PromotionModel model);

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	public Result add(PromotionModel model);

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	public Result update(PromotionModel model);

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	public Result getById(PromotionModel model);

}