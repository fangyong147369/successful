package com.zc.sys.core.sys.dao;
import com.zc.sys.common.dao.BaseDao;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.core.sys.entity.Dict;
import com.zc.sys.core.sys.model.DictModel;
/**
 * 字典
 * 
 * @author zp
 * @version 2.0.0.0
 * @since 2017年7月29日
 */
public interface DictDao extends BaseDao<Dict> {

	/**
	 * 列表
	 * @param model
	 * @return
	 */
	PageDataList<Dict> list(DictModel model);

}
