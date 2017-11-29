package com.zc.sys.promotion.service.impl;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zc.sys.common.exception.BusinessException;
import com.zc.sys.common.exception.NoRollBackException;
import com.zc.sys.common.form.Result;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.promotion.dao.InterestFreeNoteRecordDao;
import com.zc.sys.promotion.entity.InterestFreeNoteRecord;
import com.zc.sys.promotion.model.InterestFreeNoteRecordModel;
import com.zc.sys.promotion.service.InterestFreeNoteRecordService;
/**
 * 免息券发放记录
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Service
public class InterestFreeNoteRecordServiceImpl implements InterestFreeNoteRecordService {

	@Resource
	private InterestFreeNoteRecordDao interestFreeNoteRecordDao;
	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result list(InterestFreeNoteRecordModel model){
		PageDataList<InterestFreeNoteRecord> pageDataList = interestFreeNoteRecordDao.list(model);
		PageDataList<InterestFreeNoteRecordModel> pageDataList_ = new PageDataList<InterestFreeNoteRecordModel>();
		pageDataList_.setPage(pageDataList.getPage());
		List<InterestFreeNoteRecordModel> list = new ArrayList<InterestFreeNoteRecordModel>();
		if(pageDataList != null && pageDataList.getList().size() > 0){
			for (InterestFreeNoteRecord interestFreeNoteRecord : pageDataList.getList()) {
				InterestFreeNoteRecordModel model_ = InterestFreeNoteRecordModel.instance(interestFreeNoteRecord);
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
	 * @throws NoRollBackException 
 	 */
	@Override
	public Result add(InterestFreeNoteRecordModel model) throws NoRollBackException{
		model.validAdd();//校验添加参数
		model.initAdd();//初始化添加
		giveOut(model);//发放方法
		return Result.success();
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result update(InterestFreeNoteRecordModel model){

		return null;
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result getById(InterestFreeNoteRecordModel model){
		if(model.getId() <= 0){
			throw new BusinessException("参数错误");
		}
		return Result.success().setData(interestFreeNoteRecordDao.find(model.getId()));
	}

	/**
	 * 发放
	 * @param model
	 * @return
	 * @throws NoRollBackException 
	 */
	@Override
	@Transactional
	public synchronized Result giveOut(InterestFreeNoteRecordModel model) throws NoRollBackException {
		InterestFreeNoteRecord interestFreeNoteRecord = model.prototype();
		model.checkAndInitSend(interestFreeNoteRecord);//校验发放
		interestFreeNoteRecordDao.save(interestFreeNoteRecord);
		return Result.success();
	}
	
	

}