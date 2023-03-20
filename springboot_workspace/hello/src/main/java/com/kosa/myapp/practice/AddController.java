package com.kosa.myapp.practice;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddController {
	
	@GetMapping("/add/{x}/{y}")
	public HashMap<String, Integer> getView(@PathVariable("x")int x, @PathVariable("y")int y) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("x", x);
		map.put("y", y);
		map.put("result", x+y);
		return map;
	}
	
	@GetMapping("/calc/{x}/{y}/{oper}")
	public HashMap<String, Integer> calculator(@PathVariable("x")int x, @PathVariable("y")int y, @PathVariable("oper")int oper){
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("x", x);
		map.put("y", y);
		
		if(oper==1) {
			map.put("result", x+y);
		}else if(oper==2) {
			map.put("result", x-y);
		}else if(oper==3) {
			map.put("result", x*y);
		}else if(oper==4) {
			map.put("result", x/y);
		}
			return map;		
	}
	
	@GetMapping("/score/{name}/{kor}/{eng}/{mat}")
	public HashMap<String, Object> score(@PathVariable("name")String name, @PathVariable("kor")int kor, @PathVariable("eng")int eng, @PathVariable("mat")int mat){
		HashMap<String, Object> map = new HashMap<String, Object>();
		int total=kor+eng+mat;
		map.put("name", name);
		map.put("kor", String.valueOf(kor));
		map.put("eng", String.valueOf(eng));
		map.put("mat", String.valueOf(mat));
		map.put("total", String.valueOf(total));
		return map;
	}
	
	@PostMapping("/score_json")
	public HashMap<String, Object> score_json(@RequestBody ScoreDTO dto){
		HashMap<String, Object> map = new HashMap<String, Object>();
		int total = dto.getKor()+dto.getEng()+dto.getMat();
		dto.setTotal(total);
		dto.setAvg(total/3);
		
		map.put("name", dto.getName());
		map.put("kor", dto.getKor());
		map.put("mat", dto.getMat());
		map.put("eng", dto.getEng());
		map.put("total", dto.getTotal());
		map.put("avg", dto.getAvg());
		
		return map;
	}
	
	@PostMapping("/score_json2")
	public ScoreDTO score_json2(@RequestBody ScoreDTO dto){
		int total = dto.getKor()+dto.getEng()+dto.getMat();
		dto.setTotal(total);
		dto.setAvg(total/3);
	
		return dto;
	}

}
