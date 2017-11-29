package com.zc.sys.promotion.service.impl;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zc.sys.common.exception.BusinessException;
import com.zc.sys.common.form.Result;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.promotion.dao.InterestFreeNoteDao;
import com.zc.sys.promotion.entity.InterestFreeNote;
import com.zc.sys.promotion.model.InterestFreeNoteModel;
import com.zc.sys.promotion.service.InterestFreeNoteService;
/**
 * 免息券
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Service
public class InterestFreeNoteServiceImpl implements InterestFreeNoteService {

	@Resource
	private InterestFreeNoteDao interestFreeNoteDao;
	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result list(InterestFreeNoteModel model){
		PageDataList<InterestFreeNote> pageDataList = interestFreeNoteDao.list(model);
		PageDataList<InterestFreeNoteModel> pageDataList_ = new PageDataList<InterestFreeNoteModel>();
		pageDataList_.setPage(pageDataList.getPage());
		List<InterestFreeNoteModel> list = new ArrayList<InterestFreeNoteModel>();
		if(pageDataList != null && pageDataList.getList().size() > 0){
			for (InterestFreeNote interestFreeNote : pageDataList.getList()) {
				InterestFreeNoteModel model_ = InterestFreeNoteModel.instance(interestFreeNote);
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
	public Result add(InterestFreeNoteModel model){
		model.validAdd();//校验添加参数
		model.initAdd();//初始化添加
		InterestFreeNote interestFreeNote = model.prototype();
		interestFreeNoteDao.save(interestFreeNote);
		return Result.success();
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result update(InterestFreeNoteModel model){
		InterestFreeNote interestFreeNote = model.validUpdate();//校验修改参数
		model.initUpdate(interestFreeNote);//初始化修改
		interestFreeNoteDao.update(interestFreeNote);
		return Result.success();
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result getById(InterestFreeNoteModel model){
		if(model.getId() <= 0){
			throw new BusinessException("参数错误");
		}
		return Result.success().setData(interestFreeNoteDao.find(model.getId()));
	}

}