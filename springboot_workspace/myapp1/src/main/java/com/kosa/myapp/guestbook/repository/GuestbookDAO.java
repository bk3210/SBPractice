package com.kosa.myapp.guestbook.repository;

import java.util.List;

import com.kosa.myapp.guestbook.domain.GuestbookDTO;

// repository, service 경로를 폴더로 나눠주는 게 바람직하다
public interface GuestbookDAO {
	List<GuestbookDTO> getList(GuestbookDTO dto);
	int getTotalCnt(GuestbookDTO dto);
	void insert(GuestbookDTO dto);
	void update(GuestbookDTO dto);
	void delete(GuestbookDTO dto);
	GuestbookDTO getView(GuestbookDTO dto);
}
