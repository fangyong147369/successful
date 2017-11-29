package com.zc.sys.promotion.dao;
import com.zc.sys.common.dao.BaseDao;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.promotion.entity.InterestFreeNoteRecord;
import com.zc.sys.promotion.model.InterestFreeNoteRecordModel;
/**
 * 免息券发放记录
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public interface InterestFreeNoteRecordDao extends BaseDao<InterestFreeNoteRecord> {

	/**
	 * 列表
	 * @param model
	 * @return
	 */
	PageDataList<InterestFreeNoteRecord> list(InterestFreeNoteRecordModel model);
	
}