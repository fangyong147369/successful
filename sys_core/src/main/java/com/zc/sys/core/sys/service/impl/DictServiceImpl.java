package com.zc.sys.core.sys.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zc.sys.common.form.Result;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.core.sys.dao.DictDao;
import com.zc.sys.core.sys.entity.Dict;
import com.zc.sys.core.sys.model.DictModel;
import com.zc.sys.core.sys.service.DictService;
/**
 * 字典
 * 
 * @author zp
 * @version 0.0.1
 * @since 2017年7月29日
 */
@Service
public class DictServiceImpl implements DictService {

	@Resource
	private DictDao dictDao;
	
	@Override
	public Result list(DictModel model) {
		PageDataList<Dict> pageDataList = dictDao.list(model);
		PageDataList<DictModel> pageDataList_ = new PageDataList<DictModel>();
		pageDataList_.setPage(pageDataList.getPage());
		List<DictModel> list = new ArrayList<DictModel>();
		if(pageDataList != null && pageDataList.getList().size() > 0){
			for (Dict dict : pageDataList.getList()) {
				DictModel model_ = DictModel.instance(dict);
				list.add(model_);
			}
		}
		pageDataList_.setList(list);
		return Result.success().setData(pageDataList_);
	}

	@Override
	public Result add(DictModel model) {
		model.validParam();//参数校验
		Dict dict = dictDao.find(model.getId());
		if(dict != null){
			return Result.error("主键id重复！");
		}
		dictDao.save(model.prototype());
		return Result.success();
	}

	@Override
	public Result update(DictModel model) {
		if(model.getId() == null || model.getId().longValue() <= 0){
			return Result.error("参数错误！");
		}
		model.validParam();//参数校验
		dictDao.update(model.prototype());
		return Result.success();
	}

	@Override
	public Result getById(DictModel model) {
		if(model.getId() == null || model.getId().longValue() <= 0){
			return Result.error("参数错误！");
		}
		Dict dict = dictDao.find(model.getId());
		return Result.success().setData(dict);
	}

}
