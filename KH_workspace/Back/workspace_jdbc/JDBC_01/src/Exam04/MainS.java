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
			// rs�� department �����͵��� �ּڰ��� ������. �ֻ�� �������� ����Ű�� ��
			// ������ ����� �����͸� ������ �� ����.

			while /* if */ (rs.next()) {
				// �������� ����Ű���� ���/���ϰ��� boolean�� �������� ������ Ȯ���� true or false ����
				// 1�� ���� ����Ű�� ��.

				// ������ �������� ���� (�÷��� ��ȣ �Ǵ� �÷� ����);
				String dept_id = rs.getString("dept_id");
				String dept_title = rs.getString("dept_title");
				String location_id = rs.getString("location_id");

				System.out.println(dept_id + "\t" + dept_title + "\t" + location_id);
			}
			// con.commit(); select �� ������ Ŀ���� ���ʿ�
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
