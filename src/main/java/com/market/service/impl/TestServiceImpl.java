package com.market.service.impl;

import com.market.mapper.TestMapper;
import com.market.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TestServiceImpl implements TestService {
	@Autowired
	private TestMapper testMapper;

	@Override
	public List<Map<String, Object>> query(String id) throws Exception{
		return testMapper.query(id);
	}

	public void add(Map<String,Object> param)throws Exception{
		 testMapper.add(param);
	}

}
