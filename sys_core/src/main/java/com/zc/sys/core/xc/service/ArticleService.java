package com.zc.sys.core.xc.service;
import com.zc.sys.core.xc.model.ArticleModel;
import com.zc.sys.common.form.Result;
/**
 * 文章
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public interface ArticleService{

	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	public Result list(ArticleModel model);

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	public Result add(ArticleModel model);

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	public Result update(ArticleModel model);

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	public Result getById(ArticleModel model);

}