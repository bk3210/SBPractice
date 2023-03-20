package com.kosa.myapp;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class TestController {
	

	@GetMapping("/add/{x}/{y}")// @PathVariable의 value값과 url 뒤에 오는 변수명이 서로 일치해야 함(파라미터 변수명은 상관없다)
	public HashMap<String, String> add(@PathVariable("x")int x, @PathVariable("y")int y){
		int result=x+y;
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("x", String.valueOf(x));
		map.put("y", String.valueOf(y));
		map.put("result", String.valueOf(result));
		return map;
	}

	// add?x=5&y=8	==> add/5/8
	// Get방식으로 정보를 처리하는 방식
	// (POST 방식으로 정보를 보낼 때에는 add 뒤의 /x/y 등의 값이 무시당할 수 있음(브라우저에 따라 다르게 동작)

	
	// postman body - x-www-form-urlencoded
	@PostMapping("/add_form")// @PathVariable의 value값과 url 뒤에 오는 변수명이 서로 일치해야 함(파라미터 변수명은 상관없다)
	public HashMap<String, String> add_form(String x, String y){
		HashMap<String, String> map = new HashMap<String, String>();
		int result=Integer.parseInt(x)+Integer.parseInt(y);
		// map.put("req_x", req.getParameter("x"));	// spring 아닌 sevlet에서 작업할 때
		// map.put("req_y", req.getParameter("y"));
		
		// String.valueOf(기본타입 변수) => 문자열로 전환해줌
		// x(int) -> int는 객체가 아님. toString() 메소드를 사용할 수 없음
		// java int -> 객체로 전환해야 할 때가 있는데 Integer, Float, Double 클래스
		// wrapper class들로 기본값을 감싸서 객체로 전환할 때에는 toString() 사용
		// C#은 int와 Integer간에 기본타입과 객체타입간 전환을 자유로이 할 수 있음
		// s = new Integer(x); s.toString();
		// int x + "" : String타입으로 전환됨
		map.put("x", String.valueOf(x));
		map.put("y", String.valueOf(y));
		map.put("result", String.valueOf(result));
		return map;
	}
	
	@PostMapping("/add_json")// @PathVariable의 value값과 url 뒤에 오는 변수명이 서로 일치해야 함(파라미터 변수명은 상관없다)
	public HashMap<String, String> add_json(@RequestBody HashMap<String, String> paramMap){
		int result=Integer.parseInt(paramMap.get("x"))+Integer.parseInt(paramMap.get("y"));
		HashMap<String, String> map = new HashMap<String, String>();
		// json으로 받을 때는 @RequestBody로 받아야 함(기본타입 변수로 x)
		// HashMap 또는 DTO로 받아야 함
		
		
		map.put("x", paramMap.get("x"));
		map.put("y", paramMap.get("y"));
		map.put("result", String.valueOf(result));
		return map;
	}
	
}
