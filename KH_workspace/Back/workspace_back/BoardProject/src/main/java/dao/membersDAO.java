package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class membersDAO {

	private membersDAO () {};

	private static membersDAO instance = null;

	public synchronized static membersDAO getInstance() {
		if(instance == null) {
			instance = new membersDAO();
		}
		return instance;
	}

	private Connection getConnection() throws Exception{
		Context iCtx = new InitialContext();
		DataSource ds = (DataSource)iCtx.lookup("java:/comp/env/jdbc/ora");
		return ds.getConnection();
	}

	public boolean isIdExist(String id) throws Exception{
		String sql = "select id from members where id = ?";
		try (Connection con = this.getConnection();
				PreparedStatement ppst = con.prepareStatement(sql);){
			ppst.setString(1, id);
			try (ResultSet rs = ppst.executeQuery()){
				return rs.next();
			}

		}
	}


}
