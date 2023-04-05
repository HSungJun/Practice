package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MessagesDAO;
import dto.MessagesDTO;

@WebServlet("/modifyMsg")
public class modifyMsg extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			MessagesDAO dao = MessagesDAO.getInstance();	
//			MessagesDTO dto = new MessagesDTO();
			
			int modId = Integer.parseInt(request.getParameter("modID"));
			String modWriter = request.getParameter("modWriter");
			String modMessage = request.getParameter("modMessage");

			dao.modify(modId, modWriter, modMessage);
			
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
