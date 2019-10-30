package com.test.dao;

import com.test.model.User;

import java.util.List;

public interface UserDao {

    public int insertUser(User user);

    public User selectUser(String login_id);

    public List<User> selectList();

    public int updateUser(User user);

    public void deleteUser(Integer user_id);
}
