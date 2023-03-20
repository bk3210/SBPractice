package com.kosa.myapp.guestbook.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosa.myapp.guestbook.domain.GuestbookDTO;

// 스프링이 부트로 바뀐 것일 뿐, MyBatis 소스 구조는 똑같다
@Repository("guestbookDAO")
public class GuestbookDAOImpl implements GuestbookDAO {
	@Autowired
	SqlSessionTemplate sm;

	@Override
	public int getTotalCnt(GuestbookDTO dto) {
		return sm.selectOne("Guestbook_getTotalCnt", dto);
	}

	@Override
	public List<GuestbookDTO> getList(GuestbookDTO dto) {
		return sm.selectList("Guestbook_getList", dto);
	}

	@Override
	public void insert(GuestbookDTO dto) {
		sm.insert("Guestbook_insert", dto);
	}

	@Override
	public void update(GuestbookDTO dto) {
		sm.update("Guestbook_update", dto);
	}

	@Override
	public void delete(GuestbookDTO dto) {
		sm.update("Guestbook_delete", dto);

	}

	@Override
	public GuestbookDTO getView(GuestbookDTO dto) {
		return sm.selectOne("Guestbook_getView", dto);
	}

}
