package com.zc.sys.promotion.entity;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.zc.sys.common.entity.LongPKEntity;
import com.zc.sys.promotion.constant.BaseConstant;
/**
 * 活动推广奖励配置
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Entity
@Table(name=BaseConstant.DB_PREFIX + BaseConstant.DB_MODEL_Pt + "_promotion_prize_config")
public class PromotionPrizeConfig extends LongPKEntity {
	/** 序列号 **/
	private static final long serialVersionUID = 1L;

}