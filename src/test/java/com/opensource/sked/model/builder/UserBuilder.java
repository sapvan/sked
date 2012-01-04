package com.opensource.sked.model.builder;

import java.util.ArrayList;
import java.util.List;

import com.opensource.sked.model.User;

public class UserBuilder {

    User user = new User();

    public UserBuilder withLogin(String login) {
        user.setUserLogin(login);
        return this;
    }

    public User toUser() {
        return user;
    }

    public List<User> toUserList() {
        ArrayList<User> list = new ArrayList<User>();
        list.add(user);
        return list;
    }
}
