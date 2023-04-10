import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {
	public ShopMember searchUser(String memberId) {
		//table �� �������� �ϳ��̻��� ����ϰ��� �Ѵٸ� List�� ����Ͽ� ��ȯ���ֵ��� �Ѵ�.

		Connection con = null;
		
		//sql ���� ?�� �̿��Ͽ� �Է��ϰ��� �� �� preparedstatement�� �̿��Ͽ� ? ���� ������ ���� �־��־�� �ϳ� statement�� �����
		ResultSet rs = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "test_01";
		String password = "1234";
		ShopMember shopMember = null;
		
		try {
		con = DriverManager.getConnection(url, user, password);
		String query = "SELECT * FROM SHOP_MEMBER WHERE MEMBER_ID = ?";
//		Statement stmt = con.prepareStatement(query);
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1, memberId);
		//String memberId�� ���� searchUser �޼ҵ带 �����Ͽ� member_id���� �Է¹޾� �������� �����ϰ��� �Ͽ�����
		// ? ���� ��� ���� �Էµ��� �ʾ� �������� ����� �� ����.
		//con.prepapareStatement �� �߸��� ������ ����Ͽ���
//		stmt = con.prepapareStatement(query);
		rs = stmt.executeQuery();
		
		if(rs.next()) {
		shopMember.setMemberId(rs.getString("MEMBER_ID"));
		shopMember.setMemberPw(rs.getString("MEMBER_PW"));
		shopMember.setMemberName(rs.getString("MEMBER_NAME"));
		shopMember.setMemberAge(rs.getInt("MEMBER_AGE"));
		//MemberAge�� ������ Ÿ���� number�� �Ǿ��־� Int �� �Է¹޾ƾ��ϳ� String Ÿ���� �Է��Ϸ��� �� 
		shopMember.setPhone(rs.getString("MEMBER_PHONE"));
		//member_phone ���� ������ ���;� �ϳ� �̸� �߸��Է��Ͽ� �����͸� �������� ����.
		shopMember.setAddr(rs.getString("MEMBER_ADDR"));
		//member_addr ���� ������ ���;� �ϳ� �̸� �߸��Է��Ͽ� �����͸� �������� ����.
		}
		rs.close(); 
		stmt.close(); 
		con.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return shopMember;
		//return shopMember�� �� �� �� �ּҸ� ��ȯ�ϰ� �Ǿ� ����ε� ���̺��� �����Ͱ��� ��ȯ���� ���Ѵ�.
		}
}