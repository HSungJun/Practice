package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MessagesDAO;
@WebServlet("/deleteMsg")
public class deleteMsg extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int delid = Integer.parseInt(request.getParameter("delid"));
//		System.out.println(delid);
		try {
		MessagesDAO dao = new MessagesDAO();	
		dao.delete(delid);
		response.sendRedirect("SelectMsg");
		}catch(Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
	
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
