package com.kosa.myapp.score.service;

import java.util.List;

import com.kosa.myapp.score.domain.ScoreDTO;

public interface ScoreService {
	List<ScoreDTO> getList(ScoreDTO dto);
	int getTotalCnt(ScoreDTO dto);
	ScoreDTO getView(ScoreDTO dto);
	void insert(ScoreDTO dto);
	void update(ScoreDTO dto);
	void delete(ScoreDTO dto);
}
