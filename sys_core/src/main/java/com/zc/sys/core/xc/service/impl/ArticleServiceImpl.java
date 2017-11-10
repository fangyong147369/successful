package com.zc.sys.core.xc.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zc.sys.common.form.Result;
import com.zc.sys.core.xc.dao.ArticleDao;
import com.zc.sys.core.xc.model.ArticleModel;
import com.zc.sys.core.xc.service.ArticleService;
/**
 * 文章
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Service
public class ArticleServiceImpl implements ArticleService {

	@Resource
	private ArticleDao articleDao;
	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result list(ArticleModel model){

		return null;
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result add(ArticleModel model){

		return null;
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result update(ArticleModel model){

		return null;
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result getById(ArticleModel model){

		return null;
	}

}