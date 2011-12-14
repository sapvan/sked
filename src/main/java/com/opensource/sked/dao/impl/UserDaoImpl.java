package com.opensource.sked.dao.impl;

import com.opensource.sked.dao.UserDao;
import com.opensource.sked.model.User;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }
}
