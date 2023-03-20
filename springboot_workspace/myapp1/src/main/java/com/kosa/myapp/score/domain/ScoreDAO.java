package com.kosa.myapp.score.domain;

import java.util.List;

public interface ScoreDAO {
	List<ScoreDTO> getList(ScoreDTO dto);
	int getTotalCnt(ScoreDTO dto);
	ScoreDTO getView(ScoreDTO dto);
	void insert(ScoreDTO dto);
	void update(ScoreDTO dto);
	void delete(ScoreDTO dto);
	

}
