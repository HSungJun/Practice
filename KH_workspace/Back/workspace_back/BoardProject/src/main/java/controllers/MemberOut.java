package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import dao.membersDAO;

@WebServlet("/MemberOut")
public class MemberOut extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		try {
		
		membersDAO dao = membersDAO.getInstance();
		String id = (String) request.getSession().getAttribute("loginId");
		
			boolean result = dao.memberOut(id);
			
			if(result) {
				request.getSession().invalidate();
				response.sendRedirect("/index.jsp");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/erorr.jsp");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
