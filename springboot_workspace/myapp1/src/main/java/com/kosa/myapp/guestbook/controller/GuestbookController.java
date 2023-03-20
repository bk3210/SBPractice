package com.kosa.myapp.guestbook.controller;


import java.util.HashMap;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kosa.myapp.guestbook.domain.GuestbookDTO;
import com.kosa.myapp.guestbook.service.GuestbookService;

import jakarta.annotation.Resource;

@RestController
public class GuestbookController {
	@Resource(name="guestbookService")
	GuestbookService service;	
	
	// guestbook/list/1
	// @PathVariable은 pg를 받기 위한 어노테이션
	@GetMapping("/guestbook/list/{pg}")
	public HashMap<String, Object> guestbook_getList(@PathVariable("pg")int pg, GuestbookDTO dto){	
		HashMap<String, Object> resultMap=new HashMap<String, Object>();
		
		resultMap.put("totalCnt", service.getTotalCnt(dto));
		resultMap.put("data", service.getList(dto));
		
		dto.setPg(pg);
		return resultMap;
	}
	
	/*
	 * {"title":"새로운 글", "writer":"test3", "contents":"내요옹"}
	 *
	 */
	// POST방식 전송은 브라우저에서 모니터링할 수 없다
	// JSON 방식으로 데이터를 수신하고 싶다면 매개변수 앞에 requestBody를 붙여야 한다
	@PostMapping("/guestbook/insert")
	public HashMap<String, Object> guestbook_insert(@RequestBody GuestbookDTO dto){
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		// 결과 출력
		map.put("data", dto);
		try {
			map.put("result", "success");
			service.insert(dto);
		} catch (Exception e) {			
			map.put("result", "fail");
		}
		return map;
	}
	
	// get : /board/view/2		또는 /board/view?seq=2	간단, 보안이 필요없는 데이터
	// JSON 형식으로 전송
	/*
	 * @GetMapping("/guestbook/view/{seq}") 
	 * public GuestbookDTO getView(@PathVariable("seq")String seq) {
	 * 		GuestbookDTO dto = new GuestbookDTO();
	 * 		dto.setSeq(seq);
	 * 		service.getTotalCnt(dto);
	 * 		return service.getView(dto); 
	 * }
	 */
	
	@GetMapping("/guestbook/view/{seq}")
	public HashMap<String, Object> getView(@PathVariable("seq")String seq, GuestbookDTO dto){
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		dto.setSeq(seq);
		try {
			resultMap.put("result", "success");
			resultMap.put("msg", "성공");
			resultMap.put("data", service.getView(dto));
			
		} catch (Exception e) {			
			resultMap.put("result", "fail");
			resultMap.put("msg", "실패");
		}
		
		return resultMap;
	}
	
	
	@PostMapping("/guestbook/update")
	public HashMap<String, Object> guestbook_update(@RequestBody GuestbookDTO dto){
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("data", dto); 
		service.update(dto);
		
		return resultMap;
	 
	  }
	 
	
}
