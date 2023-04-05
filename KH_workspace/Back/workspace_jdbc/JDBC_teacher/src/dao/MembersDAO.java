package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import dto.MembersDTO;

public class MembersDAO {

	private Connection getConnection() throws Exception{
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbID = "kh";
		String dbPW = "kh";
		Connection con = DriverManager.getConnection(url, dbID, dbPW);
		return con;
	}

	public int insert(MembersDTO dto) throws Exception{
		
		// 일반 Statement 를 사용하는 경우
//		String sql = "insert into members values('"+dto.getId()+"','"+dto.getPw()+"','"+dto.getName()+"','"+dto.getContact()+"',default)";
//		try(Connection con = this.getConnection();
//			Statement stat = con.createStatement();){
//			int result = stat.executeUpdate(sql);
//			con.commit();
//			return result;
//		}
		
		// PreparedStatement 를 사용하는 경우
		String sql = "insert into members values(?, ?, ?, ?, default)";
		try(Connection con = this.getConnection();
			PreparedStatement pstat = con.prepareStatement(sql)){
			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getPw());
			pstat.setString(3, dto.getName());
			pstat.setString(4, dto.getContact());
			
			int result = pstat.executeUpdate();
			con.commit();
			return result;
		}
		
		
		
	}
	
	public boolean isLoginOK(String id, String pw) throws Exception{
		String sql = "select * from members where id = ? and pw = ?";
		try(Connection con = this.getConnection();
			PreparedStatement stat = con.prepareStatement(sql)){
			stat.setString(1, id);
			stat.setString(2, pw);
			ResultSet rs = stat.executeQuery();
			return rs.next();
		}
		
		
	}


}








