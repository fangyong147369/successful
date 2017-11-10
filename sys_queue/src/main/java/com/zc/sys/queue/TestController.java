package com.zc.sys.queue;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zc.sys.common.exception.BussinessException;
import com.zc.sys.core.common.queue.pojo.QueueModel;
import com.zc.sys.core.common.queue.service.QueueService;
import com.zc.sys.core.common.web.BaseController;
import com.zc.sys.core.manage.model.OperatorModel;

/**
 * 测试
 * @author zp
 * @since Nov 8, 2017
 */
@RestController
public class TestController  extends BaseController<OperatorModel> {

	@Resource
	private QueueService queueService;
	
	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/")
	public Object list() throws BussinessException {
		queueService.send(new QueueModel("invest", "1111111111111", ""));
		queueService.send(new QueueModel("loan", "2222222222222", ""));
		return "测试";
	}
}
