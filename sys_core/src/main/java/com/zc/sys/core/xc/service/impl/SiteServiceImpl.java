package com.zc.sys.core.xc.service.impl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import com.zc.sys.common.form.Result;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.core.xc.dao.ArticleDao;
import com.zc.sys.core.xc.dao.SiteDao;
import com.zc.sys.core.xc.entity.Site;
import com.zc.sys.core.xc.model.SiteModel;
import com.zc.sys.core.xc.service.SiteService;

/**
 * 栏目
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Service
public class SiteServiceImpl implements SiteService {

	@Resource
	private SiteDao siteDao;
	@Resource
	private ArticleDao articleDao;
	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result list(SiteModel model){
		PageDataList<Site> pageDataList = siteDao.list(model);
		PageDataList<SiteModel> pageDataList_ = new PageDataList<SiteModel>();
		pageDataList_.setPage(pageDataList.getPage());
		List<SiteModel> list = new ArrayList<SiteModel>();
		if (pageDataList != null && pageDataList.getList().size() > 0) {
			for (Site site : pageDataList.getList()) {
				SiteModel model_ = SiteModel.instance(site);	
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
	public Result add(SiteModel model){	
		Site site = model.prototype();
		siteDao.save(site);
		return Result.success().setData(site);
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@Override
	@Transactional
	public Result update(SiteModel model){
		Site site = siteDao.find(model.getId());
		model.setUpdateParam(site);//设置修改基本参数
		siteDao.update(site);	
		return Result.success();
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result getById(SiteModel model){	
		if(model.getId() <= 0){
			return Result.error("参数错误！");
		}
		Site site =siteDao.find(model.getId());
		return Result.success().setData(site);

	}

}