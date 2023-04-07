package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.membersDAO;

/**
 * Servlet implementation class IdCheck
 */
@WebServlet("/IdCheck")
public class IdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String id = request.getParameter("id");
		System.out.println(id);
		
		membersDAO dao = membersDAO.getInstance();
		boolean result = dao.isIdExist(id);
		
		request.setAttribute("result", result);
		
		request.getRequestDispatcher("/member/isIdExist.jsp").forward(request, response);
		
		
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
