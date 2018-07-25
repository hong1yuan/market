package com.market.mapper;

import java.util.List;
import java.util.Map;


public interface TestMapper {
	
	List<Map<String, Object>> query(String id) throws Exception;

	void add(Map<String, Object> param) throws Exception;

}
