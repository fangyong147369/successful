package com.zc.sys.promotion.dao;
import com.zc.sys.common.dao.BaseDao;
import com.zc.sys.common.model.jpa.PageDataList;
import com.zc.sys.promotion.entity.InterestFreeNote;
import com.zc.sys.promotion.model.InterestFreeNoteModel;
/**
 * 免息券
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public interface InterestFreeNoteDao extends BaseDao<InterestFreeNote> {

	/**
	 * 列表
	 * @param model
	 * @return
	 */
	PageDataList<InterestFreeNote> list(InterestFreeNoteModel model);
	
}