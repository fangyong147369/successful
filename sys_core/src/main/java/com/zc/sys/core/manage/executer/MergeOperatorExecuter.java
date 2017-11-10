package com.zc.sys.core.manage.executer;

import org.springframework.stereotype.Component;

import com.zc.sys.common.exception.BussinessException;
import com.zc.sys.core.common.executer.BaseExecuter;
import com.zc.sys.core.manage.model.OperatorModel;

/**
 * 合并管理员任务类
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Component
public class MergeOperatorExecuter extends BaseExecuter{

	private OperatorModel model;
	

	@Override
	public void init() {
		if(this.obj instanceof OperatorModel){
			this.model = (OperatorModel) this.obj;
		}else {
			throw new BussinessException("实例化model不存在");
		}
	}
	
	
	@Override
	public void addOperateLog() {
		
	}
	
}
