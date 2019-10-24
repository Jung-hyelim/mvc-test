package me.test.mvctest.controller;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import me.test.mvctest.service.UserService;

@Controller
@RequestMapping(value = "/api/user")
public class UserController {

	Logger log = Logger.getLogger(this.getClass().toString());
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("")
	public Object getList(Map<String,Object> param) {
		List<Map<String, Object>> list = userService.selectList(param);
		return list;
	}
}
