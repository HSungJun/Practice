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
import statics.Settings;

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

	public int modify(int seq, String title, String contents) throws Exception {
		String sql = "update board set title = ?, contents= ? where seq=?";
		try (Connection con = this.getConnection(); PreparedStatement ppst = con.prepareStatement(sql);) {
			ppst.setString(1, title);
			ppst.setString(2, contents);
			ppst.setInt(3, seq);
			int result = ppst.executeUpdate();
			return result;
		}
	}

	private int getRecordCount() throws Exception {
		String sql = "select count(*) from board";
		try (Connection con = this.getConnection();
				PreparedStatement ppst = con.prepareStatement(sql);
				ResultSet rs = ppst.executeQuery()) {
			rs.next();
			return rs.getInt(1);
		}

	}

	//페이지 관련 select method
	public List<boardDTO> selectBound(int start, int end) throws Exception {
		String sql = "select * from (select board.*, row_number() over(order by seq desc) rn from board) where rn between ? and ?";
		try (Connection con = this.getConnection(); PreparedStatement ppst = con.prepareStatement(sql);) {
			ppst.setInt(1, start);
			ppst.setInt(2, end);
			try (ResultSet rs = ppst.executeQuery();) {

				List<boardDTO> list = new ArrayList<>();
				while (rs.next()) {
					int seq = rs.getInt("seq");
					String writer = rs.getString("writer");
					String title = rs.getString("title");
					String contents = rs.getString("contents");
					int view_count = rs.getInt("view_count");
					Timestamp write_date = (Timestamp) rs.getTimestamp("write_date");
					boardDTO dto = new boardDTO(seq, writer, title, contents, view_count, write_date);
					list.add(dto);
				}
				return list;
			}
		}
	}

	public String getPageNavi(int currentPage) throws Exception {
                                        
		// 네비게이터를 만들기 위한 필요한 초기 정보
		int recordTottalCount = this.getRecordCount(); // 1.전체 글의 개수
		int recordCountPerPage = Settings.BOARD_RECORD_COUNT_PER_PAGE; // 2. 페이지당 보여줄 개수
		int naviCountPerPage = Settings.BOARD_NAVI_COUNT_PER_PAGE; // 3. 페이지당 보여줄 네비게이터의 수

		// 총 페이지 수 계산
		int pageTotalCount = recordTottalCount / recordCountPerPage; // 4. 1번과 2번에의해 총 페이지의 개수가 정해짐

		// (int)(Math.cell((double)recordTotalCount / recordCountPerPage));

		// 전체글 / 페이지당 글 개수 나누기
		if (recordTottalCount % recordCountPerPage > 0) {
			recordTottalCount = recordTottalCount / recordCountPerPage + 1;
		} else {
			recordTottalCount = recordTottalCount / recordCountPerPage;
			// 전체글 개수 나누기 페이지당 개수 의 나머지가 0일 경우 페이지 추가 안함. 그외 + 1
		}

		if (currentPage < 1) {
			currentPage = 1;
		} else if (currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}

		int startNavi = (currentPage - 1) / naviCountPerPage * naviCountPerPage + 1;
		int endNavi = startNavi + (naviCountPerPage - 1);

		if (endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}

		boolean needPrev = true;
		boolean needNext = true;

		if (startNavi == 1) {
			needPrev = false;
		}
		if (endNavi == pageTotalCount) {
			needNext = false;
		}

		// 문자열을 조립해주는 클래스 (문자열 조립)
		StringBuilder sb = new StringBuilder();

		if (needPrev) {
			sb.append("<a href='/list.board?cpage=" + (startNavi - 1) + "'>< </a>");
		}
		for (int i = startNavi; i <= endNavi; i++) {
			sb.append("<a href='/list.board?cpage=" + i + "'>" + i + "<a> ");
		}
		if (needNext) {
			sb.append("<a href='/list.board?cpage=" + (endNavi + 1) + "'>> </a>");
		}

		// sb.toString(); > 모은 String을 축적하는 기능
		return sb.toString();
	}

	public int newFileseq () throws Exception{
		String sql="select * from board order by seq desc";
		try (Connection con = this.getConnection();
				PreparedStatement ppst = con.prepareStatement(sql);
				ResultSet rs = ppst.executeQuery()) {
			rs.next();
			int seq = rs.getInt("seq");
			
			return seq;
		}
	}
	
	
	
}
