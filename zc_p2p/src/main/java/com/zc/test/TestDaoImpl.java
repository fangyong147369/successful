package com.zc.test;

import org.springframework.stereotype.Repository;

import com.zc.common.dao.jpa.BaseDaoImpl;

/**
 *
 * @author zp
 * @since Oct 25, 2017
 */
@Repository("testDao")
public class TestDaoImpl extends BaseDaoImpl<TestModel> implements TestDao {

}
