package com.zc.sys.core.manage.model;
import org.springframework.beans.BeanUtils;

import com.zc.sys.common.model.jpa.Page;
import com.zc.sys.common.util.date.DateUtil;
import com.zc.sys.common.util.validate.StringUtil;
import com.zc.sys.core.manage.entity.NoticeMessage;
import com.zc.sys.core.manage.entity.Operator;
import com.zc.sys.core.sys.model.TemplateModel;
import com.zc.sys.core.user.entity.User;
/**
 * 通知消息
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月15日
 */
public class NoticeMessageModel extends NoticeMessage {
	/** 序列号 **/
	private static final long serialVersionUID = 1L;

	/** 当前页码 **/
	private int pageNo;
	/** 每页数据条数 **/
	private int pageSize = Page.ROWS;
	/** 条件查询 **/
	private String searchName;
	
	/** 订单 **/
	private OrderTaskModel orderTaskModel;

	public NoticeMessageModel() {
		super();
	}
	
	public NoticeMessageModel(Integer type, User sendUser, User receiveUser,
			Operator operator,String orderNo,OrderTaskModel orderTaskModel) {
		super();
		this.setType(type);
		this.setSendUser(sendUser);
		this.setReceiveUser(receiveUser);
		this.setOperator(operator);
		this.setOrderNo(orderNo);
		this.setOrderTaskModel(orderTaskModel);
	}
	
	public NoticeMessageModel(String nid,Integer type,String orderNo,OrderTaskModel orderTaskModel,String receiveAddr){
		this.setNid(nid);
		this.setType(type);
		this.setOrderNo(orderNo);
		this.setOrderTaskModel(orderTaskModel);
		this.setReceiveAddr(receiveAddr);
	}

	/**
	 * 实体转换model
	 */
	public static NoticeMessageModel instance(NoticeMessage noticeMessage) {
		NoticeMessageModel noticeMessageModel = new NoticeMessageModel();
		BeanUtils.copyProperties(noticeMessage, noticeMessageModel);
		return noticeMessageModel;
	}

	/**
	 * model转换实体
	 */
	public NoticeMessage prototype() {
		NoticeMessage noticeMessage = new NoticeMessage();
		BeanUtils.copyProperties(this, noticeMessage);
		return noticeMessage;
	}
	
	/**
	 * 初始化站内信发送
	 */
	public void initMessage(TemplateModel templateModel) {
		this.setAddTime(DateUtil.getNow());
		this.setState(2);
		this.setContent(StringUtil.fillTemplet(templateModel.getTempletContent(), this));
		this.setTitle(StringUtil.fillTemplet(templateModel.getTempletTitle(), this));
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

	/** 获取【订单】 **/
	public OrderTaskModel getOrderTaskModel() {
		return orderTaskModel;
	}

	/** 设置【订单】 **/
	public void setOrderTaskModel(OrderTaskModel orderTaskModel) {
		this.orderTaskModel = orderTaskModel;
	}

}