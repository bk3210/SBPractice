package jpaeduexam.test;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import jpaeduexam.dto.ScoreDTO;

public class ScoreTest {

	public static void main(String[] args) {
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("emptest");
		//factory - 공장, 객체를 생성해내는 별도의 클래스 
		EntityManager em = factory.createEntityManager();
		System.out.println("JPA실습");
		
		// 데이터 추가
		ScoreDTO dto = new ScoreDTO();
		dto.setName("김길동");
		dto.setKor(80);
		dto.setMat(90);
		dto.setEng(100);
		dto.setWdate(LocalDateTime.now());
		
		/*
		// DB와 연동해서 동작을 수행하는 EntityManager 객체
		em.getTransaction().begin();
		em.persist(dto);
		em.getTransaction().commit();
		*/
		
		// 데이터 가져오기
		// TypedQuery : 테이블이 아닌 DTO Class로부터 데이터를 가져와서 연산함
		TypedQuery<ScoreDTO> q = em.createQuery(
				"select a from ScoreDTO a ", ScoreDTO.class
				);
		// 결과를 list 형식으로 가져와서 넣음
		List<ScoreDTO> list = q.getResultList();
		
		// JavaScript의 화살표 함수(람다)와 유사함
		// Java의 경우 list 객체를 Stream 객체로 전환하는 작업이 필요
		// forEach - 매개변수 하나, 반환값이 없는 람다함수를 전달
		list.stream().forEach(e->{
			System.out.println(String.format("%s %d %d %d", e.getName(), e.getKor(), e.getMat(), e.getEng()));
		});
		
		// 검색
		System.out.println("시퀀스 번호로 검색하기");
		q = em.createQuery(
				"select a from ScoreDTO a where a.seq=:seq", ScoreDTO.class
				);
		
		// 검색 조건을 추가할 경우
		q.setParameter("seq", 1);
		list = q.getResultList();
		list.stream().forEach(e->{
			System.out.println(String.format("%s %d %d %d", e.getName(), e.getKor(), e.getMat(), e.getEng()));
		});
				
		
		em.close();
		factory.close();
	}

}
