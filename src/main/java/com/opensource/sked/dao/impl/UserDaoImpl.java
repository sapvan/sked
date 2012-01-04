package com.opensource.sked.dao.impl;

import java.util.List;

import com.opensource.sked.dao.UserDao;
import com.opensource.sked.model.User;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

    @SuppressWarnings("unchecked")
    public List<User> getAllUsersByLogin(String username) {
        return getHibernateTemplate().find("from User u where u.userLogin = ?", username);
    }
}
