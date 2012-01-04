package com.opensource.sked.web.action;

import org.springframework.security.Authentication;
import org.springframework.security.context.SecurityContextHolder;

import com.opensource.sked.model.User;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport {

    private String userName;

    public String getUserName() {
        return userName;
    }

    @Override
    public String execute() throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        userName = user.getFirstName() + " " + user.getLastName();
        return SUCCESS;
    }
}
