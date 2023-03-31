package main;

import java.util.List;
import java.util.Scanner;

import commons.EncryptionUnits;
import dao.MembersDAO;
import dao.MoviesDAO;
import dto.MembersDTO;
import dto.MoviesDTO;

public class Main {
	public static void main(String[] args) {

		// 로그인 및 회원가입
		// 1. Members 테이블 생성
		// - id 문자열 20 byte 주키 설정
		// - pw 문자열 20 byte 비워둘 수 없음
		// - name 문자열 20 byte 비워둘 수 없음
		// - contact 문자열 20 byte
		// - reg_date timestamp default sysdate 비워둘 수 없음

		MembersDAO MembersDAO = new MembersDAO();

		try (Scanner sc = new Scanner(System.in);) {

			while (true) {
				try {
					System.out.println("<< Index >>");
					System.out.println("1. 로그인");
					System.out.println("2. 회원가입");
					System.out.println("3. 회원목록출력");
					System.out.println("0. 종료");
					String menu = sc.nextLine();

					if (menu.equals("1")) {
						System.out.println("<< 로그인 >>");

						System.out.print("ID : ");
						String id = sc.nextLine();

						// 단방향 암호화를 적용
						// SHA - 256

						System.out.print("PW : ");
						String pw = EncryptionUnits.sha256(sc.nextLine());

						boolean result = MembersDAO.isLoginOK(id, pw);
						if (result) {
							System.out.println(id + " 님 환영합니다.");
							break;
						} else {
							System.out.println("ID 또는 PW를 다시 확인해주세요.");
						}

					} else if (menu.equals("2")) {

						System.out.println("<< 회원가입 >>");

						String id = "";
						while (true) {
							System.out.print("ID 를 입력해주세요 : ");
							id = sc.nextLine();

							boolean result = MembersDAO.idOverlapCheck(id);
							if (result == false) {
								System.out.println("id 중복 없음.");
								break;
							} else if (result == true) {
								System.out.println("이미 존재하는 id 입니다.");
							}
						}

						System.out.print("PW 를 입력해주세요 : ");
						String pw = sc.nextLine();

						pw = EncryptionUnits.sha256(pw);

						System.out.print("이름을 입력해주세요 : ");
						String name = sc.nextLine();

						System.out.print("연락처를 입력해주세요 : ");
						String contact = sc.nextLine();

						int result = MembersDAO.insert(new MembersDTO(id, pw, name, contact, null));
						if (result > 0) {
							System.out.println("가입 완료");
						}

					} else if (menu.equals("3")) {
						List<MembersDTO> list = MembersDAO.selectAll();

						for (MembersDTO dto : list) {

							// SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd (E) hh:mm:ss.SSS");
							// String formedDate = sdf.format(dto.getReg_date());

							System.out.println(dto.getId() + "\t" + dto.getFormedDate());
						}

					} else if (menu.equals("0")) {
						System.out.println("시스템을 종료합니다.");
						System.exit(0);
					} else {
						System.out.println("메뉴를 다시 확인해주세요.");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			// PreparedStatement 로 변경된 코드가 다 정상 동작하는지 확인
			// 여기서부터 프로그램 본체 시작
			MoviesDAO dao = new MoviesDAO();
			while (true) {
				System.out.println("<< Netflix 영화 관리 프로그램 >>");
				System.out.println("1. 신규 영화 등록"); // C
				System.out.println("2. 영화 목록 출력"); // R
				System.out.println("3. 영화 정보 수정"); // U -- ID를 기준으로 모든 정보 수정
				System.out.println("4. 영화 정보 삭제"); // D -- ID를 기준으로 삭제
				System.out.println("5. 영화 정보 검색"); // 제목으로 검색
				System.out.println("0. 프로그램 종료");
				System.out.print(">> ");
				String menu = sc.nextLine();

				try {
					if (menu.equals("1")) {
						System.out.print("신규 영화 제목 : ");
						String title = sc.nextLine();

						System.out.print("신규 영화 장르 : ");
						String genre = sc.nextLine();

						int result = dao.insert(title, genre);
						if (result > 0) {
							System.out.println("입력 완료");
						}
					} else if (menu.equals("2")) {
						List<MoviesDTO> result = dao.selectAll();
						System.out.println("ID\tTitle\tGenre");
						for (MoviesDTO dto : result) {
							System.out.println(dto.getId() + "\t" + dto.getTitle() + "\t" + dto.getGenre());
						}
					} else if (menu.equals("3")) {
						System.out.print("수정할 대상의 ID : ");
						int id = Integer.parseInt(sc.nextLine());

						// if(exisnt)로 수정하고 else {cotinue;} 해도 똑같은건가요 ?
						// 똑같은 기능을 하는건지 궁금했어요 감사합니다 ~ 네

						// false : 해당 ID가 없음
						// true : 해당 ID가 있음
						boolean isIdExist = dao.isIdExist(id);

						if (!isIdExist) {// 해당 ID가 없어서 false가 반환되었을 때, !(not) 기호로 반전시켜 true를 만들고 if를 실행
							System.out.println("ID : [" + id + "] 영화를 찾을 수 없습니다.");
							continue;
						}

						System.out.print("신규 영화 제목 : ");
						String title = sc.nextLine();

						System.out.print("신규 영화 장르 : ");
						String genre = sc.nextLine();

						MoviesDTO dto = new MoviesDTO(id, title, genre);
						int result = dao.update(dto);

						if (result > 0) {
							System.out.println("변경 완료");
						}

					} else if (menu.equals("4")) {
						System.out.print("삭제 할 영화의 ID : ");
						int id = Integer.parseInt(sc.nextLine());

						int result = dao.delete(id);
						if (result > 0) {
							System.out.println("삭제 완료");
						} else {
							System.out.println("삭제할 ID를 찾을 수 없습니다.");
						}
					} else if (menu.equals("5")) {

						System.out.print("검색할 영화의 제목 : ");
						String target = sc.nextLine();

						List<MoviesDTO> result = dao.searchByTitle(target);
						System.out.println("ID\tTitle\tGenre");
						for (MoviesDTO dto : result) {
							System.out.println(dto.getId() + "\t" + dto.getTitle() + "\t" + dto.getGenre());
						}

					} else if (menu.equals("0")) {
						System.out.println("시스템을 종료합니다.");
						System.exit(0);
					} else {
						System.out.println("메뉴를 다시 확인해주세요.");
					}
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("기능 수행 중 오류가 발생했습니다.");
				}
			}

		}
	}
}
