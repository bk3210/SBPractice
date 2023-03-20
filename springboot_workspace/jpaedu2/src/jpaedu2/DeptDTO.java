package jpaedu2;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// DB에서는 내가 원하는 필드와의 join, FK의 primary or unique 제약조건 걸기가 자유로움
// JPA에서는 PK로만 FK 조건 선택이 가능(JOIN시 참조하고자 하는 키가 반드시 PK여야 함)
@Entity
@Table(name="dept")
public class DeptDTO {
	@Id
	int deptno;		// primary key로 만들고 EmpDTO에서 참조한다
	String dname;
	String loc_code;
	
	// 기본생성자
	public DeptDTO() {
	}
	
	//EmpDTO 객체 insert시 사용할 생성자
	public DeptDTO(int deptno) {
		this.deptno = deptno;
		this.dname ="";
		this.loc_code="";
	}
	
	// DeptDTO객체 insert시 사용
	public DeptDTO(int deptno, String dname, String loc_code) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.loc_code = loc_code;
	}




	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc_code() {
		return loc_code;
	}
	public void setLoc_code(String loc_code) {
		this.loc_code = loc_code;
	}
	
}
