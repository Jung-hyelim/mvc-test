package com.test.dao;

import com.test.dao.UserDao;
import com.test.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:root-context.xml")
public class UserDaoTest {

    User user;

    @Inject
    private UserDao userDao;

    @Before
    public void 사용자객체_생성() {
        final String LOGIN_ID = "stunitas1";
        final String NAME = "에스티유니타스";
        final int AGE = 30;
        user = new User(null, LOGIN_ID, NAME, AGE);
    }

    @Test
    public void 사용자_저장() {
        int cnt = userDao.insertUser(user);
        assertThat(cnt, is(1));
    }

    @Test
    public void 사용자_조회() {
        User selectedUser = userDao.selectUser(user.getLogin_id());
        assertNotNull(selectedUser);
        assertEquals(selectedUser.getLogin_id(), user.getLogin_id());
        assertEquals(selectedUser.getName(), user.getName());
        assertEquals(selectedUser.getAge(), user.getAge());
    }

    @Test
    public void 사용자_리스트_조회() {
        List<User> list = userDao.selectList();
        assertNotNull(list);
    }

    @Test
    public void 사용자_정보_수정() {
        User selectedUser = userDao.selectUser(user.getLogin_id());
        final String login_id = "newid";
        final String name = "이름변경";
        final int age = 29;
        User newUser = new User(selectedUser.getUser_id(), login_id, name, age);

        int cnt = userDao.updateUser(newUser);

        assertEquals(cnt, 1);
    }

    @Test
    public void 사용자_삭제() {
        User user = userDao.selectUser("newid");

        userDao.deleteUser(user.getUser_id());
    }

}