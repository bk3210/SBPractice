package com.kosa.myapp.score.domain;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("scoreDAO")
public class ScoreDAOImpl implements ScoreDAO {
	@Autowired
	SqlSessionTemplate sm;

	@Override
	public List<ScoreDTO> getList(ScoreDTO dto) {
		return sm.selectList("Score_getList", dto);
	}

	@Override
	public int getTotalCnt(ScoreDTO dto) {
		return sm.selectOne("Score_getTotalCnt", dto);
	}

	@Override
	public ScoreDTO getView(ScoreDTO dto) {
		return sm.selectOne("Score_getView", dto);
	}

	@Override
	public void insert(ScoreDTO dto) {
		sm.insert("Score_insert", dto);
	}

	@Override
	public void update(ScoreDTO dto) {
		sm.update("Score_update", dto);
	}

	@Override
	public void delete(ScoreDTO dto) {
		sm.delete("Score_delete", dto);
	}
	

}
