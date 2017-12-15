package com.zc.sys.core.xc.entity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
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
	private long pid;
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
	/** 内容 **/
	private String content;
	/** 图片地址 **/
	private String picPath;
	/** 最后修改时间 **/
	private Date updateTime;
	/** 最后修改ip**/
	private String updateIp;
	/** 最后操作管理员 **/
	private String operateUser;
	/** 关联Article对象*/
	@OneToMany(mappedBy = "site", fetch =FetchType.EAGER)
	private List<Article> articles;
	/**
	 * 构造方法
	 */
	public Site() {
		super();
	}
	
	/**
	 * 构造方法
	 * 
	 * @param id 主键
	 */
	public Site(long id) {
		super();
		this.setId(id);
	}
	
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
	public long getPid() {
		return pid;
	}
	public void setPid(long pid) {
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {	        
	            this.updateTime = updateTime;  	                
	}
	public String getUpdateIp() {
		return updateIp;
	}
	public void setUpdateIp(String updateIp) {
		this.updateIp = updateIp;
	}
	public String getOperateUser() {
		return operateUser;
	}
	public void setOperateUser(String operateUser) {
		this.operateUser = operateUser;
	}
	public List<Article> getArticle() {
		return articles;
	}
	public void setArticle(List<Article> article) {
		this.articles = article;
	}

}