package com.zc.sys.api.zc.xc;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zc.sys.common.exception.BusinessException;
import com.zc.sys.core.common.web.BaseController;
import com.zc.sys.core.xc.model.ArticleModel;
import com.zc.sys.core.xc.service.ArticleService;
/**
 * 文章
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@RestController
@RequestMapping("/xc/article")
public class ArticleController extends BaseController<ArticleModel> {

	@Resource
	ArticleService articleService;

	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Object list(ArticleModel model) throws BusinessException {
		return articleService.list(model);
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Object add(ArticleModel model) throws BusinessException {
		return articleService.add(model);
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Object update(ArticleModel model) throws BusinessException {
		return articleService.update(model);
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/getById", method = RequestMethod.POST)
	@ResponseBody
	public Object getById(ArticleModel model) throws BusinessException {
		return articleService.getById(model);
	}
}