package com.zc.sys.core.xc.model;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.zc.sys.common.model.jpa.Page;
import com.zc.sys.core.sys.entity.Menu;
import com.zc.sys.core.xc.entity.Site;
/**
 * 栏目
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public class SiteModel extends Site {
	/** 序列号 **/
	private static final long serialVersionUID = 1L;

	/** 当前页码 **/
	private int pageNo;
	/** 每页数据条数 **/
	private int pageSize = Page.ROWS;
	/** 条件查询 **/
	private String searchName;
//	/** 角色菜单 **/
//	private String siteIdStr;
	/**
	 * 实体转换model
	 */
	public static SiteModel instance(Site site) {
		SiteModel siteModel = new SiteModel();
		BeanUtils.copyProperties(site, siteModel);
		return siteModel;
	}

	/**
	 * 设置修改基本参数
	 * @param menu
	 */
	public void setUpdateParam(Site site) {
		site.setName(this.getName());
		site.setPid(this.getPid());
		site.setType(this.getType());
		site.setContent(this.getContent());
		site.setIntroduction(this.getIntroduction());
		site.setOperateUser(this.getOperateUser());
		site.setPicPath(this.getPicPath());
		site.setSort(this.getSort());
		site.setState(this.getState());
//		site.setUpdateIp(this.getUpdateIp());	
//		site.setUpdateTime(this.getUpdateTime());
		site.setArticle(this.getArticle());		
		site.setNid(this.getNid());
	}

	/**
	 * model转换实体
	 */
	public Site prototype() {
		Site site = new Site();
		BeanUtils.copyProperties(this, site);
		return site;
	}

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
//	/** 栏目菜单 **/
//	public String getSiteIdStr() {
//		return siteIdStr;
//	}
//	/** 栏目菜单 **/
//	public void setSiteIdStr(String siteIdStr) {
//		this.siteIdStr = siteIdStr;
//	}
}