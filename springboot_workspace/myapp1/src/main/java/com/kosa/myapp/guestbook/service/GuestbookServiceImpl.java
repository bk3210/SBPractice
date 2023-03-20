package com.kosa.myapp.guestbook.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kosa.myapp.guestbook.domain.GuestbookDTO;
import com.kosa.myapp.guestbook.repository.GuestbookDAO;

import jakarta.annotation.Resource;

@Service("guestbookService")
public class GuestbookServiceImpl implements GuestbookService{

	@Resource(name="guestbookDAO")
	GuestbookDAO dao;
	
	@Override
	public List<GuestbookDTO> getList(GuestbookDTO dto) {
		return dao.getList(dto);
	}
	
	@Override
	public int getTotalCnt(GuestbookDTO dto) {
		return dao.getTotalCnt(dto);
	}
	
	@Override
	public void insert(GuestbookDTO dto) {
		dao.insert(dto);
	}

	@Override
	public void update(GuestbookDTO dto) {
		dao.update(dto);
		
	}

	@Override
	public void delete(GuestbookDTO dto) {
		dao.delete(dto);
	}

	@Override
	public GuestbookDTO getView(GuestbookDTO dto) {
		return dao.getView(dto);
	}
	
	
}
