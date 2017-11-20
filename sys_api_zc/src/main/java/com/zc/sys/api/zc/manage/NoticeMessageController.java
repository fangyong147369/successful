package com.zc.sys.api.zc.manage;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zc.sys.common.exception.BusinessException;
import com.zc.sys.core.common.web.BaseController;
import com.zc.sys.core.manage.model.NoticeMessageModel;
import com.zc.sys.core.manage.service.NoticeMessageService;
/**
 * 通知消息
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月15日
 */
@RestController
@RequestMapping("/m/noticemessage")
public class NoticeMessageController extends BaseController<NoticeMessageModel> {

	@Resource
	NoticeMessageService noticeMessageService;

	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Object list(NoticeMessageModel model) throws BusinessException {
		return noticeMessageService.list(model);
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Object add(NoticeMessageModel model) throws BusinessException {
		return noticeMessageService.add(model);
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Object update(NoticeMessageModel model) throws BusinessException {
		return noticeMessageService.update(model);
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/getById", method = RequestMethod.POST)
	@ResponseBody
	public Object getById(NoticeMessageModel model) throws BusinessException {
		return noticeMessageService.getById(model);
	}
}