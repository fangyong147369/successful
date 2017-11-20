package com.zc.sys.promotion.controller;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zc.sys.common.exception.BusinessException;
import com.zc.sys.core.common.web.BaseController;
import com.zc.sys.promotion.model.PromotionPrizeConfigModel;
import com.zc.sys.promotion.service.PromotionPrizeConfigService;
/**
 * 活动推广奖励配置
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@RestController
@RequestMapping("/pt/promotionprizeconfig")
public class PromotionPrizeConfigController extends BaseController<PromotionPrizeConfigModel> {

	@Resource
	PromotionPrizeConfigService promotionPrizeConfigService;

	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Object list(PromotionPrizeConfigModel model) throws BusinessException {
		return promotionPrizeConfigService.list(model);
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Object add(PromotionPrizeConfigModel model) throws BusinessException {
		return promotionPrizeConfigService.add(model);
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Object update(PromotionPrizeConfigModel model) throws BusinessException {
		return promotionPrizeConfigService.update(model);
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/getById", method = RequestMethod.POST)
	@ResponseBody
	public Object getById(PromotionPrizeConfigModel model) throws BusinessException {
		return promotionPrizeConfigService.getById(model);
	}
}