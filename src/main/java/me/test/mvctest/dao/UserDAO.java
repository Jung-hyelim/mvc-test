package me.test.mvctest.dao;

import java.util.List;
import java.util.Map;

public interface UserDAO {

	List<Map<String, Object>> selectList(Map<String, Object> param);

}
