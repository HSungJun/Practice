package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.replyDTO;

public class replyDAO {

	private replyDAO() {
	};

	private static replyDAO instance = null;

	public synchronized static replyDAO getInstance() {
		if (instance == null) {
			instance = new replyDAO();
		}
		return instance;
	};

	private Connection getConnection() throws Exception {
		Context iCtx = new InitialContext();
		DataSource ds = (DataSource) iCtx.lookup("java:/comp/env/jdbc/ora");
		return ds.getConnection();
	};

	public int addReply(String writer, String contents, int pa_seq) throws Exception {
		String sql = "insert into reply values(reply_seq.nextval,?,?,sysdate,?)";
		try (Connection con = this.getConnection(); PreparedStatement ppst = con.prepareStatement(sql);) {
			ppst.setString(1, writer);
			ppst.setString(2, contents);
			ppst.setInt(3, pa_seq);

			int result = ppst.executeUpdate();

			return result;
		}
	};

	public List<replyDTO> listReplyByPa_seq(int pa_seq) throws Exception {
		String sql = "select * from reply where parent_seq = ?";
		try (Connection con = this.getConnection(); PreparedStatement ppst = con.prepareStatement(sql);) {
			ppst.setInt(1, pa_seq);

			try (ResultSet rs = ppst.executeQuery();) {
				List<replyDTO> result = new ArrayList<>();
				while (rs.next()) {
					int seq = rs.getInt("seq");
					String writer = rs.getString("writer");
					String contents = rs.getString("contents");
					Timestamp write_date = rs.getTimestamp("write_date");
					int parent_seq = rs.getInt("parent_seq");

					replyDTO dto = new replyDTO(seq, writer, contents, write_date, parent_seq);
					result.add(dto);
				}
				return result;
			}
		}
	}

	public int updateReply(String re_li_contents, int re_li_seq) throws Exception {
			String sql = "update reply set contents = ? where seq = ?";
			try (Connection con = this.getConnection(); PreparedStatement ppst = con.prepareStatement(sql);) {
				ppst.setString(1, re_li_contents);
				ppst.setInt(2, re_li_seq);
				
				int result = ppst.executeUpdate();
	
				return result;
			}
	}
	
	
	public int deleteReply(int re_seq) throws Exception {
		String sql = "delete from reply where seq = ?";
		try (Connection con = this.getConnection(); PreparedStatement ppst = con.prepareStatement(sql);) {
			ppst.setInt(1, re_seq);
			int result = ppst.executeUpdate();
			return result;
		}
	}
	
	
}
