package com.zc.sys.promotion.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zc.sys.common.form.Result;
import com.zc.sys.promotion.dao.PromotionPrizeRecordDao;
import com.zc.sys.promotion.model.PromotionPrizeRecordModel;
import com.zc.sys.promotion.service.PromotionPrizeRecordService;
/**
 * 活动推广奖励记录
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Service
public class PromotionPrizeRecordServiceImpl implements PromotionPrizeRecordService {

	@Resource
	private PromotionPrizeRecordDao promotionPrizeRecordDao;
	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result list(PromotionPrizeRecordModel model){

		return null;
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result add(PromotionPrizeRecordModel model){

		return null;
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result update(PromotionPrizeRecordModel model){

		return null;
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result getById(PromotionPrizeRecordModel model){

		return null;
	}

}