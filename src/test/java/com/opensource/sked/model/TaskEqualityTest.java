package com.opensource.sked.model;

import com.opensource.sked.model.Task;
import com.opensource.sked.model.TaskStatus;
import com.opensource.sked.model.builder.TaskBuilder;

import junit.framework.TestCase;

public class TaskEqualityTest extends TestCase {

    public void testEqualGeneralCase() {
        Task t1 = new TaskBuilder().withTaskName("ABC").toTask();
        assertFalse(t1.equals(null));
        assertFalse(t1.equals(new Object()));

        assertTrue(t1.equals(t1));

        assertEquals(t1.hashCode(), t1.hashCode());
    }

    public void testEqualWithName() {
        Task t1 = new TaskBuilder().withTaskName("ABC").toTask();
        Task t2 = new TaskBuilder().withTaskName("ABC").toTask();
        assertTrue(t1.equals(t2));

        Task t3 = new TaskBuilder().withTaskName("ABC123").toTask();
        assertFalse(t1.equals(t3));

        Task t4 = new TaskBuilder().toTask();
        assertFalse(t1.equals(t4));
        assertFalse(t4.equals(t1));
    }

    public void testEqualWithStatus() {
        Task t1 = new TaskBuilder().withStatus(TaskStatus.COMPLETE).toTask();
        Task t2 = new TaskBuilder().withStatus(TaskStatus.COMPLETE).toTask();
        assertTrue(t1.equals(t2));

        Task t3 = new TaskBuilder().withStatus(TaskStatus.IN_PROGRESS).toTask();
        assertFalse(t1.equals(t3));

        Task t4 = new TaskBuilder().toTask();
        assertFalse(t1.equals(t4));
        assertFalse(t4.equals(t1));
    }

    public void testEqualWithDescription() {
        Task t1 = new TaskBuilder().withTaskDescription("abc").toTask();
        Task t2 = new TaskBuilder().withTaskDescription("abc").toTask();
        assertTrue(t1.equals(t2));
        assertEquals(t1.hashCode(), t2.hashCode());

        Task t3 = new TaskBuilder().withTaskDescription("abc123").toTask();
        assertFalse(t1.equals(t3));

        Task t4 = new TaskBuilder().toTask();
        assertFalse(t1.equals(t4));
        assertFalse(t4.equals(t1));
    }

    public void testHashCode() {
        Task t1 = new TaskBuilder().withTaskName("asdasd").withTaskDescription("abc").withStatus(TaskStatus.COMPLETE)
                .toTask();
        Task t2 = new TaskBuilder().withTaskDescription("abc").toTask();
        assertNotSame(t1.hashCode(), t2.hashCode());
        Task t3 = new TaskBuilder().toTask();
    }
}
