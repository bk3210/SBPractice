package com.kosa.myapp.controller;

import java.util.HashMap;
import java.util.List;

import javax.print.attribute.PrintJobAttribute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosa.myapp.domain.SampleDTO;
import com.kosa.myapp.service.SampleService;

@RestController
public class SampleController {
	
	@Autowired
	SampleService service;
	
	
	@GetMapping("/sample/list")
	public List<SampleDTO> getList(SampleDTO dto){
		return service.getList(dto);
	}
	
	@GetMapping("/sample/insert")
	public HashMap<String, Object> insert(SampleDTO dto){
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		try {
			service.insert(dto);
			resultMap.put("result", "success");
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("result", "fail");
		}
		return resultMap;
	}
	
	//sample/update?seq=1&test=띠용때용
	@GetMapping("/sample/update")
	public HashMap<String, Object> update(SampleDTO dto){
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		try {
			service.update(dto);
			resultMap.put("result", "Success");
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("result", "fail");
		}
		return resultMap;
	}
	
	//sample/delete?seq=1
	@GetMapping("/sample/delete")
	public HashMap<String, Object> delete(SampleDTO dto){
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		try {
			service.delete(dto);
			resultMap.put("result", "Success");
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("result", "fail");
		}
		return resultMap;
	}
	
	// sample.find?test=tttt
	@GetMapping("/sample/find")
	List<SampleDTO> findByTest(SampleDTO dto){
		return service.findTest(dto);
	}

}
