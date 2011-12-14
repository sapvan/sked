package com.opensource.sked.service;

import org.springframework.transaction.annotation.Transactional;

import com.opensource.sked.model.Task;
import com.opensource.sked.model.User;

public interface TaskService extends BaseService<Task>
{
    @Transactional(readOnly = false)
    public void markAsDone(Task task, String comment, User user);

    @Transactional(readOnly = false)
    public void editTask(Task task, String comment, User user);
}