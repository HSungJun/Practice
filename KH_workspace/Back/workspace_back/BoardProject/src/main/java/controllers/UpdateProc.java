package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.membersDAO;
import dto.membersDTO;
@WebServlet("/UpdateProc")
public class UpdateProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF8");
		
		try {
			String id = (String)request.getSession().getAttribute("loginId");
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String zipcode = request.getParameter("zipcode");
			String address1 = request.getParameter("address1");
			String address2 = request.getParameter("address2");
			
			membersDTO dto = new membersDTO(id,null,name,phone,email,zipcode,address1,address2,null);
			boolean result = membersDAO.getInstance().update(dto);
			response.sendRedirect("/MyPage");
			
			
			System.out.println("수정결과" + result);
			
		}catch(Exception e) {
			e.printStackTrace();
			response.sendRedirect("/error.jsp");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
