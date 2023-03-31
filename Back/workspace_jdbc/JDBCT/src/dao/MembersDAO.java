package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

import dto.MembersDTO;

public class MembersDAO {

	
	//DBCP - DataBase Connection Pool (DB �����ڼ��� �ް��ϰ� ������ ���� ������ ���� �����ϱ� ���� ��)
	// Database Connection ��ü�� ��뷮�� ���������� ������ �� ,
	// Databasee�� �����ߴܵ��� �ʵ��� ����� ��ȭ�ϴ� ������ġ
	// ������ Connection��ü�� �뿩 / ��ȯ�ϴ� �ý������� ����ϸ� �������� ����������
	// �����ڰ� ���� �� ��������� ��ٸ��� �ð��� �þ �� �־� ������ ���� ��ġ�� �ʿ���.	
	
	BasicDataSource bds = new BasicDataSource();
	// �� �Ҷ����� �ν��Ͻ��� �����Ǿ� ������ ���ѻ����ϵ��� �ؼ� �ܺο� ������ �Ѵ�.
	
	
	public MembersDAO() {
		bds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		bds.setUsername("kh");
		bds.setPassword("kh");
		bds.setInitialSize(10); // Connection pool ���� ���� ���ɾ�
	}
private Connection getConnection () throws Exception {
		return bds.getConnection();
		
	}
	// library�� ������ (Depedencies)




//	private Connection getConnection() throws Exception {
//		String url = "jdbc:oracle:thin:@localhost:1521:xe";
//		String dbID = "kh";
//		String dbPW = "kh";
//		Connection con = DriverManager.getConnection(url, dbID, dbPW);
//		return con;
//	}

	public int insert(MembersDTO dto) throws Exception {

		// �Ϲ� Statement �� ����ϴ� ���
		// String sql = "insert into members
		// values('"+dto.getId()+"','"+dto.getPw()+"','"+dto.getName()+"','"+dto.getContact()+"',default)";
		// try(Connection con = this.getConnection();
		// Statement stat = con.createStatement();){
		// int result = stat.executeUpdate(sql);
		// con.commit();
		// return result;
		// }

		// PreparedStatement �� ����ϴ� ���
		String sql = "insert into members values(?, ?, ?, ?, default)";
		try (Connection con = this.getConnection(); 
				PreparedStatement pstat = con.prepareStatement(sql)) {
			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getPw());
			pstat.setString(3, dto.getName());
			pstat.setString(4, dto.getContact());

			int result = pstat.executeUpdate();
			con.commit();
			return result;
		}

	}

	public boolean isLoginOK(String id, String pw) throws Exception {
		String sql = "select * from members where id = ? and pw = ?";
		try (Connection con = this.getConnection(); PreparedStatement stat = con.prepareStatement(sql)) {
			stat.setString(1, id);
			stat.setString(2, pw);
			ResultSet rs = stat.executeQuery();
			return rs.next();
		}
	}

	public boolean idOverlapCheck (String id) throws Exception{
		String sql = "select id from members where id =  ?  ";
		try(Connection con = this.getConnection();
				PreparedStatement stat = con.prepareStatement(sql)){
			stat.setString(1, id);
			ResultSet rs = stat.executeQuery();

			while(rs.next()) {
				String searchId = rs.getString("id");
				if (searchId.equals(id)) {
					return true;
				}
			}
			return false;
		}
	}

	public boolean isIdExist (String id) throws Exception{
		
		String sql = "select * from members where id = ? ";
		
		ResultSet rs = null;
		try(Connection con = this.getConnection();
		PreparedStatement stat = con.prepareStatement(sql)){
		stat.setString(1, id);
		rs = stat.executeQuery();
		return rs.next();
		}finally {
			if(rs!=null)rs.close();
		
		}
	}

	public List<MembersDTO> selectAll () throws Exception {
		String sql = "select * from members";
		try (Connection con = this.getConnection(); 
				PreparedStatement stat = con.prepareStatement(sql)) {
			ResultSet rs = stat.executeQuery();
			
			List<MembersDTO> list = new ArrayList<>();
			while(rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String contact = rs.getString("contact");
				Timestamp reg_date = rs.getTimestamp("reg_date");
				
				MembersDTO dto = new MembersDTO(id,pw,name,contact,reg_date);
				list.add(dto);
			}
				return list;
		}
	}

	public List<MembersDTO> info (String LoginId) throws Exception{
		String sql = "select * from members where " + LoginId;
		try (Connection con = this.getConnection(); 
				PreparedStatement pstat = con.prepareStatement(sql)) {
			ResultSet rs = pstat.executeQuery();
			
			List<MembersDTO> list = new ArrayList<>();
			String id = rs.getString("id");
			String pw = rs.getString("pw");
			MembersDTO dto = new MembersDTO(id,pw,null,null,null);
			list.add(dto);
			return list;
		}
	}
	
	
}