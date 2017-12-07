package com.zc.sys.core.xc.entity;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.zc.sys.common.entity.LongPKEntity;
import com.zc.sys.core.common.constant.BaseConstant;
/**
 * 栏目
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Entity
@Table(name=BaseConstant.DB_PREFIX + BaseConstant.DB_MODEL_Xc + "_site")
public class Site extends LongPKEntity {
	/** 序列号 **/
	private static final long serialVersionUID = 1L;
	/** 名称 **/
	private String name;
	/** 标识 **/
	private String nid;
	/** 父id **/
	private Long pid;
	/** 状态，-1：禁用，1：启用 **/
	private int state;
	/** 类型  **/
	private int type;
	/** 跳转链接**/
	private String url;
	/** 排序 **/
	private int sort;
	/** 简介 **/
	private String introduction;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNid() {
		return nid;
	}
	public void setNid(String nid) {
		this.nid = nid;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}