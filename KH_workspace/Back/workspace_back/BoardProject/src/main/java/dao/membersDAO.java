package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import commons.EncryptionUnits;
import dto.membersDTO;

public class membersDAO {
	private membersDAO() {
	};

	private static membersDAO instance = null;

	public synchronized static membersDAO getInstance() {
		if (instance == null) {
			instance = new membersDAO();
		}
		return instance;
	}

	private Connection getConnection() throws Exception {
		Context iCtx = new InitialContext();
		DataSource ds = (DataSource) iCtx.lookup("java:/comp/env/jdbc/ora");
		return ds.getConnection();
	}

	public boolean isIdExist(String id) throws Exception {
		String sql = "select id from members where id = ?";
		try (Connection con = this.getConnection(); PreparedStatement ppst = con.prepareStatement(sql);) {
			ppst.setString(1, id);
			try (ResultSet rs = ppst.executeQuery()) {
				return rs.next();
			}
		}
	}

	public int signIn(String id, String pw, String name, String phone, String email, String zipcode, String address1,
			String address2) throws Exception {
		String sql = "insert into members values (?,?,?,?,?,?,?,?,sysdate)";
		try (Connection con = this.getConnection(); PreparedStatement ppst = con.prepareStatement(sql);) {
			String shapw = EncryptionUnits.sha512(pw);
			ppst.setString(1, id);
			ppst.setString(2, shapw);
			ppst.setString(3, name);
			ppst.setString(4, phone);
			ppst.setString(5, email);
			ppst.setString(6, zipcode);
			ppst.setString(7, address1);
			ppst.setString(8, address2);
			int result = ppst.executeUpdate();
			con.commit();
			return result;
		}
	}

	public boolean logIn(String id, String pw) throws Exception {
		String sql = "select id,pw from members where id=? and pw=?";
		try (Connection con = this.getConnection(); PreparedStatement ppst = con.prepareStatement(sql);) {
			String shapw = EncryptionUnits.sha512(pw);
			ppst.setString(1, id);
			ppst.setString(2, shapw);
			int result = ppst.executeUpdate();
			if (result == 0) {
				return false;
			} else {
				return true;
			}
		}
	}

	public boolean memberOut (String id)throws Exception {
		String sql = "delete from members where id = ?";
		try (Connection con = this.getConnection(); PreparedStatement ppst = con.prepareStatement(sql);) {
			ppst.setString(1, id);
			int result = ppst.executeUpdate();
			if (result == 0) {
				return false;
			} else {
				return true;
			}
		}
	}

	public membersDTO getMyInfo(String id) throws Exception {
		String sql = "select * from members where id = ?";
		membersDTO dto = new membersDTO();
		try (Connection con = this.getConnection(); 
				PreparedStatement ppst = con.prepareStatement(sql);){
			ppst.setString(1, id);
			try(ResultSet rs = ppst.executeQuery()){
			membersDTO result = new membersDTO();
			
			rs.next();
			String mpid = rs.getString("id");
			String mpname = rs.getString("name");
			String mpphone = rs.getString("phone");
			String mpemail = rs.getString("email");
			
			dto.setId(mpid);
			dto.setName(mpname);
			dto.setPhone(mpphone);
			dto.setEmail(mpemail);
			}
			return dto;
		}
	}



}
