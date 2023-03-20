package com.kosa.myapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kosa.myapp.domain.MemberDTO;

// Long : PK 데이터 타입
public interface MemberRepository extends JpaRepository<MemberDTO, Long> {
	
	@Query("select s from MemberDTO s where s.user_id=:user_id")
	MemberDTO searchByUser_id(@Param("user_id")String user_id);
}
