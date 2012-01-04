package com.opensource.sked.service.impl;

import static org.easymock.EasyMock.expect;

import java.util.ArrayList;

import org.unitils.UnitilsJUnit3;
import org.unitils.easymock.EasyMockUnitils;
import org.unitils.easymock.annotation.Mock;
import org.unitils.inject.annotation.InjectInto;

import com.opensource.sked.dao.TaskDao;
import com.opensource.sked.model.Task;
import com.opensource.sked.model.TaskStatus;
import com.opensource.sked.model.User;
import com.opensource.sked.model.builder.TaskBuilder;
import com.opensource.sked.service.TaskService;

public class TaskServiceTest extends UnitilsJUnit3 {
    TaskService taskService = new TaskServiceImpl();

    @Mock
    @InjectInto(target = "taskService", property = "dao")
    TaskDao taskDao;

    public void testCreateTask() throws Exception {
        Task task = new TaskBuilder().withStatus(TaskStatus.OPEN).toTask();
        
        // task.setTaskDescription();
        // task.setTaskId();
        // task.setTaskName();

        expect(taskDao.create(task)).andReturn(1L);

        EasyMockUnitils.replay();

        Task task1 = new Task();
        Long id = taskService.create(task1);

        EasyMockUnitils.verify();

        assertEquals(new Long(1), id);

    }

    public void testUpdateTask() throws Exception {
        Task task = new Task();
        try {
            taskService.save(task);
            fail("direct save should not be allowed");
        } catch (Exception e) {
        }
    }

    public void testFindAllTask() throws Exception {

        expect(taskDao.listAll()).andReturn(new ArrayList());

        EasyMockUnitils.replay();

        taskService.listAll();

        EasyMockUnitils.verify();

    }

    public void testMarkAsDone() throws Exception {

        Task task = new TaskBuilder().withStatus(TaskStatus.COMPLETE).toTask();

        taskDao.save(task);

        EasyMockUnitils.replay();

        Task task1 = new TaskBuilder().withStatus(TaskStatus.OPEN).toTask();

        taskService.markAsDone(task1, null, null);

        EasyMockUnitils.verify();

    }

    public void testMarkAsDoneWithComments() throws Exception {

        Task task = new TaskBuilder().withStatus(TaskStatus.COMPLETE).withTaskName("ABC").withComments("dummy comment")
                .toTask();

        taskDao.save(task);

        EasyMockUnitils.replay();

        Task task1 = new TaskBuilder().withStatus(TaskStatus.OPEN).withTaskName("ABC").toTask();

        taskService.markAsDone(task1, "dummy comment", new User());

        EasyMockUnitils.verify();
    }

    public void testEditTask() throws Exception {

        Task task = new Task();

        taskDao.save(task);

        EasyMockUnitils.replay();

        taskService.editTask(task, null, null);

        EasyMockUnitils.verify();

    }

    public void testEditTaskWithComment() throws Exception {

        Task task = new Task();

        taskDao.save(task);

        EasyMockUnitils.replay();

        taskService.editTask(task, "dummy comment", new User());

        EasyMockUnitils.verify();

    }
}
