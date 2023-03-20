package address;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class AddressDAO {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("addresstest");
	EntityManager em = factory.createEntityManager();
	Scanner scanner = new Scanner(System.in);
	
	// 작업 종료
	public void close() {
		em.close();
		factory.close();
	}
	
	// 정보 등록
	public void insert() {
		AddressDTO dto = new AddressDTO();
		
		System.out.print("이름 : ");
		dto.setName(scanner.next());
		System.out.print("전화번호 : ");
		dto.setPhone(scanner.next());
		System.out.print("이메일 : ");
		dto.setEmail(scanner.next());
		dto.setWdate(LocalDateTime.now());
		
		em.getTransaction().begin();
		em.persist(dto);
		em.getTransaction().commit();
	}
	
	// 전체 출력
	public void printAll() {
		TypedQuery<AddressDTO> q = em.createQuery("select a from AddressDTO a", AddressDTO.class);
		List<AddressDTO> list = q.getResultList();
		list.stream().forEach(e->System.out.println(e));
	}
	
	// 이름 검색
	public void searchName() {
		System.out.print("찾으실 이름을 입력하세요 : ");
		String name=scanner.next();
		String sql = "select a from AddressDTO a where a.name like :name";
		TypedQuery q = em.createQuery(sql, AddressDTO.class);
		q.setParameter("name", "%" + name + "%");

		List<AddressDTO> list = q.getResultList();
		list.stream().forEach(item -> {
			System.out.println(item);
		});
	}
	
	// 전화번호 검색
	public void searchPhone() {
		System.out.print("찾으실 전화번호를 입력하세요 : ");
		String phone = scanner.next();
		String sql = "select a from AddressDTO a where a.phone like :phone";
		TypedQuery q = em.createQuery(sql, AddressDTO.class);
		q.setParameter("phone", "%" + phone + "%");
		
		List<AddressDTO> list = q.getResultList();
		list.stream().forEach(item -> {
			System.out.println(item);
		});	
		
	}
	
	// 이메일 검색
	public void searchEmail() {
		System.out.print("찾으실 이메일을 입력하세요 : ");
		String email = scanner.next();
		String sql = "select a from AddressDTO a where a.email like ?1";
		TypedQuery q = em.createQuery(sql, AddressDTO.class);
		q.setParameter(1, "%" + email + "%");
		
		List<AddressDTO> list = q.getResultList();
		list.stream().forEach(item -> {
			System.out.println(item);
		});
	}
	
	// 정보 수정
	public void update() {
		System.out.print("수정할 번호를 입력하세요 : ");
		int seq = scanner.nextInt();
		TypedQuery q = em.createQuery("select a from AddressDTO a where a.seq = :seq", AddressDTO.class);
		q.setParameter("seq", seq);
		try {
			em.getTransaction().begin();
			AddressDTO dto = (AddressDTO)q.getSingleResult();
			
			System.out.print("변경할 이름을 입력하세요 : ");
			dto.setName(scanner.next());
			System.out.print("변경할 전화번호를 입력하세요 : ");
			dto.setPhone(scanner.next());
			System.out.print("변경할 이메일을 입력하세요 : ");
			dto.setEmail(scanner.next());
			
			em.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 정보 삭제
	public void delete() {
		System.out.print("삭제할 번호를 입력하세요 : ");
		int seq = scanner.nextInt();
		try {
			em.getTransaction().begin();
			AddressDTO dto = em.find(AddressDTO.class, seq);
			em.remove(dto);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// menu
	public void menuDisplay() {
		System.out.println("1. 등록\n2. 검색\n3. 수정\n4. 삭제\n5. 전체출력\n6. 종료");
	}
	
	public void start() {
		int menu=0;
		int searchW=0;
		while(true) {
			menuDisplay();
			System.out.print("선택하세요 : ");
			menu = scanner.nextInt();
			switch(menu) {
			case 1 : insert(); break;
			case 2 :
				System.out.print("검색 조건을 입력하세요 : ");
				searchW=scanner.nextInt();
				if(searchW==1) {
					searchName();
				}else if(searchW==2) {
					searchPhone();
				}else if(searchW==3) {
					searchEmail();
				}; 
				break;
			case 3 : update(); break;
			case 4 : delete(); break;
			case 5 : printAll(); break;
			case 6 : close(); return;
			}
		}
	}
	
}

