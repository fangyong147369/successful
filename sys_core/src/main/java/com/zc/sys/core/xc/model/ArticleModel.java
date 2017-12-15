package com.zc.sys.core.xc.model;
import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.zc.sys.common.model.jpa.Page;
import com.zc.sys.core.manage.model.RoleModel;
import com.zc.sys.core.xc.entity.Article;
import com.zc.sys.core.xc.entity.Site;
/**
 * 文章
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public class ArticleModel extends Article {
	/** 序列号 **/
	private static final long serialVersionUID = 1L;
    
	/** 当前页码 **/
	private int pageNo;
	/** 每页数据条数 **/
	private int pageSize = Page.ROWS;
	/** 条件查询 **/
	private String searchName;
	/**siteModel/
	 * 
	 */
	private SiteModel siteModel;
	
	/**
	 * 实体转换model
	 *
	 */
	public static ArticleModel instance(Article article) {
		
		ArticleModel articleModel = new ArticleModel();
		BeanUtils.copyProperties(article, articleModel);
		return articleModel;
	}
	
	/**
	 * 设置修改基本参数
	 * @param menu
	 */
	public void setUpdateParam(Article article) {
		article.setContent(this.getContent());
		article.setIntroduction(this.getIntroduction());
		article.setOperateUser(this.getOperateUser());
		article.setPicPath(this.getPicPath());
		article.setSort(this.getSort());
		article.setState(this.getState());			
		article.setClicks(this.getClicks());
		article.setTitle(this.getTitle());
		article.setIsHot(this.getIsHot());
		article.setSite(this.getSite());
		article.setUpdateIp(this.getUpdateIp());
		article.setUpdateTime(this.getUpdateTime());
	
	}
	/**
	 * model转换实体
	 */
	public Article prototype() {
		Article article = new Article();
		BeanUtils.copyProperties(this, article);
		return article;
	}
	/**
	 * model转换实体
	 * 
	 * 
	 */
	/** 获取【当前页码】 **/
	public int getPageNo() {
		return pageNo;
	}

	/** 设置【当前页码】 **/
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	/** 获取【每页数据条数】 **/
	public int getPageSize() {
		return pageSize;
	}

	/** 设置【每页数据条数】 **/
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/** 获取【条件查询】 **/
	public String getSearchName() {
		return searchName;
	}

	/** 设置【条件查询】 **/
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
	public SiteModel getSiteModel() {
		return siteModel;
	}
	public void setSiteModel(SiteModel siteModel) {
		this.siteModel = siteModel;
	}

}