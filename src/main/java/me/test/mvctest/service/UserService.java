package me.test.mvctest.service;

import java.util.List;
import java.util.Map;

public interface UserService {

	List<Map<String, Object>> selectList(Map<String,Object> param);

}
