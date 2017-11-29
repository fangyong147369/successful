package com.zc.sys.promotion.constant;

/**
 * 常量
 * 
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月6日
 */
public final class BasePromotionConstant {
	
	/** DB=========================================================start **/
	/** 表前缀  **/
	public static final String DB_PREFIX = "zc_";
	/** 表模块-pt-活动推广  **/
	public static final String DB_MODEL_Pt = "pt";
	/** DB=========================================================end **/
	
	/** Promotion-Way==============================================start **/
	/** 推广活动方式  **/
	public enum PromotionWay {
		promotionWayReg("注册", 1), promotionWayLogin("登录", 2), promotionWayDraw("抽奖", 2);
        private String name;
        private int index;

        private PromotionWay(String name, int index) {
            this.name = name;
            this.index = index;
        }

        public int getIndex() {
            return this.index;
        }

        public String getName() {
            return this.name;
        }
    }
	/** Promotion-Way===============================================end **/
	
	/** PromotionPrize-type==============================================start **/
	/** 推广活动奖励类型-免息券  **/
	public static final int PROMOTIONPRIZE_TYPE_IFNOTE = 1;
	/** PromotionPrize-type===============================================end **/
	
	
}
