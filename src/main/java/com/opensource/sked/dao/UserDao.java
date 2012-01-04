package com.opensource.sked.dao;

import java.util.List;

import javax.annotation.Resource;

import com.opensource.sked.model.User;

@Resource
public interface UserDao extends BaseDao<User> {

    List<User> getAllUsersByLogin(String username);

}
