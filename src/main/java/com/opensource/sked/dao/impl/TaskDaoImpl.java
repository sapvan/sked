package com.opensource.sked.dao.impl;

import com.opensource.sked.dao.TaskDao;
import com.opensource.sked.model.Task;

public class TaskDaoImpl extends BaseDaoImpl<Task> implements TaskDao
{
    @Override
    protected Class<Task> getEntityClass() {
        return Task.class;
    }

}