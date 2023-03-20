package com.kosa.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.myapp.domain.SampleDTO;
import com.kosa.myapp.repository.SampleRepository;

@Service
public class SampleService {
	@Autowired
	private SampleRepository dao;
	
	public List<SampleDTO> getList(SampleDTO dto){
		List<SampleDTO> list = dao.findAll();
		return list;
	}
	
	public void insert(SampleDTO dto) {
		dao.save(dto);	// sequence값이 필드에 존재하면 insert, 없으면 update를 수행한다
	}
	
	public void update(SampleDTO dto) {
		dao.save(dto);	// sequence값이 필드에 존재하면 insert, 없으면 update를 수행한다
	}
	
	public void delete(SampleDTO dto) {
		dao.delete(dto);
	}
	
	public List<SampleDTO> findTest(SampleDTO dto){
		// return dao.findByTestOrderBySeqDesc(dto.getTest());
		return dao.searchByTest(dto.getTest());
	}

}
