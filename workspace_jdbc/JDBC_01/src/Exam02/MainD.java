package Exam02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class MainD {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		}catch(Exception e) {
			System.out.println("연결실패");
			System.exit(0);
		}
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbID = "kh";
		String dbPW = "kh";
		
		try {
			Connection con = DriverManager.getConnection(url, dbID, dbPW);
			System.out.println("연결성공");
			
			Statement stat = con.createStatement();
			
			System.out.println("삭제할메뉴 이름");
			String name = sc.nextLine();
			
			
			
			String sql = "delete from cafe where Name = '"+name+"'";
//			String sql = "delete from cafe where Name = 'Americano'";
			int result = stat.executeUpdate(sql);
			
			if (result >0) {
				System.out.println("삭제성공");
			}
			
			con.commit();
			con.close();
			
			
		}catch(Exception e) {
			System.out.println("연결에 실패함");
			e.printStackTrace();
		}
		
	}
}
