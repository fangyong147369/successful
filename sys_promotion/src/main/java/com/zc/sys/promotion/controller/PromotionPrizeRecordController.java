package com.zc.sys.promotion.controller;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zc.sys.common.exception.BussinessException;
import com.zc.sys.core.common.web.BaseController;
import com.zc.sys.promotion.model.PromotionPrizeRecordModel;
import com.zc.sys.promotion.service.PromotionPrizeRecordService;
/**
 * 活动推广奖励记录
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@RestController
@RequestMapping("/pt/promotionprizerecord")
public class PromotionPrizeRecordController extends BaseController<PromotionPrizeRecordModel> {

	@Resource
	PromotionPrizeRecordService promotionPrizeRecordService;

	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Object list(PromotionPrizeRecordModel model) throws BussinessException {
		return promotionPrizeRecordService.list(model);
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Object add(PromotionPrizeRecordModel model) throws BussinessException {
		return promotionPrizeRecordService.add(model);
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Object update(PromotionPrizeRecordModel model) throws BussinessException {
		return promotionPrizeRecordService.update(model);
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/getById", method = RequestMethod.POST)
	@ResponseBody
	public Object getById(PromotionPrizeRecordModel model) throws BussinessException {
		return promotionPrizeRecordService.getById(model);
	}
}