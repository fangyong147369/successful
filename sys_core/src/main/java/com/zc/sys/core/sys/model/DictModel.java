package com.zc.sys.core.sys.model;

import org.springframework.beans.BeanUtils;

import com.zc.sys.common.exception.BusinessException;
import com.zc.sys.common.model.jpa.Page;
import com.zc.sys.common.util.validate.StringUtil;
import com.zc.sys.core.sys.entity.Dict;

/**
 * 字典
 * 
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月7日
 */
public class DictModel extends Dict {
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
	public static DictModel instance(Dict dict) {
		DictModel dictModel = new DictModel();
		BeanUtils.copyProperties(dict, dictModel);
		return dictModel;
	}

	/**
	 * model转换实体
	 */
	public Dict prototype() {
		Dict dict = new Dict();
		BeanUtils.copyProperties(this, dict);
		return dict;
	}

	/**
	 * 参数校验
	 */
	public void validParam() {
		if (this.getId() == null || this.getId().longValue() <= 0) {
			throw new BusinessException("主键id不能为空！");
		}
		if (StringUtil.isBlank(this.getName())) {
			throw new BusinessException("名称不能为空！");
		}
		if (StringUtil.isBlank(this.getNid())) {
			throw new BusinessException("nid标识不能为空！");
		}
		if (StringUtil.isBlank(this.getNidName())) {
			throw new BusinessException("nid标识名称不能为空！");
		}
		if (StringUtil.isBlank(this.getValue())) {
			throw new BusinessException("值不能为空！");
		}
		if (this.getSort() == null || this.getSort().intValue() < 0) {
			throw new BusinessException("排序不能为空！");
		}
		if (this.getState() == null) {
			throw new BusinessException("状态不能为空！");
		}
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
