package com.zc.sys.core.user.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zc.sys.common.form.Result;
import com.zc.sys.core.user.dao.UserDao;
import com.zc.sys.core.user.model.UserModel;
import com.zc.sys.core.user.service.UserService;
/**
 * 用户
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;
	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result list(UserModel model){

		return null;
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result add(UserModel model){

		return null;
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result update(UserModel model){

		return null;
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result getById(UserModel model){

		return null;
	}

}