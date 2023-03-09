package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DTO.StudentDTO;











public class StudentDAO {

	private Connection getConnection() throws Exception {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbID = "kh";
		String dbPW = "kh";
		Connection con = DriverManager.getConnection(url, dbID, dbPW);
		return con;
	}
	
	
	
	

	public int addStudent(String name, int kor, int eng, int math) throws Exception {
			
		Connection con = this.getConnection();
		Statement stat = con.createStatement();

		String addStudent = "insert into students values(students_seq.nextval, '" 
						+ name + "'," + kor + "," + eng + ","+ math+")";
		int result = stat.executeUpdate(addStudent);
		con.commit();
		con.close();
		return result;
	}

	public List<StudentDTO> searchAll() throws Exception {
		Connection con = this.getConnection();
		Statement stat = con.createStatement();

		String searchAll = "select * from students";
		ResultSet rs = stat.executeQuery(searchAll);

		List<StudentDTO> result = new ArrayList<>();

		while (rs.next()) {
			int searchId = rs.getInt("id");
			String searchName = rs.getString("name");
			int searchKor = rs.getInt("kor");
			int searchEng = rs.getInt("eng");
			int searchMath = rs.getInt("math");

			StudentDTO dto = new StudentDTO(searchId, searchName, searchKor, searchEng, searchMath);
			result.add(dto);

		}

		con.close();
		return result;
	}

	public int deleteStudent(int id) throws Exception {
		Connection con = this.getConnection();
		Statement stat = con.createStatement();

		String deleteStudent = "delete from students where id = " + id;

		int result = stat.executeUpdate(deleteStudent);
		con.commit();
		con.close();
		return result;
	}
	
	public int updateStudent (StudentDTO dto) throws Exception {
		Connection con = this.getConnection();
		Statement stat = con.createStatement();
		
		String updateStudent = "update students set name = '" +dto.getName()+ "',kor = " +
						dto.getKor()+ ",eng = " +dto.getEng()+ ", math = " +dto.getMath();
		
		int result = stat.executeUpdate(updateStudent);
		con.commit();
		con.close();
		return result;
	}
	
	public boolean isIdExist (int id) throws Exception{
		Connection con = this.getConnection();
		Statement stat = con.createStatement();
		
		String searchId = "select id from students where id = "+id;
		ResultSet rs = stat.executeQuery(searchId);
		
		while(rs.next()) {
			int search = rs.getInt("id");
			if (search == id) {
				return true;
			}
		}
	return false;
	}
	
	
	
	public List<StudentDTO> searchName (String name) throws Exception{
		Connection con = this.getConnection();
		Statement stat = con.createStatement();

		String searchAll = "select * from students where name like '%"+name+"%'";
		ResultSet rs = stat.executeQuery(searchAll);

		List<StudentDTO> result = new ArrayList<>();

		while (rs.next()) {
			int searchId = rs.getInt("id");
			String searchName = rs.getString("name");
			int searchKor = rs.getInt("kor");
			int searchEng = rs.getInt("eng");
			int searchMath = rs.getInt("math");

			StudentDTO dto = new StudentDTO(searchId, searchName, searchKor, searchEng, searchMath);
			result.add(dto);

		}

		con.close();
		return result;
	
	}
	
	
	
	
//	public String findById (int id) throws Exception{
//		Connection con = this.getConnerction();
//		Statement stat = con.createStatement();
//		
//		String findById = "select * from students where id = "+id;
//		ResultSet rs = stat.executeQuery(findById);
//		
//		String result = new String();
//		
//		con.close();
//		return result;
//	}
	
}
