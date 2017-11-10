package com.zc.sys.promotion.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zc.sys.common.form.Result;
import com.zc.sys.promotion.dao.InterestFreeNoteDao;
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

		return null;
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result add(InterestFreeNoteModel model){

		return null;
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result update(InterestFreeNoteModel model){

		return null;
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result getById(InterestFreeNoteModel model){

		return null;
	}

}