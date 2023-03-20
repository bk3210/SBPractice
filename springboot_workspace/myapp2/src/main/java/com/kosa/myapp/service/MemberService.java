package com.kosa.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kosa.myapp.domain.MemberDTO;
import com.kosa.myapp.repository.MemberRepository;

@Service
public class MemberService {
	@Autowired
	private MemberRepository dao;
	
	public List<MemberDTO> getList(MemberDTO dto, Pageable pageable){
		// 페이징 정보를 추가
		return dao.findAll(pageable).getContent();
	}
	
	public long getTotalCnt(MemberDTO dto) {
		return dao.count();
	}
	
	public void insert(MemberDTO dto) {
		dao.save(dto);	
	}
	
	public void update(MemberDTO dto) {
		dao.save(dto);
	}
	
	public void delete(MemberDTO dto) {
		dao.delete(dto);
	}
	
	public boolean isUse(MemberDTO dto) {
		MemberDTO resultDTO = dao.searchByUser_id(dto.getUser_id());
		if(resultDTO==null) {
			return true;
		}else {
			return false;
		}
		
	}
	
	
}
