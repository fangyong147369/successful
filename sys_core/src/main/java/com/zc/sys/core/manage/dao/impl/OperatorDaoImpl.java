package com.zc.sys.core.manage.dao.impl;
import com.zc.sys.common.model.jpa.OrderFilter;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.common.model.jpa.QueryParam;
import com.zc.sys.common.model.jpa.SearchFilter;
import com.zc.sys.common.util.validate.StringUtil;
import com.zc.sys.core.manage.entity.Operator;
import com.zc.sys.core.manage.model.OperatorModel;
import org.springframework.stereotype.Repository;
import com.zc.sys.common.dao.jpa.BaseDaoImpl;
import com.zc.sys.core.manage.dao.OperatorDao;

/**
 * 管理员
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Repository
public class OperatorDaoImpl extends BaseDaoImpl<Operator> implements OperatorDao {

    /**
     * 列表
     * @param model
     * @return
     */
    @Override
    public PageDataList<Operator> list(OperatorModel model) {
        QueryParam param = QueryParam.getInstance();
        if(StringUtil.isNotBlank(model.getSearchName())){
            SearchFilter orFilter2 = new SearchFilter("name", SearchFilter.Operators.LIKE, model.getSearchName().trim());
            param.addOrFilter(orFilter2);
        }else {
            if (StringUtil.isNotBlank(model.getName())) {
                param.addParam("name", SearchFilter.Operators.LIKE, model.getName().trim());
            }
            if (model.getState() != 0) {
                param.addParam("state", model.getState());
            }
        }
        param.addOrder(OrderFilter.OrderType.ASC, "id");
        param.addPage(model.getPageNo(), model.getPageSize());
        return super.findPageList(param);
    }

}