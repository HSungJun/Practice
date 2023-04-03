package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insdertMsg")
public class insdertMsg extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String writer = request.getParameter("writer");
		String msg = request.getParameter("msg");
		
		System.out.println("작성자명 : "+ writer +", 메세지 내용 : "+ msg);
		
		
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "kh";
		String pw = "kh";
		Connection con = DriverManager.getConnection(url, id, pw);
		
		String sql = "insert into ";
		PreparedStatement pst = con.prepareStatement(sql);
		
		Resultset rs = pst.executeQuery();
		
		
				
		
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter resp = response.getWriter();
		resp.append("메세지 송출 완료");
		

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
