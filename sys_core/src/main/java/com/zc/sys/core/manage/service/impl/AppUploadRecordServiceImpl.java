package com.zc.sys.core.manage.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zc.sys.common.form.Result;
import com.zc.sys.core.manage.dao.AppUploadRecordDao;
import com.zc.sys.core.manage.model.AppUploadRecordModel;
import com.zc.sys.core.manage.service.AppUploadRecordService;
/**
 * 安卓包上传记录
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Service
public class AppUploadRecordServiceImpl implements AppUploadRecordService {

	@Resource
	private AppUploadRecordDao appUploadRecordDao;
	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result list(AppUploadRecordModel model){

		return null;
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result add(AppUploadRecordModel model){

		return null;
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result update(AppUploadRecordModel model){

		return null;
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result getById(AppUploadRecordModel model){

		return null;
	}

}