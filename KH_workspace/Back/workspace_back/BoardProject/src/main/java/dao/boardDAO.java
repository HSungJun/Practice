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

import dto.boardDTO;

public class boardDAO {

	private boardDAO() {
	};

	private static boardDAO instance = null;

	public synchronized static boardDAO getInstance() {
		if (instance == null) {
			instance = new boardDAO();
		}
		return instance;
	};

	private Connection getConnection() throws Exception {
		Context iCtx = new InitialContext();
		DataSource ds = (DataSource) iCtx.lookup("java:/comp/env/jdbc/ora");
		return ds.getConnection();
	};

	public int pushContent(String writer, String title, String contents, int view_count) throws Exception {
		String sql = "insert into board values (board_seq.nextval,?,?,?,?,sysdate)";
		try (Connection con = this.getConnection(); PreparedStatement ppst = con.prepareStatement(sql);) {
			ppst.setString(1, writer);
			ppst.setString(2, title);
			ppst.setString(3, contents);
			ppst.setInt(4, view_count);

			int result = ppst.executeUpdate();

			return result;
		}
	};

	public List<boardDTO> select() throws Exception {
		String sql = "select * from board order by 6 desc";
		try (Connection con = this.getConnection();
				PreparedStatement ppst = con.prepareStatement(sql);
				ResultSet rs = ppst.executeQuery();) {
			// ResultSet은 활성화 중에만 사용 가능. 닫히기 전에 List에 담아 사용함.
			List<boardDTO> result = new ArrayList<>();
			while (rs.next()) {
				int seq = rs.getInt("seq");
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String contents = rs.getString("contents");
				int view_count = rs.getInt("view_count");
				Timestamp write_date = (Timestamp) rs.getTimestamp("write_date");
				boardDTO dto = new boardDTO(seq, writer, title, contents, view_count, write_date);
				result.add(dto);
			}
			return result;
		}
	};

	public boardDTO contentsBySeq(int seq) throws Exception {
		String sql = "select * from board where seq = ?";
		try (Connection con = this.getConnection(); PreparedStatement ppst = con.prepareStatement(sql);) {
			ppst.setInt(1, seq);
			try (ResultSet rs = ppst.executeQuery()) {
				boardDTO result = new boardDTO();

				rs.next();
				int coSeq = rs.getInt("seq");
				String coWriter = rs.getString("writer");
				String coTitle = rs.getString("title");
				String coContents = rs.getString("contents");
				int coView_count = rs.getInt("view_count");
				Timestamp coWrite_date = rs.getTimestamp("write_date");

				coView_count++;
				boardDAO.getInstance().updateView_count(coSeq, coView_count);

				result.setSeq(coSeq);
				result.setWriter(coWriter);
				result.setTitle(coTitle);
				result.setContents(coContents);
				result.setView_count(coView_count);
				result.setWrite_date(coWrite_date);

				return result;
			}
		}
	};

	public int updateView_count(int seq, int view_count) throws Exception {
		String sql = "update board set view_count =? where seq=?";
		try (Connection con = this.getConnection(); PreparedStatement ppst = con.prepareStatement(sql);) {
			ppst.setInt(1, view_count);
			ppst.setInt(2, seq);
			int result = ppst.executeUpdate();
			return result;
		}
	}

	public int delete(int seq) throws Exception {
		String sql = "delete from board where seq = ?";
		try (Connection con = this.getConnection(); PreparedStatement ppst = con.prepareStatement(sql);) {
			ppst.setInt(1, seq);
			int result = ppst.executeUpdate();
			return result;
		}
	}

	public int modify(int seq,String title, String contents) throws Exception{
		String sql = "update board set title = ?, contents= ? where seq=?";
		try (Connection con = this.getConnection();
				PreparedStatement ppst = con.prepareStatement(sql);){
			ppst.setString(1, title);
			ppst.setString(2, contents);
			ppst.setInt(3, seq);
			int result = ppst.executeUpdate();
			return result;
		}
	}

}
