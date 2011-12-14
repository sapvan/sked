package com.opensource.sked.dao.impl;

import java.util.Arrays;
import java.util.List;

import org.unitils.UnitilsJUnit3;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.reflectionassert.ReflectionAssert;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBeanByType;

import com.opensource.sked.dao.UserCommentDao;
import com.opensource.sked.model.UserComment;

@SpringApplicationContext({ "applicationContext-database.xml",
        "applicationContext-dao.xml" })
public class UserCommentDaoTest extends UnitilsJUnit3
{
    @SpringBeanByType
    UserCommentDao userCommentDao;

    public void testCreateUserComment() throws Exception
    {
        UserComment domain = new UserComment();
        Long create = userCommentDao.create(domain);
        assertNotNull(create);
    }

    @DataSet({ "UserCommentTest-testFindById.xml" })
    public void testFindById() throws Exception {
        assertNotNull(userCommentDao.findById(1L));
        assertEquals(new Long(1L), userCommentDao.findById(1L).getUserCommentId());
    }

    @DataSet({ "UserCommentTest-testFindById.xml" })
    public void testSave() throws Exception {
        UserComment domain = userCommentDao.findById(1L);
        domain.setComment("ChangedName");
        userCommentDao.save(domain);
        assertEquals("ChangedName", userCommentDao.findById(1L).getComment());
    }

    @DataSet({ "UserCommentTest-testListAll.xml" })
    public void testListAll() throws Exception {
        List<UserComment> listAll = userCommentDao.listAll();
        ReflectionAssert.assertPropertyLenientEquals("comment", Arrays.asList(
                "test1", "test2"), listAll);

    }

}
