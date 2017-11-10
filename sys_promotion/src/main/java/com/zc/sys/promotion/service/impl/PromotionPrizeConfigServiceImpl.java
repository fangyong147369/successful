package com.zc.sys.promotion.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zc.sys.common.form.Result;
import com.zc.sys.promotion.dao.PromotionPrizeConfigDao;
import com.zc.sys.promotion.model.PromotionPrizeConfigModel;
import com.zc.sys.promotion.service.PromotionPrizeConfigService;
/**
 * 活动推广奖励配置
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Service
public class PromotionPrizeConfigServiceImpl implements PromotionPrizeConfigService {

	@Resource
	private PromotionPrizeConfigDao promotionPrizeConfigDao;
	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result list(PromotionPrizeConfigModel model){

		return null;
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result add(PromotionPrizeConfigModel model){

		return null;
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result update(PromotionPrizeConfigModel model){

		return null;
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result getById(PromotionPrizeConfigModel model){

		return null;
	}

}