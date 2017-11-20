package com.zc.sys.api.zc.credit;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zc.sys.common.exception.BusinessException;
import com.zc.sys.core.common.web.BaseController;
import com.zc.sys.core.credit.model.CreditScoreLogModel;
import com.zc.sys.core.credit.service.CreditScoreLogService;
/**
 * 信用分账户
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@RestController
@RequestMapping("/cs/creditscorelog")
public class CreditScoreLogController extends BaseController<CreditScoreLogModel> {

	@Resource
	CreditScoreLogService creditScoreLogService;

	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Object list(CreditScoreLogModel model) throws BusinessException {
		return creditScoreLogService.list(model);
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Object add(CreditScoreLogModel model) throws BusinessException {
		return creditScoreLogService.add(model);
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Object update(CreditScoreLogModel model) throws BusinessException {
		return creditScoreLogService.update(model);
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/getById", method = RequestMethod.POST)
	@ResponseBody
	public Object getById(CreditScoreLogModel model) throws BusinessException {
		return creditScoreLogService.getById(model);
	}
}