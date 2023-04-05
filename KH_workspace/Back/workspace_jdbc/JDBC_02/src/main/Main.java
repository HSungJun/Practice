package main;

import java.util.List;
import java.util.Scanner;

import DTO.MoviesDTO;
import MoviesDAO.MoviesDAO;

public class Main {
	public static void main(String[] args) {

		// netflix 영화 관리 프로그램
		// 테이블 이름 : movies
		// id 1001 ~ 무한 1씩증가하는 주 키
		// title 문자열 최대 50바이트
		// genre 문자열 20바이트
		// 모두 not null

		// refactoring = 완성된 다음의 코드를 mvc 패턴으로 변경

		MoviesDAO dao = new MoviesDAO();
		Scanner sc = new Scanner(System.in);

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (Exception e) {
			System.out.println("연결실패");
			System.exit(0);
		}

		try {
			System.out.println("<< Index >>");
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.print("0. 종료 >>");
			String menu = sc.nextLine();
			
			if ( menu.equals("1")) {
				
			} else if(menu.equals("2")) {
				
				System.out.println("<< 회원가입 >>");
				
				System.out.print("사용할 ID 입력 : ");
				String id = sc.nextLine();
				
				System.out.print("pW 입력 :");
				String pw = sc.nextLine();
				
				System.out.print("이름 입력 :");
				String name = sc.nextLine();
				
				System.out.print("연락처 입력 :");
				String phone = sc.nextLine();
				
			
				
				
			
			} else if (menu.equals("0")) {
				
			} else {
				
			}
			
			
			
			
			
			
			
			
			
//			while (true) {
//				System.out.println();
//				System.out.println("<<netflix 영화관리 프로그램>>");
//				System.out.println("1. 신규 영화 등록"); // C
//				System.out.println("2. 영화 목록 출력"); // R
//				System.out.println("3. 영화 정보 수정"); // U -- ID를 기준으로 모든 정보 수정
//				System.out.println("4. 영화 정보 삭제"); // D -- ID를 기준으로 삭제
//				System.out.println("5. 영화 정보 검색"); // 제목으로 검색
//				System.out.println("0. 프로그램 종료");
//				System.out.print(">> : ");
//
//				if (menu.equals("1")) {
//					System.out.print("신규등록할 영화이름 : ");
//					String title = sc.nextLine();
//
//					System.out.print("신규영화의 장르 이름: ");
//					String genre = sc.nextLine();
//
//					// insert 는 callen
//					// main 이 caller 로서 예외 전가발생시 main에게 전달됨.
//					// main에서의 예외 전가는 최후의 보루. main에서 예외전가 할시 운영체제로 전가되어 프로그램 종료.
//					// > try catch 로 예외 처리
//					int result = dao.insert(title, genre);
//					if (result > 0) {
//						System.out.println("입력완료");
//					}
//
//				} else if (menu.equals("2")) {
//
//					List<MoviesDTO> result = dao.selectAll();
//
//					System.out.println("Id\tTitle\tGenre");
//					for (MoviesDTO dto : result) {
//						System.out.println(dto.getId()+"\t" +dto.getTitle()+"\t" +dto.getGenre());
//					}
//
//				} else if (menu.equals("3")) {
//					
//					
//					/*
//					System.out.print("수정할 영화 번호 입력 : ");
//					int id = Integer.parseInt(sc.nextLine());
//					
//					boolean isIdExist = dao.isIdExist(id);
//					if(!isIdExist) { // = isIdExist == false !를 사용하여 반저으로 사용
//					System.out.println("ID : ["+id+"] 영화를 찾을 수 없습니다.")
//					continue;
//					}
//					
//					System.out.print("수정할 영화 제목 입력 : ");
//					String title = sc.nextLine();
//
//					System.out.print("수정할 영화 장르 입력 : ");
//					String genre = sc.nextLine();
//					
//					MoviesDTO dto = new MoviesDTO(id,title,genre);
//					int resultup = dao.update(dto);
//					
//					if (resultup > 0) {
//						System.out.println("변경완료");
//					}
//
//					*/
//					System.out.print("수정할 영화 번호 입력 : ");
//					int id = Integer.parseInt(sc.nextLine());
//					
//					boolean result = dao.isIdExist(id);
//					if(result == false) {
//						System.out.println("수정할 대상 ID 확인불가");
//						continue;
//					}
//					
//					System.out.print("수정할 영화 제목 입력 : ");
//					String title = sc.nextLine();
//
//					System.out.print("수정할 영화 장르 입력 : ");
//					String genre = sc.nextLine();
//
//					MoviesDTO dto = new MoviesDTO(id,title,genre);
//					int resultup = dao.update(dto);
//
//					if (resultup > 0) {
//						System.out.println("변경완료");
//					}
//
//				} else if (menu.equals("4")) {
//
//					System.out.print("삭제할 영화 id : ");
//					int id = Integer.parseInt(sc.nextLine());
//
//					int result = dao.delete(id);
//
//					if (result > 0) {
//						System.out.println("삭제성공");
//					}
//
//				} else if (menu.equals("5")) {
//
//					System.out.print("검색할 영화 제목을 입력하세요 : ");
//					String searchTitle = sc.nextLine();
//					List<MoviesDTO> result = dao.search(searchTitle);
//					
//					System.out.println("Id\tTitle\tGenre");
//					for (MoviesDTO dto : result) {
//						System.out.println(dto.getId()+"\t" +dto.getTitle()+"\t" +dto.getGenre());
//					
//					}
//					
//					
//					
//				} else if (menu.equals("0")) {
//					System.out.println("시스템 종료");
//					System.exit(0);
//				} else {
//					System.out.println("잘못 입력하셨습니다. 메뉴를 다시 골라주세요.");
//				}
//				//
//			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("기능수행중 오류발생");
		}
	}
}