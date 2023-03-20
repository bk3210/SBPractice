package com.kosa.myproject.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.kosa.myproject.domain.MemberDTO;

@Service
public interface MemberRepository extends JpaRepository<MemberDTO, Long>{
	@Query("select m from MemberDTO m where m.user_id=:user_id")
	MemberDTO searchByUser_id(@Param("user_id")String user_id);


}
