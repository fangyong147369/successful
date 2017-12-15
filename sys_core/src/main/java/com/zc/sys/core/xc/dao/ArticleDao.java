package com.zc.sys.core.xc.dao;
import com.zc.sys.common.dao.BaseDao;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.core.xc.entity.Article;
import com.zc.sys.core.xc.model.ArticleModel;
/**
 * 文章
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public interface ArticleDao extends BaseDao<Article> {
	/**
	 * 列表
	 * @param model
	 * @return
	 */
	PageDataList<Article> list(ArticleModel model);

}