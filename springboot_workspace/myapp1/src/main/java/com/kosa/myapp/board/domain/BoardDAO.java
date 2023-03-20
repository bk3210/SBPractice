package com.kosa.myapp.board.domain;

import java.util.List;

public interface BoardDAO {
	List<BoardDTO> getList(BoardDTO dto);
	int getTotalCnt(BoardDTO dto);
	BoardDTO getView(BoardDTO dto);
	void insert(BoardDTO dto);
	void update(BoardDTO dto);
	void delete(BoardDTO dto);

}
