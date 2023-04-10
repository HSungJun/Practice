package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.ContactsDTO;

public class ContactsDAO {

	private ContactsDAO() {};
	
	private static ContactsDAO instance = null;
	
	public synchronized static ContactsDAO getInstance() {
		if(instance == null) {
			instance = new ContactsDAO();
		}
		return instance;
	}
	
	
	private Connection getConnection() throws Exception{
		Context iCtx = new InitialContext();
		DataSource ds = (DataSource)iCtx.lookup("java:/comp/env/jdbc/ora");
		return ds.getConnection();
		
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		String url = "jdbc:oracle:thin:@localhost:1521:xe";
//		String dbid = "kh";
//		String dbpw = "kh";
//		Connection con = DriverManager.getConnection(url, dbid, dbpw);
//		return con;
	}
	
	public int insert(String name, String contact) throws Exception {
		String sql = "insert into contacts values(contacts_seq.nextval,?,?)";
		try (Connection con = this.getConnection();
				PreparedStatement ppst = con.prepareStatement(sql);){
			ppst.setString(1, name);
			ppst.setString(2, contact);
			int result = ppst.executeUpdate();
			con.commit();
			return result;
		}
	}
	
	public List<ContactsDTO> selectAll() throws Exception{
		String sql = "select * from contacts order by 1";
		try (Connection con = this.getConnection();
				PreparedStatement ppst = con.prepareStatement(sql);
				ResultSet rs = ppst.executeQuery();){ 
			//ResultSet은 활성화 중에만 사용 가능. 닫히기 전에 List에 담아 사용함.
			List<ContactsDTO> result = new ArrayList<>();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String contact = rs.getString("contact");
				ContactsDTO dto = new ContactsDTO(id,name,contact);
				result.add(dto); 
			}
			return result;

		}
	}
	
	public int delete(int delid) throws Exception{
		String sql = "delete from contacts where id = ?";
		try (Connection con = this.getConnection();
				PreparedStatement ppst = con.prepareStatement(sql);){
			ppst.setInt(1, delid);
			int result = ppst.executeUpdate();
			con.commit();
			return result;
		}
	}

	public int modify(int modId,String modName, String modContact) throws Exception{
		String sql = "update contacts set name = ?, contact = ? where id=?";
		try (Connection con = this.getConnection();
				PreparedStatement ppst = con.prepareStatement(sql);){
			ppst.setString(1, modName);
			ppst.setString(2, modContact);
			ppst.setInt(3, modId);
			int result = ppst.executeUpdate();
			return result;
		}
		
	}
}