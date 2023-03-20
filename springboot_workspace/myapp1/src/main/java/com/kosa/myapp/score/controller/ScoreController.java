package com.kosa.myapp.score.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosa.myapp.score.domain.ScoreDTO;
import com.kosa.myapp.score.service.ScoreService;

import jakarta.annotation.Resource;

@RestController
public class ScoreController {

	@Resource(name="scoreService")
	ScoreService service;
	
	@RequestMapping("/score/list")
	public HashMap<String, Object> score_getList(ScoreDTO dto){
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		int total = dto.getKor() + dto.getEng() + dto.getMat();
		dto.setTotal(total);
		dto.setAvg(total/3);
		
		resultMap.put("result", "success");
		resultMap.put("list", service.getList(dto));
		
		return resultMap;
	}
	
	@PostMapping("/score/write")
	public HashMap<String, Object> score_write(ScoreDTO dto){
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		
		return resultMap;
	}
	
	
	

}
