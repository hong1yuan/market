package com.market.controller;

import com.alibaba.fastjson.JSON;
import com.market.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "/testConfig")
public class TestConfigController {

	
	@Autowired
	TestService testService;

	
	//查询语句
	//http://127.0.0.1:21000/testConfig/query?id=1
	@RequestMapping(value = "/query")
	public String query(@RequestParam("id") String id)throws Exception{
		List<Map<String, Object>> query = testService.query(id);
		String jsonString = JSON.toJSONString(query);
		return jsonString;
	}

	//添加语句
	//http://127.0.0.1:21000/testConfig/add
	@RequestMapping(value = "/add")
	public void add()throws Exception{
		Map<String,Object> param =  new HashMap<String, Object>();
		param.put("name","李四");
		param.put("age","27");

		testService.add(param);
	}


}
