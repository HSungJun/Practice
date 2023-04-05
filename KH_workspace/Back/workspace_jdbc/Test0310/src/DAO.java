import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {
	public ShopMember searchUser(String memberId) {
		//table 내 데이터중 하나이상을 출력하고자 한다면 List를 사용하여 반환해주도록 한다.

		Connection con = null;
		
		//sql 문에 ?를 이용하여 입력하고자 할 시 preparedstatement를 이용하여 ? 값에 지정된 값을 넣어주어야 하나 statement를 사용함
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
		//String memberId를 통해 searchUser 메소드를 실행하여 member_id값을 입력받아 쿼리문을 실행하고자 하였으나
		// ? 값에 어떠한 값도 입력되지 않아 쿼리문이 실행될 수 없음.
		//con.prepapareStatement 로 잘못된 문장을 사용하였음
//		stmt = con.prepapareStatement(query);
		rs = stmt.executeQuery();
		
		if(rs.next()) {
		shopMember.setMemberId(rs.getString("MEMBER_ID"));
		shopMember.setMemberPw(rs.getString("MEMBER_PW"));
		shopMember.setMemberName(rs.getString("MEMBER_NAME"));
		shopMember.setMemberAge(rs.getInt("MEMBER_AGE"));
		//MemberAge의 데이터 타입이 number로 되어있어 Int 로 입력받아야하나 String 타입을 입력하려고 함 
		shopMember.setPhone(rs.getString("MEMBER_PHONE"));
		//member_phone 값의 정보를 얻어와야 하나 이를 잘못입력하여 데이터를 가져오지 못함.
		shopMember.setAddr(rs.getString("MEMBER_ADDR"));
		//member_addr 값의 정보를 얻어와야 하나 이를 잘못입력하여 데이터를 가져오지 못함.
		}
		rs.close(); 
		stmt.close(); 
		con.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return shopMember;
		//return shopMember를 할 시 그 주소를 반환하게 되어 제대로된 테이블내 데이터값을 반환하지 못한다.
		}
}
