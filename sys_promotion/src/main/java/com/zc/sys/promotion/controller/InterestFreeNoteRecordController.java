package com.zc.sys.promotion.controller;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zc.sys.common.exception.BussinessException;
import com.zc.sys.core.common.web.BaseController;
import com.zc.sys.promotion.model.InterestFreeNoteRecordModel;
import com.zc.sys.promotion.service.InterestFreeNoteRecordService;
/**
 * 免息券发放记录
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@RestController
@RequestMapping("/pt/interestfreenoterecord")
public class InterestFreeNoteRecordController extends BaseController<InterestFreeNoteRecordModel> {

	@Resource
	InterestFreeNoteRecordService interestFreeNoteRecordService;

	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Object list(InterestFreeNoteRecordModel model) throws BussinessException {
		return interestFreeNoteRecordService.list(model);
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Object add(InterestFreeNoteRecordModel model) throws BussinessException {
		return interestFreeNoteRecordService.add(model);
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Object update(InterestFreeNoteRecordModel model) throws BussinessException {
		return interestFreeNoteRecordService.update(model);
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/getById", method = RequestMethod.POST)
	@ResponseBody
	public Object getById(InterestFreeNoteRecordModel model) throws BussinessException {
		return interestFreeNoteRecordService.getById(model);
	}
}