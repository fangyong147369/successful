package com.zc.sys.core.manage.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zc.sys.common.form.Result;
import com.zc.sys.core.manage.dao.RoleDao;
import com.zc.sys.core.manage.model.RoleModel;
import com.zc.sys.core.manage.service.RoleService;
/**
 * 角色
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Service
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleDao roleDao;
	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result list(RoleModel model){

		return null;
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result add(RoleModel model){

		return null;
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result update(RoleModel model){

		return null;
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result getById(RoleModel model){

		return null;
	}

}