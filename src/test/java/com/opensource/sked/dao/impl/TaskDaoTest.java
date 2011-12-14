package com.opensource.sked.dao.impl;

import java.util.Arrays;
import java.util.List;

import org.unitils.UnitilsJUnit3;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.reflectionassert.ReflectionAssert;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBeanByType;

import com.opensource.sked.dao.TaskDao;
import com.opensource.sked.model.Task;

@SpringApplicationContext({ "applicationContext-database.xml",
        "applicationContext-dao.xml" })
public class TaskDaoTest extends UnitilsJUnit3
{
    @SpringBeanByType
    TaskDao taskDao;

    public void testCreateTask() throws Exception
    {
        Task domain = new Task();
        //

        Long create = taskDao.create(domain);
        assertNotNull(create);
    }

    @DataSet("TaskTest-testFindById.xml")
    public void testFindById() throws Exception {
        assertNotNull(taskDao.findById(1L));
        assertEquals(new Long(1L), taskDao.findById(1L).getTaskId());
    }

    @DataSet("TaskTest-testFindById.xml")
    public void testSave() throws Exception {
        Task domain = taskDao.findById(1L);
        domain.setTaskDescription("ChangedName");
        taskDao.save(domain);
        assertEquals("ChangedName", taskDao.findById(1L).getTaskDescription());
    }

    @DataSet("TaskTest-testListAll.xml")
    public void testListAll() throws Exception {
        List<Task> listAll = taskDao.listAll();
        ReflectionAssert.assertPropertyLenientEquals("taskName", Arrays.asList(
                "test1", "test2"), listAll);

    }

}
