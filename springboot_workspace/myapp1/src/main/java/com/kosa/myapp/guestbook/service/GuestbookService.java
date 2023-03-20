package com.kosa.myapp.guestbook.service;

import java.util.List;

import com.kosa.myapp.guestbook.domain.GuestbookDTO;

public interface GuestbookService {
	public List<GuestbookDTO> getList(GuestbookDTO dto);
	void insert(GuestbookDTO dto);
	void update(GuestbookDTO dto);
	void delete(GuestbookDTO dto);
	GuestbookDTO getView(GuestbookDTO dto);
	int getTotalCnt(GuestbookDTO dto);

}
