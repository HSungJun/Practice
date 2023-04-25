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

import dto.FilesDTO;

public class FilesDAO {

	private FilesDAO() {
	};

	private static FilesDAO instance = null;

	public synchronized static FilesDAO getInstance() {
		if (instance == null) {
			instance = new FilesDAO();
		}
		return instance;
	};

	private Connection getConnection() throws Exception {
		Context iCtx = new InitialContext();
		DataSource ds = (DataSource) iCtx.lookup("java:/comp/env/jdbc/ora");
		return ds.getConnection();
	};

	public int insert(FilesDTO dto) throws Exception {
		String sql = "insert into files values(files_seq.nextval,?,?,?)";
		try (Connection con = this.getConnection(); PreparedStatement ppst = con.prepareStatement(sql);) {
			ppst.setString(1, dto.getOriName());
			ppst.setString(2, dto.getSysName());
			ppst.setInt(3, dto.getParent_seq());
			int result = ppst.executeUpdate();
			con.commit();
			return result;
		}
	};

	public List<FilesDTO> select() throws Exception {
		String sql = "select * from files order by 1";
		try (Connection con = this.getConnection();
				PreparedStatement ppst = con.prepareStatement(sql);
				ResultSet rs = ppst.executeQuery();) {
			// ResultSet은 활성화 중에만 사용 가능. 닫히기 전에 List에 담아 사용함.
			List<FilesDTO> result = new ArrayList<>();
			while (rs.next()) {
				int seq = rs.getInt("seq");
				String oriName = rs.getString("oriname");
				String sysName = rs.getString("sysname");
				int parent_seq = rs.getInt("parent_seq");

				FilesDTO dto = new FilesDTO(seq, oriName, sysName, parent_seq);
				result.add(dto);
			}
			return result;
		}
	};

	public FilesDTO selectByParent_seq(int seq) throws Exception {
		String sql = "select * from files where parent_seq = ?";
		try (Connection con = this.getConnection(); PreparedStatement ppst = con.prepareStatement(sql);) {
			ppst.setInt(1, seq);
			try (ResultSet rs = ppst.executeQuery();) {
				if (rs.next()) {
					int fseq = rs.getInt("seq");
					String fOriName = rs.getString("oriname");
					String fSysName = rs.getString("sysname");
					int fParent_seq = rs.getInt("parent_seq");

					FilesDTO dto = new FilesDTO(fseq,fOriName,fSysName,fParent_seq);

					return dto;
				}
				return null;
			}
		}
	}
	
	
	
}
	





