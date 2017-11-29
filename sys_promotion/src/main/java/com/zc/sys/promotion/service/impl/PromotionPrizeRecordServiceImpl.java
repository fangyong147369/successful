package com.zc.sys.promotion.service.impl;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zc.sys.common.form.Result;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.promotion.dao.PromotionPrizeRecordDao;
import com.zc.sys.promotion.entity.PromotionPrizeRecord;
import com.zc.sys.promotion.model.PromotionPrizeRecordModel;
import com.zc.sys.promotion.service.PromotionPrizeRecordService;
/**
 * 活动推广奖励记录
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Service
public class PromotionPrizeRecordServiceImpl implements PromotionPrizeRecordService {

	@Resource
	private PromotionPrizeRecordDao promotionPrizeRecordDao;
	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result list(PromotionPrizeRecordModel model){
		PageDataList<PromotionPrizeRecord> pageDataList = promotionPrizeRecordDao.list(model);
		PageDataList<PromotionPrizeRecordModel> pageDataList_ = new PageDataList<PromotionPrizeRecordModel>();
		pageDataList_.setPage(pageDataList.getPage());
		List<PromotionPrizeRecordModel> list = new ArrayList<PromotionPrizeRecordModel>();
		if(pageDataList != null && pageDataList.getList().size() > 0){
			for (PromotionPrizeRecord promotionPrizeRecord : pageDataList.getList()) {
				PromotionPrizeRecordModel model_ = PromotionPrizeRecordModel.instance(promotionPrizeRecord);
				list.add(model_);
			}
		}
		pageDataList_.setList(list);
		return Result.success().setData(pageDataList_);
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result add(PromotionPrizeRecordModel model){

		return null;
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result update(PromotionPrizeRecordModel model){

		return null;
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result getById(PromotionPrizeRecordModel model){

		return null;
	}

}