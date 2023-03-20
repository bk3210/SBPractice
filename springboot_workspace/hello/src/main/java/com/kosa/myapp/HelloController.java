package com.kosa.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// @Controller 어노테이션은 이전과 동일
// return값을 이용해 요청에 필요한 mustache 파일을 찾음
// src/main/resource/templates 폴더 아래에 html 파일(mustache)을 두어야 함
@Controller
public class HelloController {

	@GetMapping("/")
	public String hello() {
		return "/test";
	}
}
