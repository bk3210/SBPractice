package com.kosa.myapp.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kosa.myapp.board.domain.BoardDAO;
import com.kosa.myapp.board.domain.BoardDTO;

import jakarta.annotation.Resource;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Resource(name="boardDAO")
	BoardDAO dao;
	
	@Override
	public List<BoardDTO> getList(BoardDTO dto) {
		return dao.getList(dto);
	}

	@Override
	public int getTotalCnt(BoardDTO dto) {
		return dao.getTotalCnt(dto);
	}

	@Override
	public BoardDTO getView(BoardDTO dto) {
		return dao.getView(dto);
	}

	@Override
	public void insert(BoardDTO dto) {
		dao.insert(dto);
	}

	@Override
	public void update(BoardDTO dto) {
		dao.update(dto);
	}

	@Override
	public void delete(BoardDTO dto) {
		dao.delete(dto);
	}

}
