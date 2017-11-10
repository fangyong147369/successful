package com.zc.sys.promotion.service;
import com.zc.sys.promotion.model.InterestFreeNoteModel;
import com.zc.sys.common.form.Result;
/**
 * 免息券
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public interface InterestFreeNoteService{

	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	public Result list(InterestFreeNoteModel model);

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	public Result add(InterestFreeNoteModel model);

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	public Result update(InterestFreeNoteModel model);

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	public Result getById(InterestFreeNoteModel model);

}