package com.zc.test;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 *
 * @author zp
 * @since Oct 25, 2017
 */
@Service
public class TestServiceImpl implements TestService{

	@Resource
	private TestDao testDao;
	
	@Override
	public TestModel find(int id) {
		return testDao.find(id);
	}

}
