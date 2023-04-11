package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.membersDAO;
@WebServlet("/LoginServLet")
public class LoginServLet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		try {
		membersDAO dao = membersDAO.getInstance();
		boolean result = dao.logIn(id, pw);
		
		System.out.println("로그인여부"+ result);
		if (result==true) {
//			response.sendRedirect("/index.jsp?state=l_s");
			request.getSession().setAttribute("loginId", id);
			// 세션에는 사용자별로 개별 보관함(session)이 있으며, 보관함 내에 MAP이라는 것이 있음.
			// 세션키는 금고를 여는 키, 밸류까지만 사용
			// 금고 내 JSON 내부에 저장되는 키 밸류와는 별개.
			// 로그인시 세션에 정보를 저장해야하는데 loginId 는 id라는 정보의 키값(이름)으로 id 또는 loginId 둘다 아무거나 저장해도 무관.
			// 세션키, 밸류를 입력하고 끝 - response에 담아보냄.
			response.sendRedirect("/index.jsp?state=l_s");
		} 
		else {
		response.sendRedirect("/index.jsp?state=l_sf");
		}
		
		}catch(Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
