package com.opensource.sked.service.impl;

import static org.easymock.EasyMock.expect;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.security.userdetails.UserDetails;
import org.springframework.security.userdetails.UserDetailsService;
import org.springframework.security.userdetails.UsernameNotFoundException;
import org.unitils.UnitilsJUnit3;
import org.unitils.easymock.EasyMockUnitils;
import org.unitils.easymock.annotation.Mock;
import org.unitils.inject.annotation.InjectInto;

import com.opensource.sked.dao.UserDao;
import com.opensource.sked.model.User;
import com.opensource.sked.model.builder.UserBuilder;

public class UserServiceImplTest extends UnitilsJUnit3 {

    UserDetailsService service = new UserServiceImpl();

    @Mock
    @InjectInto(target = "service", property = "dao")
    UserDao dao;

    public void testLoadUserByUsername_happyPath() {
        expect(dao.getAllUsersByLogin("john")).andReturn(new UserBuilder().withLogin("john").toUserList());
        EasyMockUnitils.replay();
        UserDetails user = service.loadUserByUsername("john");
        EasyMockUnitils.verify();
        assertEquals("john", ((User) user).getUserLogin());
    }

    public void testLoadUserByUsername_null() {
        expect(dao.getAllUsersByLogin("john")).andReturn(null);
        EasyMockUnitils.replay();
        try {
            UserDetails user = service.loadUserByUsername("john");
            fail();
        } catch (UsernameNotFoundException e) {
            // expected
        } catch (DataAccessException e) {
            fail();
        }
    }

    public void testLoadUserByUsername_Empty() {
        expect(dao.getAllUsersByLogin("john")).andReturn(new ArrayList<User>());
        EasyMockUnitils.replay();
        try {
            UserDetails user = service.loadUserByUsername("john");
            fail();
        } catch (UsernameNotFoundException e) {
            // expected
        } catch (DataAccessException e) {
            fail();
        }
    }

    public void testLoadUserByUsername_MultipleUsers() {
        List<User> userList = new UserBuilder().withLogin("john").toUserList();
        List<User> userList2 = new UserBuilder().withLogin("john").toUserList();
        userList.addAll(userList2);
        expect(dao.getAllUsersByLogin("john")).andReturn(userList);
        EasyMockUnitils.replay();
        try {
            UserDetails user = service.loadUserByUsername("john");
            fail();
        } catch (UsernameNotFoundException e) {
            fail();
        } catch (DataAccessException e) {
            // expected
        }
    }

}
