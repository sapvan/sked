package com.opensource.sked.dao.impl;

import java.util.Arrays;
import java.util.List;

import org.unitils.UnitilsJUnit3;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.reflectionassert.ReflectionAssert;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBeanByType;

import com.opensource.sked.dao.UserDao;
import com.opensource.sked.model.User;

@SpringApplicationContext({ "applicationContext-database.xml",
        "applicationContext-dao.xml" })
public class UserDaoTest extends UnitilsJUnit3 {
    @SpringBeanByType
    UserDao userDao;

    public void testCreateUser() throws Exception {
        User domain = new User();
        Long create = userDao.create(domain);
        assertNotNull(create);
    }

    @DataSet("UserTest-testFindById.xml")
    public void testFindById() {
        assertNotNull(userDao.findById(1L));
        assertEquals(new Long(1L), userDao.findById(1L).getUserId());
    }

    @DataSet("UserTest-testFindById.xml")
    public void testSave() {
        User domain = userDao.findById(1L);
        domain.setUserLogin("ChangedName");
        userDao.save(domain);
        assertEquals("ChangedName", userDao.findById(1L).getUserLogin());
    }

    @DataSet("UserTest-testListAll.xml")
    public void testListAll() {
        List<User> listAll = userDao.listAll();
        ReflectionAssert.assertPropertyLenientEquals("userLogin", Arrays.asList(
                "test1", "test2"), listAll);

    }
}