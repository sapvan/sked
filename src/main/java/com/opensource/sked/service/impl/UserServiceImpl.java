package com.opensource.sked.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.security.userdetails.UserDetails;
import org.springframework.security.userdetails.UserDetailsService;
import org.springframework.security.userdetails.UsernameNotFoundException;

import com.opensource.sked.dao.BaseDao;
import com.opensource.sked.dao.UserDao;
import com.opensource.sked.model.User;
import com.opensource.sked.service.UserService;

public class UserServiceImpl extends BaseServiceImpl<User> implements UserService, UserDetailsService {

    @Resource
    private UserDao dao;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
        List<User> find = dao.getAllUsersByLogin(username);
        if (find == null || find.isEmpty()) {
            throw new UsernameNotFoundException("No User found with login = " + username);
        }
        if (find.size() > 1) {
            throw new IncorrectResultSizeDataAccessException("multiple user found with login = " + username, 1,
                    find.size());
        }
        return (User) find.get(0);
    }

    @Override
    protected BaseDao<User> getDao() {
        return dao;
    }

}
