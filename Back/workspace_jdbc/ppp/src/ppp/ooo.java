package ppp;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class ooo {
	public static void main(String[] args) {
		// JDBC - Java Database Connectivity
				// Java ���α׷����� DBMS�� ����ϱ� ���� ���̺귯�� �� ����

				// OJDBC - ����Ŭ �ڹ� ��� ���̺귯��

				Scanner sc = new Scanner(System.in);

				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
				} catch (Exception e) {
					System.out.println("���̺귯���� ã�� �� �����ϴ�.");
					System.exit(0);
				}

				String url = "jdbc:oracle:thin:@localhost:1521:xe"; // Java�θ� ������� �� ���
				String dbID = "kh";
				String dbPW = "kh";

				try {
					// class Ÿ�� ���� con
					Connection con = DriverManager.getConnection(url, dbID, dbPW);
					System.out.println("���� ����");

					Statement stat = con.createStatement(); // sql�� ġ�� �α��� �� �Ͼ�ȭ��

					System.out.print("�űԵ���� �޴��̸� : ");
					String name = sc.nextLine();

					System.out.print("�޴��� ���� : ");
					int price = Integer.parseInt(sc.nextLine());

					System.out.print("ICE ���� ����  (Y , N) : ");
					String isIce = sc.nextLine();

					String sql = "insert into cafe values"
							+ "(" + "cafe_seq.nextval, '" + name + "', " + price + ", '" + isIce+ "')";
//					String sql = "insert into cafe values(cafe_seq.nextval, 'Americano', 2000, 'Y')";
					int result = stat.executeUpdate(sql);

					if (result > 0) {
						System.out.println("�Է¼���");
					}

					con.commit();
					con.close();

				} catch (Exception e) {
					System.out.println("�����ͺ��̽� ���� ����");
					e.printStackTrace(); // ���� Ȯ�� ��ɾ�
				}
	}
}
