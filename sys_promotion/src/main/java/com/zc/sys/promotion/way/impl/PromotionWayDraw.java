package com.zc.sys.promotion.way.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zc.sys.promotion.dao.PromotionPrizeRecordDao;
import com.zc.sys.promotion.model.PromotionModel;
import com.zc.sys.promotion.way.PromotionWayService;

/**
 * 活动推广奖励处理-抽奖
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月27日
 */
@Service("promotionWayRegDraw")
public class PromotionWayDraw implements PromotionWayService{

	@Resource
	private PromotionPrizeRecordDao promotionPrizeRecordDao;
	
	/**
	 * 推广处理
	 * @param model
	 * @param promotionPrizeConfig
	 */
	@Override
	@Transactional
	public void doPromotionPrize(PromotionModel model){
//		PromotionPrizeRecordModel prizeRecordModel = new PromotionPrizeRecordModel();
//		prizeRecordModel.initAdd(model,promotionPrizeConfig);//初始化信息
//		PromotionPrizeRecord prizeRecord = prizeRecordModel.prototype();
//		
//		prizeRecordModel.trfGiveOut(prizeRecord);//发放
//		
//		promotionPrizeRecordDao.save(prizeRecord);//保存记录
		
	}
	
}
