package jpaeduexam.test;

import java.util.Scanner;

import jpaeduexam.dao.EmpDAO;

public class EmpTest {
	public static void main(String[] args) {
		EmpDAO dao = new EmpDAO();
		Scanner scanner = new Scanner(System.in);
		// dao.printAll();
		
		// 검색시 대소문자 구분
		// 입력시 S%
		// System.out.println("찾을 이름 : ");
		// String name = scanner.next();
		// dao.searchName(name);
		
		// F, A 검색
		//System.out.println("찾을 이름 : ");
		//String name = scanner.next();
		//System.out.println("직업 : ");
		//String job = scanner.next();
		//dao.searchNameAndJob2(name, job);
		
		// dao.groupFunctionTest();
		
		// dao.updateSal2(7782, 66666);
		dao.deleteEmpno(7902);
		dao.close();
	}

}
