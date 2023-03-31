package main;

import java.util.List;
import java.util.Scanner;

import DAO.StudentDAO;
import DTO.StudentDTO;

public class Student {
	public static void main(String[] args) {

		
//		로그인 회원가입
//		Member 테이블 생성
//		id 문자열 20byte
//		pw 문자열 20byte
//		name 문자열 20
//		contact 문자열 20
//		reg date 
//		
//		
//		
		
		
		StudentDAO dao = new StudentDAO();
		Scanner sc = new Scanner(System.in);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (Exception e) {
			System.out.println("연결실패");
			System.exit(0);
		}

		try {
			while (true) {
				System.out.println(" = 학생관리 프로그램 = ");
				System.out.println("1. 학생정보 입력");
				System.out.println("2. 학생목록 확인");
				System.out.println("3. 학생정보 수정 (학번검색)");
				System.out.println("4. 학생정보 삭제 (학번검색)");
				System.out.println("5. 학생정보 검색 (이름검색)");
				System.out.println("0.시스템 종료");
				System.out.print("입력 :  ");

				int menu = Integer.parseInt(sc.nextLine());

				if (menu == 1) {
					System.out.print("신규 학생 이름 : ");
					String name = sc.nextLine();
					
					System.out.print("신규 학생 국어 점수 : ");
					int kor = Integer.parseInt(sc.nextLine());
					
					System.out.print("신규 학생 영어 점수 : ");
					int eng = Integer.parseInt(sc.nextLine());
					
					System.out.print("신규 학생 수학 점수 : ");
					int math = Integer.parseInt(sc.nextLine());
					
					int result = dao.addStudent(name, kor, eng, math);
					if (result > 0) {
						System.out.println("입력 완료");
					}
					
				} else if (menu == 2) {
					List<StudentDTO> result = dao.searchAll();
					
					System.out.println("학번\t이름\t국어\t영어\t수학");
					for (StudentDTO dto : result) {
						System.out.println(dto.getId()+"\t"+ dto.getName()+"\t"+
								dto.getKor()+"\t"+dto.getEng()+"\t"+dto.getMath());
					}
					
				} else if (menu == 3) {
					System.out.print("수정하고자 하는 학생의 학번 입력 : ");
					int id = Integer.parseInt(sc.nextLine());
					
					boolean result = dao.isIdExist(id);
					if(result == false) {
						System.out.println("수정할 ["+id+"] 확인불가");
						continue;
					}
					
					System.out.print("수정하고자 하는 학생의 이름 입력 : ");
					String upName =  sc.nextLine();
						
					System.out.print("대상 학생의 국어점수 입력 : ");
					int upKor = Integer.parseInt(sc.nextLine());
					
					System.out.print("대상 학생의 영어점수 입력 : ");
					int upEng = Integer.parseInt(sc.nextLine());
					
					
					System.out.print("대상 학생의 수학점수 입력 : ");
					int upMath = Integer.parseInt(sc.nextLine());
					
					StudentDTO dto = new StudentDTO(id,upName,upKor,upEng,upMath);
					int upResult= dao.updateStudent(dto);
					
					if (upResult > 0) {
						System.out.println("변경 완료");
						
					}
					
					
				} else if (menu == 4) {
					System.out.print("삭제할 학생 학번 입력 : ");
					int id = Integer.parseInt(sc.nextLine());
					
					int result = dao.deleteStudent(id);
					
					if (result > 0) {
						System.out.println("삭제 성공");
					}
					
				} else if (menu == 5) {
					System.out.print("검색할 학생 이름 : ");
					String search = sc.nextLine();
					List<StudentDTO> result = dao.searchName(search);
					
					System.out.println("학번\t이름\t국어\t영어\t수학");
					for (StudentDTO dto : result) {
						System.out.println(dto.getId()+"\t"+ dto.getName()+"\t"+
								dto.getKor()+"\t"+dto.getEng()+"\t"+dto.getMath());
					}
					
					
				} else if (menu == 0) {
					System.out.println("시스템을 종료합니다.");
					System.exit(0);
				} else {
					System.out.println("메뉴를 다시 선택해 주세요.");
				}

			}

		} catch (Exception e) {
			System.out.println("실행중 오류 발생");
			e.printStackTrace();
		}

	}
}
