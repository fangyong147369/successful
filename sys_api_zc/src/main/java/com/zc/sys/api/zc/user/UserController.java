package com.zc.sys.api.zc.user;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zc.sys.common.exception.BusinessException;
import com.zc.sys.core.common.web.BaseController;
import com.zc.sys.core.user.model.UserModel;
import com.zc.sys.core.user.service.UserService;
/**
 * 用户
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@RestController
@RequestMapping("/u/user")
public class UserController extends BaseController<UserModel> {

	@Resource
	UserService userService;

	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Object list(UserModel model) throws BusinessException {
		return userService.list(model);
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Object add(UserModel model) throws BusinessException {
		return userService.add(model);
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Object update(UserModel model) throws BusinessException {
		return userService.update(model);
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/getById", method = RequestMethod.POST)
	@ResponseBody
	public Object getById(UserModel model) throws BusinessException {
		return userService.getById(model);
	}
	
	/**
 	 * 注册
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/reg", method = RequestMethod.POST)
	@ResponseBody
	public Object reg(UserModel model) throws BusinessException {
		return userService.regRequest(model);
	}
	
	/**
	 * 登录
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Object login(UserModel model) throws BusinessException {
		return userService.login(model);
	}
	
	/**
	 * 修改登录密码
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/updatePwd", method = RequestMethod.POST)
	@ResponseBody
	public Object updatePwd(UserModel model) throws BusinessException {
		return userService.updatePwd(model);
	}
	
	/**
	 * 修改设置交易密码
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/updatePayPwd", method = RequestMethod.POST)
	@ResponseBody
	public Object updatePayPwd(UserModel model) throws BusinessException {
		return userService.updatePayPwd(model);
	}
}