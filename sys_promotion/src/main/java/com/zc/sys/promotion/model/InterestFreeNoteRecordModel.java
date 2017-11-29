package com.zc.sys.promotion.model;
import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.zc.sys.common.exception.BusinessException;
import com.zc.sys.common.exception.NoRollBackException;
import com.zc.sys.common.model.jpa.Page;
import com.zc.sys.common.util.date.DateUtil;
import com.zc.sys.core.common.constant.BaseConstant;
import com.zc.sys.core.common.global.BeanUtil;
import com.zc.sys.core.user.dao.UserDao;
import com.zc.sys.core.user.entity.User;
import com.zc.sys.promotion.dao.InterestFreeNoteDao;
import com.zc.sys.promotion.entity.InterestFreeNote;
import com.zc.sys.promotion.entity.InterestFreeNoteRecord;
import com.zc.sys.promotion.entity.PromotionPrizeRecord;
/**
 * 免息券发放记录
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public class InterestFreeNoteRecordModel extends InterestFreeNoteRecord {
	/** 序列号 **/
	private static final long serialVersionUID = 1L;

	/** 当前页码 **/
	private int pageNo;
	/** 每页数据条数 **/
	private int pageSize = Page.ROWS;
	/** 条件查询 **/
	private String searchName;

	public InterestFreeNoteRecordModel() {
		super();
	}

	public InterestFreeNoteRecordModel(PromotionPrizeRecord prizeRecord) {
		InterestFreeNoteDao interestFreeNoteDao = BeanUtil.getBean(InterestFreeNoteDao.class);
		InterestFreeNote interestFreeNote = interestFreeNoteDao.findObjByProperty("noteNo", prizeRecord.getPromotionPrizeConfig().getPrizeNo());
		initInfo(interestFreeNote, prizeRecord.getUser(), prizeRecord.getAddTime());//初始化信息
	}

	/**
	 * 实体转换model
	 */
	public static InterestFreeNoteRecordModel instance(InterestFreeNoteRecord interestFreeNoteRecord) {
		InterestFreeNoteRecordModel interestFreeNoteRecordModel = new InterestFreeNoteRecordModel();
		BeanUtils.copyProperties(interestFreeNoteRecord, interestFreeNoteRecordModel);
		return interestFreeNoteRecordModel;
	}

	/**
	 * model转换实体
	 */
	public InterestFreeNoteRecord prototype() {
		InterestFreeNoteRecord interestFreeNoteRecord = new InterestFreeNoteRecord();
		BeanUtils.copyProperties(this, interestFreeNoteRecord);
		return interestFreeNoteRecord;
	}
	

	/**
	 * 校验添加参数
	 */
	public void validAdd() {
		if(this.getUser() == null || this.getUser().getId() <= 0){
			throw new BusinessException("参数错误");
		}
		if(this.getInterestFreeNote() == null || this.getInterestFreeNote().getId() <= 0){
			throw new BusinessException("参数错误");
		}
		UserDao userDao = BeanUtil.getBean(UserDao.class);
		User user = userDao.find(this.getUser().getId());
		if(user == null){
			throw new BusinessException("用户不存在");
		}
		InterestFreeNoteDao interestFreeNoteDao = BeanUtil.getBean(InterestFreeNoteDao.class);
		InterestFreeNote interestFreeNote = interestFreeNoteDao.find(this.getInterestFreeNote().getId());
		if(interestFreeNote == null){
			throw new BusinessException("参数错误");
		}
		this.setUser(user);
		this.setInterestFreeNote(interestFreeNote);
	}

	/**
	 * 初始化添加
	 */
	public void initAdd() {
		InterestFreeNote interestFreeNote = this.getInterestFreeNote();
		initInfo(interestFreeNote, this.getUser(), DateUtil.getNow());
	}
	
	/**
	 * 初始化信息
	 */
	public void initInfo(InterestFreeNote interestFreeNote,User user,Date addTime) {
		Date endTime = null;
		Date startTime = null;
		int state = 0;
		if(interestFreeNote != null){
			startTime = addTime;
			endTime = getEndTime(interestFreeNote.getValidityType(), DateUtil.getNow(), interestFreeNote.getValidityValue());
			state = BaseConstant.BUSINESS_STATE_NO;//未使用
			if(DateUtil.msBetween(endTime, DateUtil.getNow()) <= 0){//活动已到期
				throw new BusinessException("活动奖励不在期限内");
			}
		}else {
			throw new BusinessException("奖励配置不存在");
		}
		this.setUser(user);
		this.setAddTime(addTime);
		this.setEndTime(endTime);
		this.setInterestFreeNote(interestFreeNote);
		this.setStartTime(startTime);
		this.setState(state);
	}
	
	/**
	 * 获取奖励结束时间
	 * @param validityType
	 * @param startTime
	 * @param value
	 * @return
	 */
	private Date getEndTime(int validityType,Date startTime,String value){
		Date endTime = null;
		switch (validityType) {
		case BaseConstant.VALIDITY_TYPE_DAY://天数
			endTime = DateUtil.rollDay(startTime, Integer.parseInt(value));
			break;
		case BaseConstant.VALIDITY_TYPE_TIME://时间
			endTime = DateUtil.getDateByFullDateStr(value);
			break;
		default:
			throw new BusinessException("参数错误");
		}
		return endTime;
	}


	/**
	 * 校验发放
	 * @param interestFreeNoteRecord
	 * @throws NoRollBackException 
	 */
	public void checkAndInitSend(InterestFreeNoteRecord interestFreeNoteRecord) throws NoRollBackException {
		InterestFreeNote interestFreeNote = interestFreeNoteRecord.getInterestFreeNote();
		if(interestFreeNote.getQuota() - interestFreeNote.getUseQuota() <= 0){
			throw new NoRollBackException("库存不足");
		}
		interestFreeNote.setUseQuota(interestFreeNote.getUseQuota() + 1);
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