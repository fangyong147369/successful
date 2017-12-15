package com.zc.sys.core.xc.model;
import org.springframework.beans.BeanUtils;

import com.zc.sys.common.exception.BusinessException;
import com.zc.sys.common.model.jpa.Page;
import com.zc.sys.common.util.validate.StringUtil;
import com.zc.sys.core.xc.entity.Article;
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
	 * 参数校验
	 */
	public void validParam() {
		if (StringUtil.isBlank(this.getTitle())) {
			throw new BusinessException("模版标题不能为空！");
		}
		if (StringUtil.isBlank(this.getSite().getId())) {
			throw new BusinessException("所属栏目不能为空！");
		}
		if (StringUtil.isBlank(this.getContent())) {
			throw new BusinessException("内容不能为空！");
		}
		if (StringUtil.isBlank(this.getIntroduction())) {
			throw new BusinessException("介绍不能为空！");
		}
		if (StringUtil.isBlank(this.getPicPath())) {
			throw new BusinessException("图片地址不能为空！");
		}
	}
	/**
	 * 设置修改基本参数
	 * @param menu
	 */
	public void setUpdateParam(Article article) {
		article.setContent(this.getContent());
		article.setIntroduction(this.getIntroduction());
		article.setPicPath(this.getPicPath());
		article.setSort(this.getSort());
		article.setState(this.getState());			
		article.setClicks(this.getClicks());
		article.setTitle(this.getTitle());
		article.setIsHot(this.getIsHot());
		article.setSite(this.getSite());
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