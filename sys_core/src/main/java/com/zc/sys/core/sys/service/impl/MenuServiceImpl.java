package com.zc.sys.core.sys.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zc.sys.common.form.Result;
import com.zc.sys.core.sys.dao.MenuDao;
import com.zc.sys.core.sys.model.MenuModel;
import com.zc.sys.core.sys.service.MenuService;
/**
 * 菜单
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Service
public class MenuServiceImpl implements MenuService {

	@Resource
	private MenuDao menuDao;
	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result list(MenuModel model){

		return null;
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result add(MenuModel model){

		return null;
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result update(MenuModel model){

		return null;
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result getById(MenuModel model){

		return null;
	}

}