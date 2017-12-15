package com.zc.sys.core.sys.model;
import org.springframework.beans.BeanUtils;
import com.zc.sys.common.exception.BusinessException;
import com.zc.sys.common.model.jpa.Page;
import com.zc.sys.common.util.validate.StringUtil;
import com.zc.sys.core.sys.entity.Template;
/**
 * 模版配置
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月08日
 */
public class TemplateModel extends Template {
	/** 序列号 **/
	private static final long serialVersionUID = 1L;

	/** 当前页码 **/
	private int pageNo;
	/** 每页数据条数 **/
	private int pageSize = Page.ROWS;
	/** 条件查询 **/
	private String searchName;

	/**
	 * 实体转换model
	 */
	public static TemplateModel instance(Template template) {
		TemplateModel templateModel = new TemplateModel();
		BeanUtils.copyProperties(template, templateModel);
		return templateModel;
	}

	/**
	 * model转换实体
	 */
	public Template prototype() {
		Template template = new Template();
		BeanUtils.copyProperties(this, template);
		return template;
	}
	
	/**
	 * 参数校验
	 */
	public void validParam() {
		if (StringUtil.isBlank(this.getName())) {
			throw new BusinessException("名称不能为空！");
		}
		if (StringUtil.isBlank(this.getNid())) {
			throw new BusinessException("标识不能为空！");
		}
		if (this.getType() <= 0) {
			throw new BusinessException("请选择类型！");
		}
		if (StringUtil.isBlank(this.getTitle())) {
			throw new BusinessException("模版标题不能为空！");
		}
		if (StringUtil.isBlank(this.getContent())) {
			throw new BusinessException("模版内容不能为空！");
		}
	}
	
	/**
	 * 设置修改参数
	 * @param systemConfig
	 */
	public void setUpdateParam(Template template) {
		template.setName(this.getName());
		template.setNid(this.getNid());
		template.setRemark(this.getRemark());
		template.setRoute(this.getRoute());
		template.setState(this.getState());
		template.setContent(this.getContent());
		template.setTitle(this.getTitle());
		template.setType(this.getType());
		template.setTypeSub(this.getTypeSub());
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

}