package com.zc.sys.api.zc.integral;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zc.sys.common.exception.BussinessException;
import com.zc.sys.core.common.web.BaseController;
import com.zc.sys.core.integral.model.IntegralLogModel;
import com.zc.sys.core.integral.service.IntegralLogService;
/**
 * 积分日志
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@RestController
@RequestMapping("/jf/integrallog")
public class IntegralLogController extends BaseController<IntegralLogModel> {

	@Resource
	IntegralLogService integralLogService;

	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Object list(IntegralLogModel model) throws BussinessException {
		return integralLogService.list(model);
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Object add(IntegralLogModel model) throws BussinessException {
		return integralLogService.add(model);
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Object update(IntegralLogModel model) throws BussinessException {
		return integralLogService.update(model);
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/getById", method = RequestMethod.POST)
	@ResponseBody
	public Object getById(IntegralLogModel model) throws BussinessException {
		return integralLogService.getById(model);
	}
}