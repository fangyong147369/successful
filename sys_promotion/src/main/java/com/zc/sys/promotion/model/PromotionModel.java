package com.zc.sys.promotion.model;
import org.springframework.beans.BeanUtils;

import com.zc.sys.common.exception.BusinessException;
import com.zc.sys.common.model.jpa.Page;
import com.zc.sys.common.util.date.DateUtil;
import com.zc.sys.common.util.log.LogUtil;
import com.zc.sys.common.util.validate.StringUtil;
import com.zc.sys.core.common.constant.BaseConstant;
import com.zc.sys.core.common.global.BeanUtil;
import com.zc.sys.core.common.model.PromotionHandleModel;
import com.zc.sys.core.user.dao.UserDao;
import com.zc.sys.core.user.entity.User;
import com.zc.sys.promotion.dao.PromotionDao;
import com.zc.sys.promotion.entity.Promotion;
import com.zc.sys.promotion.service.PromotionService;
/**
 * 活动推广
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public class PromotionModel extends Promotion {
	/** 序列号 **/
	private static final long serialVersionUID = 1L;

	/** 当前页码 **/
	private int pageNo;
	/** 每页数据条数 **/
	private int pageSize = Page.ROWS;
	/** 条件查询 **/
	private String searchName;

	/** 用户 **/
	private User user;
	
	/** 处理传输model **/
	private PromotionHandleModel promotionHandleModel;
	
	/**
	 * 实体转换model
	 */
	public static PromotionModel instance(Promotion promotion) {
		PromotionModel promotionModel = new PromotionModel();
		BeanUtils.copyProperties(promotion, promotionModel);
		return promotionModel;
	}

	/**
	 * model转换实体
	 */
	public Promotion prototype() {
		Promotion promotion = new Promotion();
		BeanUtils.copyProperties(this, promotion);
		return promotion;
	}

	/**
	 * 校验参数
	 */
	public void validAdd() {
		if (StringUtil.isBlank(this.getName())) {
			throw new BusinessException("标题不能为空！");
		}
		if(this.getWay() <= 0){
			throw new BusinessException("参数错误！");
		}
		if (StringUtil.isBlank(this.getContent())) {
			throw new BusinessException("内容不能为空！");
		}
		if(this.getStartTime() == null){
			throw new BusinessException("开始时间不能为空！");
		}
		if(this.getEndTime() == null){
			throw new BusinessException("结束时间不能为空！");
		}
	}

	/**
	 * 初始化添加
	 */
	public void initAdd() {
		if(this.getState() == 0){
			this.setState(BaseConstant.INFO_STATE_NO);
		}
		this.setAddTime(DateUtil.getNow());
	}
	

	/**
	 * 校验修改参数
	 * @return
	 */
	public Promotion validUpdate() {
		if (StringUtil.isBlank(this.getName())) {
			throw new BusinessException("标题不能为空！");
		}
		if(this.getWay() <= 0){
			throw new BusinessException("参数错误！");
		}
		if (StringUtil.isBlank(this.getContent())) {
			throw new BusinessException("内容不能为空！");
		}
		if(this.getStartTime() == null){
			throw new BusinessException("开始时间不能为空！");
		}
		if(this.getEndTime() == null){
			throw new BusinessException("结束时间不能为空！");
		}
		if(this.getId() <= 0){
			throw new BusinessException("参数错误！");
		}
		PromotionDao promotionDao = BeanUtil.getBean(PromotionDao.class);
		Promotion promotion = promotionDao.find(this.getId());
		if(promotion == null){
			throw new BusinessException("参数错误！");
		}
		return promotion;
	}
	
	/**
	 * 初始化修改
	 * @param promotion
	 */
	public void initUpdate(Promotion promotion) {
		promotion.setContent(this.getContent());
		promotion.setEndTime(this.getEndTime());
		promotion.setName(this.getName());
		promotion.setRemark(this.getRemark());
		promotion.setStartTime(this.getStartTime());
		promotion.setSummary(this.getSummary());
		promotion.setState(this.getState());
		promotion.setWay(this.getWay());
	}

	/**
	 * 参数校验-活动处理
	 * @param model
	 */
	public void validParam() {
		PromotionHandleModel model = this.getPromotionHandleModel();
		if(model.getPromotionWay() <= 0){
			throw new BusinessException("活动方式参数有误");
		}
		if(model.getUser() == null || model.getUser().getId() <= 0){
			throw new BusinessException("活动参与用户有误");
		}
		UserDao userDao = BeanUtil.getBean(UserDao.class);
		User user = userDao.find(model.getUser().getId());
		if(user == null){
			throw new BusinessException("活动参与用户有误");
		}
		model.setUser(user);
	}

	/**
	 * 初始化参数
	 * @param model
	 */
	public void initParam() {
		PromotionHandleModel model = this.getPromotionHandleModel();
		this.setWay(model.getPromotionWay());
		this.setUser(model.getUser());
	}
	
	/**
	 * 处理队列
	 * @param promotionHandleModel
	 */
	public void doQueue() {
		PromotionService promotionService = BeanUtil.getBean(PromotionService.class);
		try {
			promotionService.handlePromotion(this);
		} catch (BusinessException e) {
			LogUtil.info("活动处理失败...." + this.getPromotionHandleModel().toString());
			LogUtil.info(e.getMessage());
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

	/** 获取【用户】 **/
	public User getUser() {
		return user;
	}

	/** 设置【用户】 **/
	public void setUser(User user) {
		this.user = user;
	}

	/** 获取【处理传输model】 **/
	public PromotionHandleModel getPromotionHandleModel() {
		return promotionHandleModel;
	}

	/** 设置【处理传输model】 **/
	public void setPromotionHandleModel(PromotionHandleModel promotionHandleModel) {
		this.promotionHandleModel = promotionHandleModel;
	}

}