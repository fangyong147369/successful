package com.zc.sys.core.sys.service.impl;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zc.sys.common.form.Result;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.core.sys.dao.ConfigDao;
import com.zc.sys.core.sys.entity.Config;
import com.zc.sys.core.sys.model.ConfigModel;
import com.zc.sys.core.sys.service.ConfigService;
/**
 * 系统参数配置
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月08日
 */
@Service
public class ConfigServiceImpl implements ConfigService {

	@Resource
	private ConfigDao configDao;
	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result list(ConfigModel model){
		PageDataList<Config> pageDataList = configDao.list(model);
		PageDataList<ConfigModel> pageDataList_ = new PageDataList<ConfigModel>();
		List<ConfigModel> list = new ArrayList<ConfigModel>();
		pageDataList_.setPage(pageDataList.getPage());
		if (pageDataList.getList().size() > 0) {
			for (int i = 0; i < pageDataList.getList().size(); i++) {
				Config sc = (Config) pageDataList.getList().get(i);
				ConfigModel scm = ConfigModel.instance(sc);
				list.add(scm);
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
	public Result add(ConfigModel model){
		model.validParam();//参数校验
		Config nidEntity = configDao.findObjByProperty("nid", model.getNid());
		if(nidEntity != null){
			return Result.error("该标识已存在！");
		}
		configDao.save(model.prototype());
		return Result.success();
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@Override
	@Transactional
	public Result update(ConfigModel model){
		if(model.getId() <= 0){
			return Result.error("参数错误！");
		}
		model.validParam();//参数校验
		Config nidEntity = configDao.findObjByProperty("nid", model.getNid());
		Config config = configDao.find(model.getId());
		if(nidEntity !=null && !nidEntity.getNid().equals(config.getNid())){
			return Result.error("该标识已存在！");
		}
		model.setUpdateParam(config);
		configDao.update(config);
		return Result.success();
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result getById(ConfigModel model){
		if(model.getId() <= 0){
			return Result.error("参数错误！");
		}
		Config config = configDao.find(model.getId());
		return Result.success().setData(config);
	}

}