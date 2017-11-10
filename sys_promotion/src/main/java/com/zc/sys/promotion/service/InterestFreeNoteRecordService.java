package com.zc.sys.promotion.service;
import com.zc.sys.promotion.model.InterestFreeNoteRecordModel;
import com.zc.sys.common.form.Result;
/**
 * 免息券发放记录
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public interface InterestFreeNoteRecordService{

	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	public Result list(InterestFreeNoteRecordModel model);

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	public Result add(InterestFreeNoteRecordModel model);

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	public Result update(InterestFreeNoteRecordModel model);

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	public Result getById(InterestFreeNoteRecordModel model);

}