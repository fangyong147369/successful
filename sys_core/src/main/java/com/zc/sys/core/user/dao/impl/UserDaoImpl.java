package com.zc.sys.core.user.dao.impl;
import org.springframework.stereotype.Repository;

import com.zc.sys.common.dao.jpa.BaseDaoImpl;
import com.zc.sys.core.user.dao.UserDao;
import com.zc.sys.core.user.entity.User;
/**
 * 用户
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

}