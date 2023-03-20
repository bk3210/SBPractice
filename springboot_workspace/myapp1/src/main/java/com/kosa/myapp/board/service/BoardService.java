package com.kosa.myapp.board.service;

import java.util.List;

import com.kosa.myapp.board.domain.BoardDTO;

public interface BoardService {
	List<BoardDTO> getList(BoardDTO dto);
	int getTotalCnt(BoardDTO dto);
	BoardDTO getView(BoardDTO dto);
	void insert(BoardDTO dto);
	void update(BoardDTO dto);
	void delete(BoardDTO dto);
}
