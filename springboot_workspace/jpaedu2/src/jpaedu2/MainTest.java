package jpaedu2;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

// join select
public class MainTest {
	public static void main(String[] args) {
		
		// alter table dept add constraint PK_DEPT primary key(deptno);
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("emptest");
		EntityManager em = factory.createEntityManager();
		
		// 데이터 추가
		EmpDTO dto = new EmpDTO();
		dto.setEmpno(800);
		dto.setEname("홍길동");
		// 문자열 형태의 날짜를 Date 타입으로 바꿔서 전달
		dto.setHiredate(Date.valueOf("2023-02-21"));
		dto.setDept(new DeptDTO(10));	// 부서번호 10번
		dto.setJob("Delevoper");
		dto.setSal(8000L);		// Long 타입 상수 : 숫자 뒤에 l/L을 붙인다
		dto.setComm(200);
		/*
		 * em.getTransaction().begin(); em.persist(dto); em.getTransaction().commit();
		 */
		TypedQuery<EmpDTO> q = em.createQuery(
				"select a from EmpDTO a ", EmpDTO.class
				);
		
		List<EmpDTO> list = q.getResultList();
		list.stream().forEach(e->{
			System.out.println(e.ename + " " + e.getDept().deptno + " " + e.getDept().dname);
		});
		
		
		em.close();
		factory.close();
		
	}

}
