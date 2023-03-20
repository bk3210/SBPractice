package com.kosa.myapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// localhost 도메인 / 클라이언트 주소에 따라서 다르게 동작
// * : 모든 접속 요청을 다 받겠다는 뜻(실제 운영시에는 도메인 명으로만 - A 사이트에 접속하려는 사람을 B 사이트로 보내면 안되니까)
@CrossOrigin(origins="*")	// 접근 허가를 받는 사이트의 도메인이 값으로 저장되어야 한다
@RestController
public class BoardController {
	@RequestMapping("/board/list/{pg}")
	public HashMap<String, Object> getList(BoardDTO dto, @PathVariable("pg")String pg){
		HashMap<String, Object> map = new HashMap<String, Object>();
		List<BoardDTO> list=new ArrayList<BoardDTO>();
		for(int i=0; i<20; i++) {
			list.add(new BoardDTO(""+i, "제목"+i, "작성자"+i, "내용"+i, "파일"+i, "작성일"+i));
			map.put("totalCnt", 20);
			map.put("list", list);
		}
		return map;
	}
}
