package com.kosa.myapp.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kosa.myapp.domain.MemberDTO;
import com.kosa.myapp.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	MemberService service;
	
	// 등록페이지로 이동하기
	@GetMapping("/member/write")
	public String member_write() {
		
		return "/member/write";
	}
	
	@ResponseBody
	@PostMapping("/member/save")
	public HashMap<String, String> member_save(MemberDTO dto) {
		HashMap<String, String> resultMap = new HashMap<String, String>();
		try {
			resultMap.put("result", "success");
			resultMap.put("msg", "회원가입에 성공하셨습니다");			
			service.insert(dto);
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("result", "fail");
		}
		return resultMap;
	}
	
	@ResponseBody
	@PostMapping("/member/isuse")
	public HashMap<String, String> isUse(MemberDTO dto){
		HashMap<String, String> resultMap = new HashMap<String, String>();
		if(service.isUse(dto)) {
			resultMap.put("result", "Y");
			resultMap.put("msg", "사용 가능한 아이디입니다.");
		}else {
			resultMap.put("result", "N");
			resultMap.put("msg", "이미 사용중인 아이디입니다.");
		}
		return resultMap;
	}

}
