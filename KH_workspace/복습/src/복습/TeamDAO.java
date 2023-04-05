package 복습;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.commons.dbcp2.BasicDataSource;


public class TeamDAO {
	
	
	BasicDataSource bds = new BasicDataSource();

	public TeamDAO() {
		bds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		bds.setUsername("team");
		bds.setPassword("team");
		bds.setInitialSize(10); // Connection pool 개수 설정 명령어
	}

	private Connection getConnection () throws Exception {
		return bds.getConnection();

	}
	
	
	// insert Method
	public int insert(String name, int age, String contact) throws Exception{

		String sql = "insert into team_contact values(team_contact_seq.nextval,?,?,?,default)";
		try (Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql)){
			pstat.setString(1, name);
			pstat.setInt(2, age);
			pstat.setString(3, contact);
			
			int result = pstat.executeUpdate();
			con.commit();
			return result;
		}
	}


}
