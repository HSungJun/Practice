package MoviesDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DTO.MoviesDTO;

// manager > �����Ϳ� ���õ� ��� �۾��� �Ѱ��ϴ� Ŭ���� 
// DAO ��� ������ Data Access Object
// table���� DAO �� �ϳ��� ����

//DTO Data Transfer Object
// ������ ������ Ŭ���� / Value Object = �� ��ü ����� �Ҹ�.
public class MoviesDAO {

	// ���� ���� - throws Exception > �����߻��� ����ó������ ����. ���� �߻��� ���� �������� ���ư�. main�� ��� �����߻�

	private Connection getConnection() throws Exception {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbID = "kh";
		String dbPW = "kh";
		Connection con = DriverManager.getConnection(url, dbID, dbPW);
		return con;
	}

	public int insert(String title, String genre) throws Exception {

		// try catch : �ϳ� �̻��� ���ܰ� �߻��ϰ� �̸� ��� �Ѱ��� �������� ������ ���
		// try catch, catch, catch : ���� ������ ���ܵ��� �߻��� ��Ȳ�� ���� ���ܿ� ���� ���� ó���ؾ� �� ���
		// try finally : �����ڵ带 �Ϸ��ϰų� ���ܰ� �߻����� ��,�ݵ��(������) �����ؾ� �� �ڵ尡 �ִ°��
		// try catch finally :
		// try with resources : AutoClosseable�� ����� Ŭ������ ���Ͽ� ���� ����.

		try (Connection con = this.getConnection(); Statement stat = con.createStatement();) {

			String add_movie = "insert into movies values (movies_seq.nextval,'" + title + "','" + genre + "')";
			int result = stat.executeUpdate(add_movie);
			con.commit();
			return result;
		}

	}

	public int update(MoviesDTO dto) throws Exception {

		try (Connection con = this.getConnection(); Statement stat = con.createStatement();) {

			String update = "update movies set title = '" + dto.getTitle() + "', genre = '" + dto.getGenre()
					+ "' where id = " + dto.getId();
			int result = stat.executeUpdate(update);
			con.commit();
			return result;
		}
	}

	public int delete(int id) throws Exception {
		try (Connection con = this.getConnection(); Statement stat = con.createStatement();) {

			String del = "delete from movies where id = " + id;
			int result = stat.executeUpdate(del);
			con.commit();
			return result;
		}
	}

	public List<MoviesDTO> selectAll() throws Exception {
		try (Connection con = this.getConnection(); Statement stat = con.createStatement();) {

			String list = "select * from movies";
			ResultSet rs = stat.executeQuery(list);

			List<MoviesDTO> result = new ArrayList<>();

			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String genre = rs.getString("genre");

				MoviesDTO dto = new MoviesDTO(id, title, genre);
				result.add(dto);

			}
			return result;

		}
	}

	public List<MoviesDTO> search(String title) throws Exception {
		try (Connection con = this.getConnection(); Statement stat = con.createStatement();) {

			String search = "select * from movies where title like '%" + title + "%'";
			ResultSet rs = stat.executeQuery(search);

			List<MoviesDTO> result = new ArrayList<>();

			while (rs.next()) {
				int searchId = rs.getInt("id");
				String searchTitle = rs.getString("title");
				String searchGenre = rs.getString("genre");

				MoviesDTO dto = new MoviesDTO(searchId, searchTitle, searchGenre);
				result.add(dto);

			}
			return result;
		}
	}

	public boolean isIdExist(int id) throws Exception {
		try (Connection con = this.getConnection(); Statement stat = con.createStatement();) {

			String search = "select id from movies where id =" + id;
			ResultSet rs = stat.executeQuery(search);

			while (rs.next()) {
				int searchId = rs.getInt("id");
				if (searchId == id) {
					return true;
				}
			}
			return false;
		}
	}
}