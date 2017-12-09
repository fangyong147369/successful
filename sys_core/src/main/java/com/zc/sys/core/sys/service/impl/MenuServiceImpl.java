package com.zc.sys.core.sys.service.impl;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zc.sys.common.form.Result;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.core.sys.dao.MenuDao;
import com.zc.sys.core.sys.entity.Menu;
import com.zc.sys.core.sys.model.MenuModel;
import com.zc.sys.core.sys.service.MenuService;
import com.zc.sys.core.xc.entity.Site;
import com.zc.sys.core.xc.model.SiteModel;

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
		PageDataList<Menu> pageDataList = menuDao.list(model);
		PageDataList<MenuModel> pageDataList_ = new PageDataList<MenuModel>();
		pageDataList_.setPage(pageDataList.getPage());
		List<MenuModel> list = new ArrayList<MenuModel>();
		if(pageDataList != null && pageDataList.getList().size() > 0){
			for (Menu menu : pageDataList.getList()) {
				MenuModel model_ = MenuModel.instance(menu);
				list.add(model_);
			}
		}
		pageDataList_.setList(list);
		return Result.success().setData(pageDataList_);
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@Override
	@Transactional
	public Result add(MenuModel model){
		Menu menu = model.prototype();
		menuDao.save(menu);
		return Result.success().setData(menu);
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@Override
	@Transactional
	public Result update(MenuModel model){
		Menu menu = menuDao.find(model.getId());
		model.setUpdateParam(menu);//设置修改基本参数
		menuDao.update(menu);
		return Result.success();
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result getById(MenuModel model){
		if(model.getId() <= 0){
			return Result.error("参数错误！");
		}
		Menu menu = menuDao.find(model.getId());
		return Result.success().setData(menu);
	}

}