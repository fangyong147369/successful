package com.zc.sys.common.entity;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
/**
 * 统一定义long型id(主键)的entity基类.
 * 基类统一定义id的属性名称、数据类型、列名映射及生成策略.
 * @author zp
 */
@MappedSuperclass
public abstract class LongPKNoneEntity extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
