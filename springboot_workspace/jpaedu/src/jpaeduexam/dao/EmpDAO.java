package jpaeduexam.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import jpaeduexam.dto.EmpDTO;

public class EmpDAO {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("emptest");
	EntityManager em = factory.createEntityManager();

	// 작업을 마치고 나면 객체.close 메소드를 호출해서 없애야 함
	public void close() {
		em.close();
		factory.close();
	}

	public void printAll() {
		TypedQuery<EmpDTO> query = em.createQuery("select a from EmpDTO a", EmpDTO.class);
		List<EmpDTO> list = query.getResultList();

		/*
		 * for(int i=0; i<list.size(); i++){ System.out.println(list.get(i).getEname());
		 * };
		 */

		// 위 for문을 람다식으로 변환
		// list => stream 객체로 전환
		// forEach는 매개변수로 메소드(toString)를 전달해야 한다
		list.stream().forEach(e -> System.out.println(e));
	}

	// 이름으로 검색
	public void searchName(String name) {
		String sql = "select t from EmpDTO t where t.ename like :ename";
		TypedQuery q = em.createQuery(sql, EmpDTO.class);

		// 부분검색
		q.setParameter("ename", "%" + name + "%");

		List<EmpDTO> list = q.getResultList();
		list.stream().forEach(item -> {
			System.out.println(item);
		});

	}

	public void searchNameAndJob(String name, String job) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("select t from EmpDTO t ");
		buffer.append("where t.ename like :ename ");
		buffer.append("and t.job like :job");
		TypedQuery q = em.createQuery(buffer.toString(), EmpDTO.class);
		q.setParameter("ename", "%" + name + "%");
		q.setParameter("job", "%" + job + "%");

		List<EmpDTO> list = q.getResultList();
		list.stream().forEach(item -> {
			System.out.println(item);
		});

	}

	// 파라미터를 전달하는 2번째 방법
	public void searchNameAndJob2(String name, String job) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("select t from EmpDTO t ");
		buffer.append("where t.ename like ?1 ");
		buffer.append("and t.job like ?2");

		// ?1 : 첫번째 파라미터
		// ?2 : 두번째 파라미터
		TypedQuery q = em.createQuery(buffer.toString(), EmpDTO.class);
		q.setParameter(1, "%" + name + "%");
		q.setParameter(2, "%" + job + "%");

		List<EmpDTO> list = q.getResultList();
		list.stream().forEach(item -> {
			System.out.println(item);
		});

	}

	// 그룹함수 호출
	public void groupFunctionTest() {
		Query query = em.createQuery("select sum(t.sal) from EmpDTO t");
		Object result = (Object) query.getSingleResult();
		System.out.println(result);
	}

	// 데이터 업데이트
	public void updateSal(Integer empno, Integer sal) {
		try {
			em.getTransaction().begin();
			EmpDTO dto = em.find(EmpDTO.class, empno);
			dto.setSal(sal);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateSal2(Integer empno, Integer sal) {
		TypedQuery q = em.createQuery("select t from EmpDTO t where t.empno=:empno", EmpDTO.class);
		q.setParameter("empno", empno);

		try {
			em.getTransaction().begin();
			EmpDTO dto = (EmpDTO) q.getSingleResult();	// 속성 하나만 가져옴
			dto.setSal(sal);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteEmpno(Integer empno) {
		try {
			em.getTransaction().begin();
			EmpDTO dto = em.find(EmpDTO.class, empno);
			em.remove(dto);	// 삭제 작업 수행
			// 여러개의 객체를 동시에 삭제하려면 for문을 사용해야 한다
			em.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
