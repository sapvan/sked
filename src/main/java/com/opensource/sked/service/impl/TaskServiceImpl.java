package com.opensource.sked.service.impl;

import javax.annotation.Resource;

import com.opensource.sked.dao.BaseDao;
import com.opensource.sked.dao.TaskDao;
import com.opensource.sked.model.Task;
import com.opensource.sked.model.TaskStatus;
import com.opensource.sked.model.User;
import com.opensource.sked.model.UserComment;
import com.opensource.sked.service.TaskService;

public class TaskServiceImpl extends BaseServiceImpl<Task> implements TaskService {
    @Resource
    private TaskDao dao;

    @Override
    protected BaseDao<Task> getDao() {
        return dao;
    }

    public void setDao(TaskDao dao) {
        this.dao = dao;
    }

    public void markAsDone(Task task, String comment, User user) {
        task.setStatus(TaskStatus.COMPLETE);
        addCommentToTask(task, comment, user);
        super.save(task);
    }

    private void addCommentToTask(Task task, String comment,User user) {
        if (comment != null) {
            UserComment uc = new UserComment(comment);
            uc.setAuthor(user);
            task.getComments().add(uc);
        }
    }

    @Override
    public Long create(Task domain) {
        domain.setStatus(TaskStatus.OPEN);
        return super.create(domain);
    }

    public void editTask(Task task, String comment, User user) {
        addCommentToTask(task, comment, user);
        super.save(task);
    }

    @Override
    public void save(Task domain) {
        throw new RuntimeException("");
    }

    public void assignTaskTo(Task task, User user, String comment) {
        task.setAssignedTo(user);
        addCommentToTask(task, comment, user);
        super.save(task);
    }
}
