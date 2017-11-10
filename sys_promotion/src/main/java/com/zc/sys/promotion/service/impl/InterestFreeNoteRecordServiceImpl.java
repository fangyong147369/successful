package com.zc.sys.promotion.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zc.sys.common.form.Result;
import com.zc.sys.promotion.dao.InterestFreeNoteRecordDao;
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

		return null;
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result add(InterestFreeNoteRecordModel model){

		return null;
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

		return null;
	}

}