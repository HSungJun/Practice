package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Exam_01")
public class Exam_01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String msg = request.getParameter("msg");
		
		System.out.println("클라이언트가 입력한 메세지"+msg);
		PrintWriter resp = response.getWriter();
		resp.append(msg);
	}                                                                                                   

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("여기가 Post다제");
	}
	//client 의 요청에 따라 어떤 method가 실행되는지 정해짐 (get, post 둘중 하나.)
}
