package com.zc.sys.core.sys.entity;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.zc.sys.common.entity.LongPKEntity;
import com.zc.sys.core.common.constant.BaseConstant;
/**
 * 模版配置
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月08日
 */
@Entity
@Table(name=BaseConstant.DB_PREFIX + BaseConstant.DB_MODEL_S + "_template")
public class Template extends LongPKEntity {
	/** 序列号 **/
	private static final long serialVersionUID = 1L;

	/** 名称 **/
	private String name;
	/** 标识-规则：模块_类型_名称，例：notice_reg **/
	private String nid;
	/** 类型：1-资金模版，2-通知信息模版，3-操作日志模版，4-积分日志模版，5-协议模版 **/
	private Integer type;
	/** 子类型：例：1短信，2邮件，3站内信 **/
	private Integer typeSub;
	/** 模版标题 **/
	private String templetTitle;
	/** 模版内容 **/
	private String templetContent;
	/** 使用渠道-例：短信渠道，邮件渠道 **/
	private String routeNid;
	/** 状态：0未启用，1启用 **/
	private Integer status;
	/** 备注 **/
	private String remark;
	
	/** 获取【名称】 **/
	public String getName() {
		return name;
	}
	/** 设置【名称】 **/
	public void setName(String name) {
		this.name = name;
	}
	/** 获取【标识】 **/
	public String getNid() {
		return nid;
	}
	/** 设置【标识】 **/
	public void setNid(String nid) {
		this.nid = nid;
	}
	/** 获取【类型：1-资金流水模版，2-通知信息模版，3-操作日志模版，4-积分日志模版，5-协议模版】 **/
	public Integer getType() {
		return type;
	}
	/** 设置【类型：1-资金流水模版，2-通知信息模版，3-操作日志模版，4-积分日志模版，5-协议模版】 **/
	public void setType(Integer type) {
		this.type = type;
	}
	/** 获取【子类型】 **/
	public Integer getTypeSub() {
		return typeSub;
	}
	/** 设置【子类型】 **/
	public void setTypeSub(Integer typeSub) {
		this.typeSub = typeSub;
	}
	/** 获取【模版标题】 **/
	public String getTempletTitle() {
		return templetTitle;
	}
	/** 设置【模版标题】 **/
	public void setTempletTitle(String templetTitle) {
		this.templetTitle = templetTitle;
	}
	/** 获取【模版内容】 **/
	public String getTempletContent() {
		return templetContent;
	}
	/** 设置【模版内容】 **/
	public void setTempletContent(String templetContent) {
		this.templetContent = templetContent;
	}
	/** 获取【使用渠道-例：短信渠道，邮件渠道】 **/
	public String getRouteNid() {
		return routeNid;
	}
	/** 设置【使用渠道-例：短信渠道，邮件渠道】 **/
	public void setRouteNid(String routeNid) {
		this.routeNid = routeNid;
	}
	/** 获取【状态：0未启用，1启用】 **/
	public Integer getStatus() {
		return status;
	}
	/** 设置【状态：0未启用，1启用】 **/
	public void setStatus(Integer status) {
		this.status = status;
	}
	/** 获取【备注】 **/
	public String getRemark() {
		return remark;
	}
	/** 设置【备注】 **/
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}