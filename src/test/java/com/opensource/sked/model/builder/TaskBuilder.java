package com.opensource.sked.model.builder;

import java.util.Arrays;

import com.opensource.sked.model.Task;
import com.opensource.sked.model.TaskStatus;
import com.opensource.sked.model.UserComment;

public class TaskBuilder {

    Task task = new Task();

    public TaskBuilder() {

    }

    public TaskBuilder withTaskName(String taskName) {
        task.setTaskName(taskName);
        return this;
    }

    public TaskBuilder withTaskDescription(String taskDescription) {
        task.setTaskDescription(taskDescription);
        return this;
    }

    public TaskBuilder withStatus(TaskStatus status) {
        task.setStatus(status);
        return this;
    }

    public TaskBuilder withComments(String comments) {
        task.setComments(Arrays.asList(new UserComment[] { new UserComment(comments) }));
        return this;
    }

    public Task toTask() {
        return task;
    }
}
