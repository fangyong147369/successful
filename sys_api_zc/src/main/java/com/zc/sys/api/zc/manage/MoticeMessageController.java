package com.zc.sys.api.zc.manage;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zc.sys.common.exception.BussinessException;
import com.zc.sys.core.common.web.BaseController;
import com.zc.sys.core.manage.model.MoticeMessageModel;
import com.zc.sys.core.manage.service.MoticeMessageService;
/**
 * 通知消息
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@RestController
@RequestMapping("/m/moticemessage")
public class MoticeMessageController extends BaseController<MoticeMessageModel> {

	@Resource
	MoticeMessageService moticeMessageService;

	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Object list(MoticeMessageModel model) throws BussinessException {
		return moticeMessageService.list(model);
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Object add(MoticeMessageModel model) throws BussinessException {
		return moticeMessageService.add(model);
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Object update(MoticeMessageModel model) throws BussinessException {
		return moticeMessageService.update(model);
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/getById", method = RequestMethod.POST)
	@ResponseBody
	public Object getById(MoticeMessageModel model) throws BussinessException {
		return moticeMessageService.getById(model);
	}
}