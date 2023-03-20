package com.kosa.myapp.board.domain;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("boardDAO")
public class BoardDAORepository implements BoardDAO {
	@Autowired
	SqlSessionTemplate sm;
	
	@Override
	public List<BoardDTO> getList(BoardDTO dto) {
		return sm.selectList("Board_getList", dto);
	}

	@Override
	public int getTotalCnt(BoardDTO dto) {
		return sm.selectOne("Board_getTotalCnt", dto);
	}

	@Override
	public BoardDTO getView(BoardDTO dto) {
		return sm.selectOne("Board_getView", dto);
	}

	@Override
	public void insert(BoardDTO dto) {
		sm.insert("Board_insert", dto);
	}

	@Override
	public void update(BoardDTO dto) {
		sm.update("Board_update", dto);
	}

	@Override
	public void delete(BoardDTO dto) {
		sm.delete("Board_delete", dto);
	}
	

}
