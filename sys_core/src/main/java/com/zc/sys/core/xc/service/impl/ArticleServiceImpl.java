package com.zc.sys.core.xc.service.impl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import com.zc.sys.common.form.Result;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.common.util.validate.StringUtil;
import com.zc.sys.core.manage.entity.Operator;
import com.zc.sys.core.manage.model.OperatorModel;
import com.zc.sys.core.manage.model.RoleModel;
import com.zc.sys.core.xc.dao.ArticleDao;
import com.zc.sys.core.xc.dao.SiteDao;
import com.zc.sys.core.xc.entity.Article;
import com.zc.sys.core.xc.entity.Site;
import com.zc.sys.core.xc.model.ArticleModel;
import com.zc.sys.core.xc.model.SiteModel;
import com.zc.sys.core.xc.service.ArticleService;
/**
 * 文章
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Service
public class ArticleServiceImpl implements ArticleService {

	@Resource
	private ArticleDao articleDao;
	private SiteDao siteDao;
	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result list(ArticleModel model){
		PageDataList<Article> pageDataList = articleDao.list(model);
		PageDataList<ArticleModel> pageDataList_ = new PageDataList<ArticleModel>();
		pageDataList_.setPage(pageDataList.getPage());
		List list = new ArrayList();
		if (pageDataList != null && pageDataList.getList().size() > 0) {
			for (Article article : pageDataList.getList()) {				
				ArticleModel  model_ = ArticleModel.instance(article);
				model_.setSiteModel(SiteModel.instance(article.getSite()));
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
	public Result add(ArticleModel model){
		Article article = model.prototype();
		articleDao.save(article);
		return Result.success().setData(article);
	}
	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result update(ArticleModel model){
      Article article = articleDao.find(model.getId());
		model.setUpdateParam(article);//设置修改基本参数
		articleDao.update(article);	
		return Result.success();
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result getById(ArticleModel model){
           if(model.getId()<=0)
           {
        	   return Result.error("参数错误！"); 
           }
         
           Article article=articleDao.find(model.getId());
		return Result.success().setData(article);
	}

}