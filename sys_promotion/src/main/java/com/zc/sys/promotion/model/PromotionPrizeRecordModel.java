package com.zc.sys.promotion.model;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;

import com.zc.sys.common.exception.NoRollBackException;
import com.zc.sys.common.model.jpa.Page;
import com.zc.sys.common.util.date.DateUtil;
import com.zc.sys.core.common.constant.BaseConstant;
import com.zc.sys.core.common.global.BeanUtil;
import com.zc.sys.promotion.constant.BasePromotionConstant;
import com.zc.sys.promotion.entity.PromotionPrizeConfig;
import com.zc.sys.promotion.entity.PromotionPrizeRecord;
import com.zc.sys.promotion.service.InterestFreeNoteRecordService;
/**
 * 活动推广奖励记录
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public class PromotionPrizeRecordModel extends PromotionPrizeRecord {
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
	public static PromotionPrizeRecordModel instance(PromotionPrizeRecord promotionPrizeRecord) {
		PromotionPrizeRecordModel promotionPrizeRecordModel = new PromotionPrizeRecordModel();
		BeanUtils.copyProperties(promotionPrizeRecord, promotionPrizeRecordModel);
		return promotionPrizeRecordModel;
	}

	/**
	 * model转换实体
	 */
	public PromotionPrizeRecord prototype() {
		PromotionPrizeRecord promotionPrizeRecord = new PromotionPrizeRecord();
		BeanUtils.copyProperties(this, promotionPrizeRecord);
		return promotionPrizeRecord;
	}
	
	/**
	 * 初始化添加
	 * @param model
	 * @param promotionPrizeConfig
	 * @return
	 */
	public void initAdd(PromotionModel model,PromotionPrizeConfig promotionPrizeConfig) {
		this.setAddTime(DateUtil.getNow());
		this.setPromotion(promotionPrizeConfig.getPromotion());
		this.setPromotionPrizeConfig(promotionPrizeConfig);
		this.setState(BaseConstant.BUSINESS_STATE_YES);
		this.setUser(model.getUser());
	}
	

	/**
	 * 发放
	 * @param prizeRecord 
	 * @throws NoRollBackException 
	 */
	@Transactional
	public void trfGiveOut(PromotionPrizeRecord prizeRecord) throws NoRollBackException {
		switch (prizeRecord.getPromotionPrizeConfig().getType()) {
		case BasePromotionConstant.PROMOTIONPRIZE_TYPE_IFNOTE://免息券
			InterestFreeNoteRecordService iFNoteRecoredService = BeanUtil.getBean(InterestFreeNoteRecordService.class);
			iFNoteRecoredService.giveOut(new InterestFreeNoteRecordModel(prizeRecord));
			break;
		default:
			break;
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