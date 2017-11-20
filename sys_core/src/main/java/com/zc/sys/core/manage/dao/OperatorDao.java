package com.zc.sys.core.manage.dao;
import com.zc.sys.common.dao.BaseDao;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.core.manage.entity.Operator;
import com.zc.sys.core.manage.model.OperatorModel;

/**
 * 管理员
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public interface OperatorDao extends BaseDao<Operator> {
    /**
     * 列表
     * @param model
     * @return
     */
    PageDataList<Operator> list(OperatorModel model);
}