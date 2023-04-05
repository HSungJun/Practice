package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

import DTO.MemberDTO;

public class MemberDAO {

	BasicDataSource bds = new BasicDataSource();
	
	public MemberDAO() {
		bds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		bds.setUsername("board");
		bds.setPassword("board");
		bds.setInitialSize(10);
	}
	
	private Connection getConnection()throws Exception{
		return bds.getConnection();
	}
	
	public boolean idOverlap (String id) throws Exception{
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

	
	public int insert (MemberDTO dto) throws Exception{
		
		String sql = "insert into members values (?,?,?,?, default)";
		try (Connection con = this.getConnection();
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
	
	public boolean login (String id, String pw) throws Exception {
		String sql = "select * from members where id = ? and pw = ?";
		try (Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql)){
		pstat.setString(1, id);
		pstat.setString(2, pw);
		ResultSet rs = pstat.executeQuery(); 
		return rs.next();
		
		}
	}
	
	public List<MemberDTO> info (String LoginId) throws Exception{
		String sql = "select * from members where id =" + LoginId;
		try (Connection con = this.getConnection(); 
			PreparedStatement pstat = con.prepareStatement(sql);
			ResultSet rs = pstat.executeQuery();) {
			List<MemberDTO> list = new ArrayList<>();
			while (rs.next()) {
			String id = rs.getString("id");
			String pw = rs.getString("pw");
			String name = rs.getString("name");
			String contact = rs.getString("contact");
			Timestamp reg_date = rs.getTimestamp("reg_date");
			MemberDTO dto = new MemberDTO(id,pw,name,contact,reg_date);
			list.add(dto);
			}
			return list;
		}
	}
	
	
	
	
	
}
