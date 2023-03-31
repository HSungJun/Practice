package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.MoviesDTO;

// 데이터와 관련된 모든 작업을 총괄하는 클래스
// DAO : Data Access Object

// Scanner 역시 close가 가능한데 finally나 try with Resource로 처리해주면 좋을까요??

public class MoviesDAO {

	private Connection getConnection() throws Exception{
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbID = "kh";
		String dbPW = "kh";
		Connection con = DriverManager.getConnection(url, dbID, dbPW);
		return con;
	}

	public int insert(String title, String genre) throws Exception{
		String sql = "insert into movies values(movies_seq.nextval,?,?)";
		try(Connection con  = this.getConnection();	
				PreparedStatement pstat = con.prepareStatement(sql)){
			pstat.setString(1, title);
			pstat.setString(2, genre);
			int result = pstat.executeUpdate();	
			con.commit();							
			return result;
		}
	}

	public int update(MoviesDTO dto) throws Exception{
		String sql = "update movies set title = ?, genre = ? where id = ?";
		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql)){
			pstat.setString(1, dto.getTitle());
			pstat.setString(2, dto.getGenre());
			pstat.setInt(3, dto.getId());

			int result = pstat.executeUpdate();
			con.commit();
			con.close();
			return result;
		}
	}

	public int delete(int id) throws Exception {
		String sql = "delete from movies where id = ?";
		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setInt(1, id);
			int result = pstat.executeUpdate();
			con.commit();
			con.close();
			return result;
		}
	}
	public List<MoviesDTO> selectAll() throws Exception{
		String sql = "select * from movies";
		try(
				Connection con = this.getConnection();
				Statement stat = con.createStatement();
				ResultSet rs = stat.executeQuery(sql);
				){
			List<MoviesDTO> result = new ArrayList<>();
			while(rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String genre = rs.getString("genre");

				MoviesDTO dto = new MoviesDTO(id,title,genre);
				result.add(dto);
			}
			con.close();
			return result;
		}
	}
	public List<MoviesDTO> searchByTitle(String target) throws Exception{

		String sql = "select * from movies where title like ?";

		try(Connection con = this.getConnection();
			PreparedStatement stat = con.prepareStatement(sql);){
			stat.setString(1, "%"+target+"%");
			try(ResultSet rs = stat.executeQuery();){
				List<MoviesDTO> result = new ArrayList<>();
				while(rs.next()) {
					int id = rs.getInt("id");
					String title = rs.getString("title");
					String genre = rs.getString("genre");

					MoviesDTO dto = new MoviesDTO(id,title,genre);
					result.add(dto);
				}
				con.close();
				return result;
			}
		}
	}

	public boolean isIdExist(int id) throws Exception{
		Connection con = this.getConnection();
		Statement stat = con.createStatement();
		String sql = "select * from movies where id = " + id;
		ResultSet rs = stat.executeQuery(sql);
		boolean result = rs.next();
		con.close();
		return result;
	}
}













