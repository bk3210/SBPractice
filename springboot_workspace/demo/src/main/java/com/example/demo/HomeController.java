package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @Controller : Spring과 동일한 역할
// @RestController : JSON 형식으로 데이터를 주고받음, 결과값도 JSON 형태로 내보낸다
@RestController
public class HomeController {
	@RequestMapping(value="/")
	public String home() {
		return "Hello";
	}
	
	// SpringBoot에서는 ResponseBody를 따로 붙이지 않음
	@RequestMapping(value="/data")
	public HashMap<String, String> data(){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("name", "홍길동");
		map.put("age", "23");
		map.put("phone", "010-1111-2222");
		map.put("email", "hong@naver.com");
		
		return map;
		}
	
	@RequestMapping(value="/dataList")
	public List<HashMap<String, String>> data_list(){
		List<HashMap<String, String>> dataList = new ArrayList<HashMap<String, String>>();
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("name", "홍길동");
		map.put("age", "23");
		map.put("phone", "010-1111-2222");
		map.put("email", "hong@naver.com");
		dataList.add(map);
		
		map = new HashMap<String, String>();
		map.put("name", "김길동");
		map.put("age", "25");
		map.put("phone", "010-2222-3333");
		map.put("email", "kim@naver.com");
		dataList.add(map);
		
		map = new HashMap<String, String>();
		map.put("name", "이길동");
		map.put("age", "21");
		map.put("phone", "010-3333-4444");
		map.put("email", "lee@naver.com");
		dataList.add(map);
		
		return dataList;
	}
	
	// http://localhost:9000?userid=test&password=1234
	@GetMapping("/info")
	public HashMap<String, String> info(String userid, String password){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("userid", userid);
		map.put("password", password);
		return map;
	}
}
