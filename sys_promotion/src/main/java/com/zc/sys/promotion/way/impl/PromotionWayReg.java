package com.zc.sys.promotion.way.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zc.sys.core.common.constant.BaseConstant;
import com.zc.sys.promotion.dao.PromotionPrizeConfigDao;
import com.zc.sys.promotion.dao.PromotionPrizeRecordDao;
import com.zc.sys.promotion.entity.PromotionPrizeConfig;
import com.zc.sys.promotion.entity.PromotionPrizeRecord;
import com.zc.sys.promotion.model.PromotionModel;
import com.zc.sys.promotion.model.PromotionPrizeRecordModel;
import com.zc.sys.promotion.way.PromotionWayService;

/**
 * 活动推广奖励处理-注册
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月27日
 */
@Service("promotionWayReg")
public class PromotionWayReg implements PromotionWayService{

	@Resource
	private PromotionPrizeRecordDao promotionPrizeRecordDao;
	@Resource
	private PromotionPrizeConfigDao promotionPrizeConfigDao;
	
	/**
	 * 推广处理
	 * @param model
	 * @param promotionPrizeConfig
	 */
	@Override
	@Transactional
	public void doPromotionPrize(PromotionModel model){
		List<PromotionPrizeConfig> ppcList = promotionPrizeConfigDao.findByProperty("promotion.id", model.getId());
		//循环查找所有奖励配置
		for (PromotionPrizeConfig promotionPrizeConfig : ppcList) {
			if(promotionPrizeConfig.getState() == BaseConstant.INFO_STATE_YES){
				PromotionPrizeRecordModel prizeRecordModel = new PromotionPrizeRecordModel();
				prizeRecordModel.initAdd(model,promotionPrizeConfig);//初始化信息
				PromotionPrizeRecord prizeRecord = prizeRecordModel.prototype();
				promotionPrizeRecordDao.save(prizeRecord);//保存记录
				try {
					prizeRecordModel.trfGiveOut(prizeRecord);//发放
				} catch (Exception e) {
					prizeRecord.setRemark(e.getMessage());
					prizeRecord.setState(BaseConstant.BUSINESS_STATE_FAIL);
				}
			}
		}
		
	}
	
}
