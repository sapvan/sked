package com.opensource.sked.dao.impl;

import com.opensource.sked.dao.UserCommentDao;
import com.opensource.sked.model.UserComment;

public class UserCommentDaoImpl extends BaseDaoImpl<UserComment> implements UserCommentDao
{
    @Override
    protected Class<UserComment> getEntityClass() {
        return UserComment.class;
    }

}