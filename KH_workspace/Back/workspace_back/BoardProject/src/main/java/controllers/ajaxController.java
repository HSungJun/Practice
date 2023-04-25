package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.tools.DocumentationTool.Location;

import com.google.gson.Gson;

import dao.membersDAO;
@WebServlet("*.ajax")
public class ajaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getRequestURI();
		Gson g = new Gson();
		
		try {
		if(cmd.equals("/IdCheck.ajax")) {
			System.out.println("idCheckajax로");
			String id = request.getParameter("id");
			System.out.println("입력 id = " + id);
			
			membersDAO dao = membersDAO.getInstance();
			boolean result = dao.isIdExist(id);
			
			String resp = g.toJson(result);
			response.getWriter().append(resp);
			System.out.println("resp는 "+resp);
			
		}
		}catch(Exception e) {
			e.printStackTrace();
			response.sendRedirect("/error.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
