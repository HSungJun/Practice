package ppp;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class ooo {
	public static void main(String[] args) {
		// JDBC - Java Database Connectivity
				// Java 프로그램에서 DBMS를 사용하기 위한 라이브러리 및 문법

				// OJDBC - 오라클 자바 통신 라이브러리

				Scanner sc = new Scanner(System.in);

				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
				} catch (Exception e) {
					System.out.println("라이브러리를 찾을 수 없습니다.");
					System.exit(0);
				}

				String url = "jdbc:oracle:thin:@localhost:1521:xe"; // Java로만 만들어진 것 사용
				String dbID = "kh";
				String dbPW = "kh";

				try {
					// class 타입 변수 con
					Connection con = DriverManager.getConnection(url, dbID, dbPW);
					System.out.println("연결 성공");

					Statement stat = con.createStatement(); // sql로 치면 로그인 후 하얀화면

					System.out.print("신규등록할 메뉴이름 : ");
					String name = sc.nextLine();

					System.out.print("메뉴의 가격 : ");
					int price = Integer.parseInt(sc.nextLine());

					System.out.print("ICE 가능 여부  (Y , N) : ");
					String isIce = sc.nextLine();

					String sql = "insert into cafe values"
							+ "(" + "cafe_seq.nextval, '" + name + "', " + price + ", '" + isIce+ "')";
//					String sql = "insert into cafe values(cafe_seq.nextval, 'Americano', 2000, 'Y')";
					int result = stat.executeUpdate(sql);

					if (result > 0) {
						System.out.println("입력성공");
					}

					con.commit();
					con.close();

				} catch (Exception e) {
					System.out.println("데이터베이스 연결 실패");
					e.printStackTrace(); // 오류 확인 명령어
				}
	}
}
