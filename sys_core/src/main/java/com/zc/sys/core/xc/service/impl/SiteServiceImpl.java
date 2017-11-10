package com.zc.sys.core.xc.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zc.sys.common.form.Result;
import com.zc.sys.core.xc.dao.SiteDao;
import com.zc.sys.core.xc.model.SiteModel;
import com.zc.sys.core.xc.service.SiteService;
/**
 * 栏目
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Service
public class SiteServiceImpl implements SiteService {

	@Resource
	private SiteDao siteDao;
	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result list(SiteModel model){

		return null;
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result add(SiteModel model){

		return null;
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result update(SiteModel model){

		return null;
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result getById(SiteModel model){

		return null;
	}

}