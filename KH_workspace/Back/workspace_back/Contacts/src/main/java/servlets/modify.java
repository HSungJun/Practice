package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContactsDAO;

@WebServlet("/modify")
public class modify extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ContactsDAO dao = ContactsDAO.getInstance();	
			
			int modId = Integer.parseInt(request.getParameter("modID"));
			String modname = request.getParameter("modName");
			String modcontact = request.getParameter("modContact");

			dao.modify(modId, modname, modcontact);
			
			response.sendRedirect("selectAll");
		}catch(Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
