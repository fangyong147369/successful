package com.zc.sys.core.manage.service.impl;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.core.manage.entity.Operator;
import com.zc.sys.core.manage.model.OperatorModel;
import com.zc.sys.core.manage.model.RoleModel;
import com.zc.sys.core.manage.entity.Role;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import com.zc.sys.common.form.Result;
import com.zc.sys.core.manage.dao.OperatorDao;
import com.zc.sys.core.manage.service.OperatorService;

import java.util.ArrayList;
import java.util.List;

/**
 * 管理员
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Service
public class OperatorServiceImpl implements OperatorService {

	@Resource
	private OperatorDao operatorDao;

	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result list(OperatorModel model){
		PageDataList<Operator> pageDataList = operatorDao.list(model);
		PageDataList<OperatorModel> pageDataList_ = new PageDataList<OperatorModel>();
		pageDataList_.setPage(pageDataList.getPage());
		List<OperatorModel> list = new ArrayList<OperatorModel>();
		if(pageDataList != null && pageDataList.getList().size() > 0){
			for (Operator operator : pageDataList.getList()) {
				OperatorModel model_ = OperatorModel.instance(operator);
				model_.setRoleModel(RoleModel.instance(operator.getRole()));
				list.add(model_);
			}
		}
		pageDataList_.setList(list);
		return Result.success().setData(pageDataList_);
	}

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	@Override
	@Transactional
	public Result add(OperatorModel model){
		Operator operator = model.prototype();
		operatorDao.save(operator);
		return Result.success().setData(operator);
	}

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	@Override
	@Transactional
	public Result update(OperatorModel model){
		Operator operator = operatorDao.find(model.getId());
		operatorDao.update(operator);
		return Result.success();
	}

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	@Override
	public Result getById(OperatorModel model){
		if(model.getId() <= 0){
			return Result.error("参数错误！");
		}
		Operator operater = operatorDao.find(model.getId());
		return Result.success().setData(operater);
	}

	/**
	 * 登录
	 * @param model
	 * @return
	 */
	public Result signIn(OperatorModel model){
		if(model.getName() == null || model.getName().isEmpty()){
			return Result.error("用户名不能为空.");
		}
		if(model.getPwd() == null || model.getPwd().isEmpty()){
			return Result.error("密码不能为空.");
		}
		String[] names=new String[]{"name","pwd"};
		Object[] values=new Object[]{model.getName(),model.getPwd()};
		Operator operater = operatorDao.findForUniqueBySql("select * from zc_m_operator  WHERE name=:name and pwd=:pwd ",names,values);
		OperatorModel model_ = OperatorModel.instance(operater);
		RoleModel roleModel = new RoleModel();
		roleModel.setId(operater.getRole().getId());
		model_.setRoleModel(roleModel);
		return Result.success().setData(model_ );
	}

}