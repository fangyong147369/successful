package com.zc.sys.core.xc.service;
import com.zc.sys.core.xc.model.SiteModel;
import com.zc.sys.common.form.Result;
/**
 * 栏目
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public interface SiteService{

	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	public Result list(SiteModel model);

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	public Result add(SiteModel model);

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	public Result update(SiteModel model);

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	public Result getById(SiteModel model);

}