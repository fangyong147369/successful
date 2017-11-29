package com.zc.sys.promotion.service.impl;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zc.sys.common.exception.BusinessException;
import com.zc.sys.common.form.Result;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.promotion.dao.PromotionPrizeConfigDao;
import com.zc.sys.promotion.entity.PromotionPrizeConfig;
import com.zc.sys.promotion.model.PromotionPrizeConfigModel;
import com.zc.sys.promotion.service.PromotionPrizeConfigService;
/**
 * 活动推广奖励配置
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Service
public class PromotionPrizeConfigServiceImpl implements PromotionPrizeConfigService {

	@Resource
	private PromotionPrizeConfigDao promotionPrizeConfigDao;
	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result list(PromotionPrizeConfigModel model){
		PageDataList<PromotionPrizeConfig> pageDataList = promotionPrizeConfigDao.list(model);
		PageDataList<PromotionPrizeConfigModel> pageDataList_ = new PageDataList<PromotionPrizeConfigModel>();
		pageDataList_.setPage(pageDataList.getPage());
		List<PromotionPrizeConfigModel> list = new ArrayList<PromotionPrizeConfigModel>();
		if(pageDataList != null && pageDataList.getList().size() > 0){
			for (PromotionPrizeConfig promotionPrizeConfig : pageDataList.getList()) {
				PromotionPrizeConfigModel model_ = PromotionPrizeConfigModel.instance(promotionPrizeConfig);
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
	public Result add(PromotionPrizeConfigModel model){
		model.validAdd();//校验添加参数
		model.initAdd();//初始化添加
		PromotionPrizeConfig promotionPrizeConfig = model.prototype();
		promotionPrizeConfigDao.save(promotionPrizeConfig);
		return Result.success();
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result update(PromotionPrizeConfigModel model){
		PromotionPrizeConfig promotionPrizeConfig = model.validUpdate();//校验修改参数
		model.initUpdate(promotionPrizeConfig);//初始化修改
		promotionPrizeConfigDao.update(promotionPrizeConfig);
		return Result.success();
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result getById(PromotionPrizeConfigModel model){
		if(model.getId() <= 0){
			throw new BusinessException("参数错误");
		}
		return Result.success().setData(promotionPrizeConfigDao.find(model.getId()));
	}

}