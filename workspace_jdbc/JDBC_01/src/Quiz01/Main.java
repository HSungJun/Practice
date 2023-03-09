package Quiz01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
	public static void main(String[] args) {
		//employee 테이블에서 사번, 사원명, 급여를 가져와 출력하는 코드를 작성하세요.
		
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String dbID = "kh";
			String dbPW = "kh";
			
			Connection con = DriverManager.getConnection(url,dbID,dbPW);
			Statement stat = con.createStatement();
			
			String sql = "select * from employee";
			ResultSet rs = stat.executeQuery(sql);
				
				System.out.println("사번"+ "\t" + "사원명"+ "\t" + "급여");
				
			while (rs.next()) {
				
				int emp_id = rs.getInt("emp_id");
				String emp_name = rs.getString("emp_name");
				int salary = rs.getInt("salary");
				
				System.out.println(emp_id+ "\t" + emp_name+ "\t" + salary);
				
			}
			con.close();
			
			
			
			
		}catch(Exception e) {
			System.out.println("연결 실패");
		}
		
		
	}
}
