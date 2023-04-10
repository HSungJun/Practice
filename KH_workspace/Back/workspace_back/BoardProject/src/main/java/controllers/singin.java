package controllers;

import java.awt.Window;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.membersDAO;
@WebServlet("/singin")
public class singin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String zipcode = request.getParameter("zipcode");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String join_date = request.getParameter("join_date");
		
		try {
			membersDAO dao = membersDAO.getInstance();
			
			int result = dao.signIn(id, pw, name, phone, email, zipcode, address1, address2);
			
			if(result != 0) {

			response.sendRedirect("/index.jsp?state=a_j");
			}
			
			// http 상태정보를 기억하지 않는 프로토콜 (Stateless)
			// 서버와 클라이언트간의 리퀘스트, 리스폰스를 받은 이후 연결이 끊겨 정보가 저장되지 않음 - client 각각의 정보를 저장하지 않음
			// 쿠키 (cookie) 클라이언트의 로그인 > 로그인 완료시 쿠키파일을 만들어 response에 담아 보냄.
			// 쿠키의 정보를 통해 로그인 여부의 데이터를 가지고 있는 것을 server에서 확인.
			// 쿠키 하이재킹(cookie hijacking) == 해킹
			// 쿠키의 보안성 이슈로 인한 사용성 저하
			// 서버에 특정 저장소에 클라이언트에 관한 정보 보관. (남기고싶은 정보를 저장) 정보를 확인할 수 있는 키를 만들어 response에 담아 
			// client에게 보냄.
			// 키를 browser가 사용하는 ram 속에 저장됨. 세션(session), sessionKey 
			// session 은 한번 저장하면 모든 페이지에서 사용 가능하다. 로그인 전용이아닌 특정 데이터 저장용.
			// 쿠키는 한피씨한정. session은 로그아웃하면 사라짐. DB에 저장하면 어디서든 사용가능.
			
			
		}catch(Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
		
		
		
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
