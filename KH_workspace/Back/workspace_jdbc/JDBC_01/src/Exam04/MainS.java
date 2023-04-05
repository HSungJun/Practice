package Exam04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainS {
	public static void main(String[] args) {

		try {

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String dbID = "kh";
			String dbPW = "kh";

			Connection con = DriverManager.getConnection(url, dbID, dbPW);
			Statement stat = con.createStatement();

			String sql = "select * from department";

			ResultSet rs = stat.executeQuery(sql);
			// rs는 department 데이터들의 주솟값을 받은것. 최상단 좌측끝을 가리키는 중
			// 연결이 끊기면 데이터를 가져올 수 없음.

			while /* if */ (rs.next()) {
				// 다음줄을 가리키도록 명령/리턴값인 boolean은 다음줄의 유무를 확인후 true or false 리턴
				// 1번 행을 가리키는 중.

				// 가져올 데이터의 형태 (컬럼의 번호 또는 컬럼 헤드명);
				String dept_id = rs.getString("dept_id");
				String dept_title = rs.getString("dept_title");
				String location_id = rs.getString("location_id");

				System.out.println(dept_id + "\t" + dept_title + "\t" + location_id);
			}
			// con.commit(); select 기 떄문에 커밋은 불필요
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
