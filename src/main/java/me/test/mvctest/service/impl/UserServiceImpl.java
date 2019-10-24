package me.test.mvctest.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.test.mvctest.dao.UserDAO;
import me.test.mvctest.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public List<Map<String, Object>> selectList(Map<String,Object> param) {
		return userDAO.selectList(param);
	}
}
