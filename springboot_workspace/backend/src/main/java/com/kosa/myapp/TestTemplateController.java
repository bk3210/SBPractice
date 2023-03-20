package com.kosa.myapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

// 스프링부트에서 jsp 사용하지 말고 mustache를 쓰는 것을 권장하고 있음
// 템플릿, 템플릿 엔진
// html 파일을 src/main/resources/template 하위폴더에 저장함
@Controller
public class TestTemplateController {
	@GetMapping("/template1")
	public String template1(Model model, HttpServletRequest req) {
		model.addAttribute("msg", "스프링부트 템플릿 엔진");
		model.addAttribute("name", "hong");
		model.addAttribute("age", 33);

		
		List<String> sList = new ArrayList<String>();
		sList.add("제목1");
		sList.add("제목2");
		sList.add("제목3");
		sList.add("제목4");
		sList.add("제목5");
		sList.add("제목6");
		sList.add("제목7");
		model.addAttribute("sList", sList);
		
		List<BoardDTO> boardList = new ArrayList<BoardDTO>();
		boardList.add(new BoardDTO("1", "제목1", "내용1", "작성자1", "1", "1"));
		boardList.add(new BoardDTO("2", "제목2", "내용2", "작성자2", "2", "2"));
		boardList.add(new BoardDTO("3", "제목3", "내용3", "작성자3", "3", "3"));
		boardList.add(new BoardDTO("4", "제목4", "내용4", "작성자4", "4", "4"));
		boardList.add(new BoardDTO("5", "제목5", "내용5", "작성자5", "5", "5"));
		model.addAttribute("boardList", boardList);
		
		// Session으로 값 넘기기 : 요청을 받기 위한 HttpServletRequest 파라미터가 필요하다
		HttpSession session = req.getSession();
		session.setAttribute("userid", "test11");
		session.setAttribute("username", "홍");
		
		return "template1";	// template.html로 찾아간다
	}
	
	@GetMapping("/board/list")
	public String board_list(Model model, HttpServletRequest req) {
		return "board_list";
	}
	
}