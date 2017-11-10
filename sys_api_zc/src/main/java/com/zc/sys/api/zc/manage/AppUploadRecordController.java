package com.zc.sys.api.zc.manage;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zc.sys.common.exception.BussinessException;
import com.zc.sys.core.common.web.BaseController;
import com.zc.sys.core.manage.model.AppUploadRecordModel;
import com.zc.sys.core.manage.service.AppUploadRecordService;
/**
 * 安卓包上传记录
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@RestController
@RequestMapping("/m/appuploadrecord")
public class AppUploadRecordController extends BaseController<AppUploadRecordModel> {

	@Resource
	AppUploadRecordService appUploadRecordService;

	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Object list(AppUploadRecordModel model) throws BussinessException {
		return appUploadRecordService.list(model);
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Object add(AppUploadRecordModel model) throws BussinessException {
		return appUploadRecordService.add(model);
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Object update(AppUploadRecordModel model) throws BussinessException {
		return appUploadRecordService.update(model);
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/getById", method = RequestMethod.POST)
	@ResponseBody
	public Object getById(AppUploadRecordModel model) throws BussinessException {
		return appUploadRecordService.getById(model);
	}
}