package Quiz01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
	public static void main(String[] args) {
		//employee ���̺��� ���, �����, �޿��� ������ ����ϴ� �ڵ带 �ۼ��ϼ���.
		
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String dbID = "kh";
			String dbPW = "kh";
			
			Connection con = DriverManager.getConnection(url,dbID,dbPW);
			Statement stat = con.createStatement();
			
			String sql = "select * from employee";
			ResultSet rs = stat.executeQuery(sql);
				
				System.out.println("���"+ "\t" + "�����"+ "\t" + "�޿�");
				
			while (rs.next()) {
				
				int emp_id = rs.getInt("emp_id");
				String emp_name = rs.getString("emp_name");
				int salary = rs.getInt("salary");
				
				System.out.println(emp_id+ "\t" + emp_name+ "\t" + salary);
				
			}
			con.close();
			
			
			
			
		}catch(Exception e) {
			System.out.println("���� ����");
		}
		
		
	}
}
