package com.zc.sys.api.zc.user;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zc.sys.common.exception.BusinessException;
import com.zc.sys.core.common.web.BaseController;
import com.zc.sys.core.user.model.UserInfoModel;
import com.zc.sys.core.user.service.UserInfoService;
/**
 * 用户信息
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@RestController
@RequestMapping("/u/userinfo")
public class UserInfoController extends BaseController<UserInfoModel> {

	@Resource
	UserInfoService userInfoService;

	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Object list(UserInfoModel model) throws BusinessException {
		return userInfoService.list(model);
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Object add(UserInfoModel model) throws BusinessException {
		return userInfoService.add(model);
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Object update(UserInfoModel model) throws BusinessException {
		return userInfoService.update(model);
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/getById", method = RequestMethod.POST)
	@ResponseBody
	public Object getById(UserInfoModel model) throws BusinessException {
		return userInfoService.getById(model);
	}
}