package com.zc.sys.core.integral.entity;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.zc.sys.common.entity.LongPKEntity;
import com.zc.sys.core.common.constant.BaseConstant;
/**
 * 积分账户
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Entity
@Table(name=BaseConstant.DB_PREFIX + BaseConstant.DB_MODEL_Jf + "_integral_account")
public class IntegralAccount extends LongPKEntity {
	/** 序列号 **/
	private static final long serialVersionUID = 1L;

}