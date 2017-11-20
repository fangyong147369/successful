package com.zc.sys.api.zc.manage;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zc.sys.common.exception.BusinessException;
import com.zc.sys.core.common.web.BaseController;
import com.zc.sys.core.manage.model.RoleModel;
import com.zc.sys.core.manage.service.RoleService;
/**
 * 角色
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@RestController
@RequestMapping("/m/role")
public class RoleController extends BaseController<RoleModel> {

	@Resource
	RoleService roleService;

	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Object list(RoleModel model) throws BusinessException {
		return roleService.list(model);
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Object add(RoleModel model) throws BusinessException {
		return roleService.add(model);
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Object update(RoleModel model) throws BusinessException {
		return roleService.update(model);
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/getById", method = RequestMethod.POST)
	@ResponseBody
	public Object getById(RoleModel model) throws BusinessException {
		return roleService.getById(model);
	}
}