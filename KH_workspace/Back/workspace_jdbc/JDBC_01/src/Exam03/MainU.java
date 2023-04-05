package Exam03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MainU {
	public static void main(String[] args) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e) {
			System.out.println("���� ����");
			System.exit(0);
		}
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbID = "kh";
		String dbPW = "kh";
		
		try{
			Connection con = DriverManager.getConnection(url, dbID, dbPW);
			System.out.println("���Ἲ��");
			
			Statement stat = con.createStatement();
			
			String sql = "update cafe set price = 5000 where name = 'Americano'";
			int result = stat.executeUpdate(sql);
			
			if (result >0) {
				System.out.println("���漺��");
			}
			
			con.commit();
			con.close();
		}catch(Exception e) {
			System.out.println("�������");
			e.printStackTrace();
		}
		
		
		
	}
}
