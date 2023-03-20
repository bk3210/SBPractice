package com.kosa.myapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kosa.myapp.domain.SampleDTO;

// 상속을 받으면 JpaRepository 내부에 있는 라이브러리가 insert, update, delete 작업을 처리해준다(따로 쿼리/코드 써야할 필요가 없음)
public interface SampleRepository extends JpaRepository<SampleDTO, Long> {
	// select 메소드명 또한 지정되어 있음
	List<SampleDTO> findByTestOrderBySeqDesc(String test);
	
	// select 구문 쿼리를 적용한 메소드 직접 만들기
	@Query("select s from SampleDTO s where s.test like %:test%")
	List<SampleDTO> searchByTest(@Param("test")String test);


}