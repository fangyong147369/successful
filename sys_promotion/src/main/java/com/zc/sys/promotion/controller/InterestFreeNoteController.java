package com.zc.sys.promotion.controller;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zc.sys.common.exception.BusinessException;
import com.zc.sys.core.common.web.BaseController;
import com.zc.sys.promotion.model.InterestFreeNoteModel;
import com.zc.sys.promotion.service.InterestFreeNoteService;
/**
 * 免息券
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@RestController
@RequestMapping("/pt/interestfreenote")
public class InterestFreeNoteController extends BaseController<InterestFreeNoteModel> {

	@Resource
	InterestFreeNoteService interestFreeNoteService;

	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Object list(InterestFreeNoteModel model) throws BusinessException {
		return interestFreeNoteService.list(model);
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Object add(InterestFreeNoteModel model) throws BusinessException {
		return interestFreeNoteService.add(model);
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Object update(InterestFreeNoteModel model) throws BusinessException {
		return interestFreeNoteService.update(model);
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/getById", method = RequestMethod.POST)
	@ResponseBody
	public Object getById(InterestFreeNoteModel model) throws BusinessException {
		return interestFreeNoteService.getById(model);
	}
}