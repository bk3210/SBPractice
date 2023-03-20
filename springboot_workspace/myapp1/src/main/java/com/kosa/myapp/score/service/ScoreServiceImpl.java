package com.kosa.myapp.score.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kosa.myapp.score.domain.ScoreDAO;
import com.kosa.myapp.score.domain.ScoreDTO;

import jakarta.annotation.Resource;

@Service("scoreService")
public class ScoreServiceImpl implements ScoreService{
	@Resource(name="scoreDAO")
	ScoreDAO dao;

	@Override
	public List<ScoreDTO> getList(ScoreDTO dto) {
		return dao.getList(dto);
	}

	@Override
	public int getTotalCnt(ScoreDTO dto) {
		return dao.getTotalCnt(dto);
	}

	@Override
	public ScoreDTO getView(ScoreDTO dto) {
		return dao.getView(dto);
	}

	@Override
	public void insert(ScoreDTO dto) {
		dao.insert(dto);
	}

	@Override
	public void update(ScoreDTO dto) {
		dao.update(dto);
	}

	@Override
	public void delete(ScoreDTO dto) {
		dao.delete(dto);
	}
	
	

}
