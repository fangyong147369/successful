package com.zc.sys.core.sys.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zc.sys.common.form.Result;
import com.zc.sys.core.sys.dao.TemplateDao;
import com.zc.sys.core.sys.model.TemplateModel;
import com.zc.sys.core.sys.service.TemplateService;
/**
 * 模版配置
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月08日
 */
@Service
public class TemplateServiceImpl implements TemplateService {

	@Resource
	private TemplateDao templateDao;
	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result list(TemplateModel model){

		return null;
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result add(TemplateModel model){

		return null;
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result update(TemplateModel model){

		return null;
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result getById(TemplateModel model){

		return null;
	}

}