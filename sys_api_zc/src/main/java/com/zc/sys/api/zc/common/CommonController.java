package com.zc.sys.api.zc.common;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zc.sys.common.exception.BussinessException;
import com.zc.sys.core.common.model.CommonModel;
import com.zc.sys.core.common.service.CommonService;
import com.zc.sys.core.common.web.BaseController;
/**
 * 公共接口
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@RestController
@RequestMapping("/common")
public class CommonController extends BaseController<CommonModel> {

	@Resource
	CommonService commonService;

	/**
 	 * 生成唯一请求标识
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/getToken", method = RequestMethod.POST)
	@ResponseBody
	public Object getToken(CommonModel model) throws BussinessException {
		return commonService.getToken();
	}
	
	/**
	 * 发送短信验证码
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/getSMSCode", method = RequestMethod.POST)
	@ResponseBody
	public Object getSMSCode(CommonModel model) throws BussinessException {
		return commonService.getSMSCode(model);
	}

}