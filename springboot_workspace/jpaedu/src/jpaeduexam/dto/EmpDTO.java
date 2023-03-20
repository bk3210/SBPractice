package jpaeduexam.dto;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emp")	// Table명과 클래스명이 다를 경우, 이 어노테이션 속성값으로 name을 지정해줘야 함
public class EmpDTO {
	@Id
	private int empno;	// int는 null값 저장을 할 수 없음
	
	private String ename;
	private String job;
	private Integer mgr;	// Integer는 null값 저장 가능(Object 속성이라서)
	private java.sql.Date hiredate;
	private int sal;
	private Integer comm;
	private Integer deptno;
	
	// 기본 생성자
	public EmpDTO() {
		// TODO Auto-generated constructor stub
	}
	
	// null값이 들어가면 안되는 속성들을 자동 초기화하는 생성자 오버로딩
	public EmpDTO(int empno, String ename, Date hiredate, int sal, Integer deptno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.deptno = deptno;
		this.hiredate = hiredate;
		this.sal = sal;
	
	}	
	
	@Override
	public String toString() {
		return String.format("%d %s %d %d %d %s %d", empno, ename, deptno, sal, comm, hiredate, mgr);
	}

	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Integer getMgr() {
		return mgr;
	}
	public void setMgr(Integer mgr) {
		this.mgr = mgr;
	}
	public java.sql.Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(java.sql.Date hiredate) {
		this.hiredate = hiredate;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public Integer getComm() {
		return comm;
	}
	public void setComm(Integer comm) {
		this.comm = comm;
	}
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	
	
	
}
