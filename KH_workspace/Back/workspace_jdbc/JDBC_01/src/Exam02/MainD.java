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
			System.out.println("�������");
			System.exit(0);
		}
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbID = "kh";
		String dbPW = "kh";
		
		try {
			Connection con = DriverManager.getConnection(url, dbID, dbPW);
			System.out.println("���Ἲ��");
			
			Statement stat = con.createStatement();
			
			System.out.println("�����Ҹ޴� �̸�");
			String name = sc.nextLine();
			
			
			
			String sql = "delete from cafe where Name = '"+name+"'";
//			String sql = "delete from cafe where Name = 'Americano'";
			int result = stat.executeUpdate(sql);
			
			if (result >0) {
				System.out.println("��������");
			}
			
			con.commit();
			con.close();
			
			
		}catch(Exception e) {
			System.out.println("���ῡ ������");
			e.printStackTrace();
		}
		
	}
}
