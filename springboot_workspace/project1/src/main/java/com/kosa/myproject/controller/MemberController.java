package com.kosa.myproject.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kosa.myproject.domain.MemberDTO;
import com.kosa.myproject.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	@Autowired
	MemberService service;
	
	@GetMapping("/member/write")
	public String member_wrtie() {
		return "/member/member_write";
	}
	
	@ResponseBody
	@PostMapping("/member/save")
	public HashMap<String, String> member_save(MemberDTO dto){
		HashMap<String, String> map = new HashMap<String, String>();
		try {
			map.put("result", "success");
			map.put("msg", "회원가입에 성공했습니다.");
			service.insert(dto);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", "fail");
			map.put("msg", "회원가입 실패");
		}
		return map;
		
	}
	
	@ResponseBody
	@PostMapping("/member/isuse")
	public HashMap<String, String> isUse(MemberDTO dto){
		HashMap<String, String> map = new HashMap<String, String>();
		if(service.isUse(dto)) {
			map.put("result", "Y");
			map.put("msg", "사용 가능한 아이디입니다.");
		}else {
			map.put("result", "N");
			map.put("msg", "이미 사용중인 아이디입니다.");
		}
		return map;
	}

	@PostMapping("/member/update")
	public HashMap<String, String> update(MemberDTO dto){
		HashMap<String, String> map = new HashMap<String, String>();
		try {
			service.update(dto);
			map.put("result", "success");
			map.put("msg", "회원 정보가 수정되었습니다.");
		} catch (Exception e) {
			map.put("result", "fail");
			map.put("msg", "회원 정보 수정에 실패했습니다.");
		}
		return map;
	}

	
	@PostMapping("/member/delete")
	public HashMap<String, String> delete(MemberDTO dto){
		HashMap<String, String> map = new HashMap<String, String>();
		try {
			service.delete(dto);
			map.put("result", "success");
			map.put("msg", "회원 탈퇴되었습니다.");
		} catch (Exception e) {
			map.put("result", "fail");
			map.put("msg", "회원탈퇴에 실패했습니다.");
		}
		return map;
	}
	
	@GetMapping("/member/login")
	public String member_login() {
		return "/member_login";
	}
	
	@ResponseBody
	@PostMapping("/member/go_login")
	public HashMap<String,String> member_login(MemberDTO dto, HttpServletRequest request){
		HashMap<String, String> map = new HashMap<String, String>();
		HttpSession session = request.getSession();
		MemberDTO resultDTO = service.Member_login(dto);
		if(resultDTO==null) {
			map.put("result","fail");
			map.put("msg","아이디를 다시 확인해 주세요.");
			return map;
		}
		
		if(!resultDTO.getPassword().equals(dto.getPassword())) {
			map.put("result", "fail");
			map.put("msg", "비밀번호를 다시 확인해 주세요.");
			return map;
		}
		
		session.setAttribute("user_id", resultDTO.getUser_id());
		session.setAttribute("password", resultDTO.getPassword());
		
		map.put("result", "success");
		map.put("msg", "로그인되었습니다.");
		return map;
	}
	
	@GetMapping("/member/go_logout")
	public String member_logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();	// 세션 객체 삭제
		return "redirect:/";
	}
	

}