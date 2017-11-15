package com.zc.sys.api.zc;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zc.sys.common.exception.BussinessException;
import com.zc.sys.common.form.Result;
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
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Object list(OperatorModel model) throws BussinessException {
//		queueService.send(new QueueModel("appPushMessage", "1111111111111", ""));
//		queueService.send(new QueueModel("cashLoan", "2222222222222", ""));
//		queueService.send(new QueueModel("realNameIdentify", "3333333333333", ""));
		model.setName("222222222");
		return new Result(true).setData(model);
	}
}
