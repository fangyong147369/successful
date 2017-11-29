package com.zc.sys.promotion.model;
import org.springframework.beans.BeanUtils;

import com.zc.sys.common.exception.BusinessException;
import com.zc.sys.common.model.jpa.Page;
import com.zc.sys.common.util.date.DateUtil;
import com.zc.sys.common.util.validate.StringUtil;
import com.zc.sys.core.common.global.BeanUtil;
import com.zc.sys.promotion.dao.InterestFreeNoteDao;
import com.zc.sys.promotion.entity.InterestFreeNote;
/**
 * 免息券
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public class InterestFreeNoteModel extends InterestFreeNote {
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
	public static InterestFreeNoteModel instance(InterestFreeNote interestFreeNote) {
		InterestFreeNoteModel interestFreeNoteModel = new InterestFreeNoteModel();
		BeanUtils.copyProperties(interestFreeNote, interestFreeNoteModel);
		return interestFreeNoteModel;
	}

	/**
	 * model转换实体
	 */
	public InterestFreeNote prototype() {
		InterestFreeNote interestFreeNote = new InterestFreeNote();
		BeanUtils.copyProperties(this, interestFreeNote);
		return interestFreeNote;
	}
	
	/**
	 * 校验添加参数
	 */
	public void validAdd() {
		if(StringUtil.isBlank(this.getName())){
			throw new BusinessException("名称不能为空");
		}
		if(this.getState() == 0){
			throw new BusinessException("参数错误");
		}
		if(this.getDay() <= 0){
			throw new BusinessException("参数错误");
		}
		if(this.getValidityType() <= 0){
			throw new BusinessException("参数错误");
		}
		if(StringUtil.isBlank(this.getValidityValue())){
			throw new BusinessException("有效期不能为空");
		}
		if(this.getQuota() < 0){
			throw new BusinessException("参数错误");
		}
		if(this.getMinAmount() < 0 || this.getMaxAmount() < 0){
			throw new BusinessException("参数错误");
		}
	}

	/**
	 * 初始化添加
	 */
	public void initAdd() {
		this.setAddTime(DateUtil.getNow());
		this.setNoteNo(StringUtil.getSerialNumber());
	}

	/**
	 * 校验修改参数
	 * @return
	 */
	public InterestFreeNote validUpdate() {
		if(StringUtil.isBlank(this.getName())){
			throw new BusinessException("名称不能为空");
		}
		if(this.getState() == 0){
			throw new BusinessException("参数错误");
		}
		if(this.getDay() <= 0){
			throw new BusinessException("参数错误");
		}
		if(this.getValidityType() <= 0){
			throw new BusinessException("参数错误");
		}
		if(StringUtil.isBlank(this.getValidityValue())){
			throw new BusinessException("有效期不能为空");
		}
		if(this.getQuota() < 0){
			throw new BusinessException("参数错误");
		}
		if(this.getMinAmount() < 0 || this.getMaxAmount() < 0){
			throw new BusinessException("参数错误");
		}
		if(this.getId() <= 0){
			throw new BusinessException("参数错误");
		}
		InterestFreeNoteDao interestFreeNoteDao = BeanUtil.getBean(InterestFreeNoteDao.class);
		InterestFreeNote interestFreeNote = interestFreeNoteDao.find(this.getId());
		if(interestFreeNote == null){
			throw new BusinessException("参数错误");
		}
		return interestFreeNote;
	}

	/**
	 * 初始化修改
	 * @param interestFreeNote
	 */
	public void initUpdate(InterestFreeNote interestFreeNote) {
		interestFreeNote.setName(this.getName());
		interestFreeNote.setDay(this.getDay());
		interestFreeNote.setMaxAmount(this.getMaxAmount());
		interestFreeNote.setMinAmount(this.getMinAmount());
		interestFreeNote.setQuota(this.getQuota());
		interestFreeNote.setRemark(this.getRemark());
		interestFreeNote.setState(this.getState());
		interestFreeNote.setSummary(this.getSummary());
		interestFreeNote.setValidityType(this.getValidityType());
		interestFreeNote.setValidityValue(this.getValidityValue());
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