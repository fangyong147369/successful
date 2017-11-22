package com.zc.sys.core.user.service.impl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import com.zc.sys.common.form.Result;
import com.zc.sys.core.user.dao.UserInfoDao;
import com.zc.sys.core.user.model.UserInfoModel;
import com.zc.sys.core.user.service.UserInfoService;
/**
 * 用户信息
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Resource
	private UserInfoDao userInfoDao;
	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result list(UserInfoModel model){

		return null;
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@Override
	@Transactional
	public Result add(UserInfoModel model){

		return null;
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@Override
	@Transactional
	public Result update(UserInfoModel model){

		return null;
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result getById(UserInfoModel model){

		return null;
	}

}