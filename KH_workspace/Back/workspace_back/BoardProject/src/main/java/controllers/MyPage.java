package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.membersDAO;
import dto.membersDTO;
@WebServlet("/MyPage")
public class MyPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		try {
		
		membersDAO dao = membersDAO.getInstance();
		String id = (String) request.getSession().getAttribute("loginId");
		
		membersDTO mpdto = dao.getMyInfo(id);
		
		String getid = mpdto.getId();
		String getname = mpdto.getName();
		String getphone = mpdto.getPhone();
		String getemail = mpdto.getEmail();
		String getzip = mpdto.getZipcode();
		String getadd1 = mpdto.getAddress1();
		String getadd2 = mpdto.getAddress2();
		
		request.setAttribute("id", getid);
		request.setAttribute("name", getname);
		request.setAttribute("phone", getphone);
		request.setAttribute("email", getemail);
		request.setAttribute("zip", getzip);
		request.setAttribute("add1", getadd1);
		request.setAttribute("add2", getadd2);
		
		request.getRequestDispatcher("/member/list.jsp").forward(request, response);
		
		}catch(Exception e) {
			e.printStackTrace();
			response.sendRedirect("/error.jsp");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
