package com.zc.sys.promotion.model;
import org.springframework.beans.BeanUtils;

import com.zc.sys.common.exception.BusinessException;
import com.zc.sys.common.model.jpa.Page;
import com.zc.sys.common.util.date.DateUtil;
import com.zc.sys.common.util.validate.StringUtil;
import com.zc.sys.core.common.global.BeanUtil;
import com.zc.sys.promotion.dao.PromotionDao;
import com.zc.sys.promotion.dao.PromotionPrizeConfigDao;
import com.zc.sys.promotion.entity.Promotion;
import com.zc.sys.promotion.entity.PromotionPrizeConfig;
/**
 * 活动推广奖励配置
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public class PromotionPrizeConfigModel extends PromotionPrizeConfig {
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
	public static PromotionPrizeConfigModel instance(PromotionPrizeConfig promotionPrizeConfig) {
		PromotionPrizeConfigModel promotionPrizeConfigModel = new PromotionPrizeConfigModel();
		BeanUtils.copyProperties(promotionPrizeConfig, promotionPrizeConfigModel);
		return promotionPrizeConfigModel;
	}

	/**
	 * model转换实体
	 */
	public PromotionPrizeConfig prototype() {
		PromotionPrizeConfig promotionPrizeConfig = new PromotionPrizeConfig();
		BeanUtils.copyProperties(this, promotionPrizeConfig);
		return promotionPrizeConfig;
	}
	
	/**
	 * 校验添加参数
	 */
	public void validAdd() {
		if(this.getPromotion() == null || this.getPromotion().getId() <= 0){
			throw new BusinessException("参数错误");
		}
		if(this.getType() <= 0){
			throw new BusinessException("参数错误");
		}
		if(this.getState() == 0){
			throw new BusinessException("参数错误");
		}
		if(StringUtil.isBlank(this.getPrizeNo())){
			throw new BusinessException("参数错误");
		}
		PromotionDao promotionDao = BeanUtil.getBean(PromotionDao.class);
		Promotion promotion = promotionDao.find(this.getPromotion().getId());
		if(promotion == null){
			throw new BusinessException("参数错误");
		}
		this.setPromotion(promotion);
	}

	/**
	 * 初始化添加
	 */
	public void initAdd() {
		this.setAddTime(DateUtil.getNow());
	}

	/**
	 * 校验修改参数
	 * @return
	 */
	public PromotionPrizeConfig validUpdate() {
		if(this.getPromotion() == null || this.getPromotion().getId() <= 0){
			throw new BusinessException("参数错误");
		}
		if(this.getType() <= 0){
			throw new BusinessException("参数错误");
		}
		if(this.getState() == 0){
			throw new BusinessException("参数错误");
		}
		if(StringUtil.isBlank(this.getPrizeNo())){
			throw new BusinessException("参数错误");
		}
		if(this.getId() <= 0){
			throw new BusinessException("参数错误");
		}
		PromotionPrizeConfigDao promotionPrizeConfigDao = BeanUtil.getBean(PromotionPrizeConfigDao.class);
		PromotionPrizeConfig promotionPrizeConfig = promotionPrizeConfigDao.find(this.getId());
		if(promotionPrizeConfig == null){
			throw new BusinessException("参数错误");
		}
		return promotionPrizeConfig;
	}

	/**
	 * 初始化修改
	 * @param promotionPrizeConfig
	 */
	public void initUpdate(PromotionPrizeConfig promotionPrizeConfig) {
		promotionPrizeConfig.setType(this.getType());
		promotionPrizeConfig.setPrizeNo(this.getPrizeNo());
		promotionPrizeConfig.setRemark(this.getRemark());
		promotionPrizeConfig.setState(this.getType());
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