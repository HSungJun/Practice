package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.membersDAO;
import dto.membersDTO;

@WebServlet("*.members")
public class memberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf8");

		String cmd = request.getRequestURI();

		// /를 사용하면 절대경로 - 호출문서의 최상단 폴더에서 부터 검색
		// /를 사용하지 않으면 상대경로 - 호출되는 문서의 폴더위치의 경로 기준에서 검색 
		
		try {
			if (cmd.equals("/Login.members")) {
				String id = request.getParameter("id");
				String pw = request.getParameter("pw");

				membersDAO dao = membersDAO.getInstance();
				boolean result = dao.logIn(id, pw);

				System.out.println("사용자 " + id + " 의 로그인여부" + result);
				if (result == true) {
					// response.sendRedirect("/index.jsp?state=l_s");
					request.getSession().setAttribute("loginId", id);
					response.sendRedirect("/index.jsp?state=l_s");
				}
			} else if (cmd.equals("/Logout.members")) {
				request.setCharacterEncoding("utf8");
				request.getSession().invalidate();
				response.sendRedirect("/index.jsp");
				
			} else if (cmd.equals("/IdCheck.members")) {
				String id = request.getParameter("id");
				System.out.println("입력 id = " + id);

				membersDAO dao = membersDAO.getInstance();
				boolean result = dao.isIdExist(id);

				request.setAttribute("result", result);

				request.getRequestDispatcher("/member/isIdExist.jsp").forward(request, response);
				
				
				
			} else if (cmd.equals("/Out.members")) {
				membersDAO dao = membersDAO.getInstance();
				String id = (String) request.getSession().getAttribute("loginId");

				boolean result = dao.memberOut(id);

				if (result) {
					request.getSession().invalidate();
					response.sendRedirect("/index.jsp");
				}
			} else if (cmd.equals("/MyPage.members")) {
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

			} else if (cmd.equals("/SignIn.members")) {
				String id = request.getParameter("id");
				String pw = request.getParameter("pw");
				String name = request.getParameter("name");
				String phone = request.getParameter("phone");
				String email = request.getParameter("email");
				String zipcode = request.getParameter("zipcode");
				String address1 = request.getParameter("address1");
				String address2 = request.getParameter("address2");
				String join_date = request.getParameter("join_date");

				membersDAO dao = membersDAO.getInstance();

				int result = dao.signIn(id, pw, name, phone, email, zipcode, address1, address2);

				if (result != 0) {

					response.sendRedirect("/index.jsp?state=a_j");
					System.out.println(id + " 회원가입 완료");
				}

			} else if (cmd.equals("/update.members")) {
				String id = (String) request.getSession().getAttribute("loginId");
				String name = request.getParameter("name");
				String phone = request.getParameter("phone");
				String email = request.getParameter("email");
				String zipcode = request.getParameter("zipcode");
				String address1 = request.getParameter("address1");
				String address2 = request.getParameter("address2");

				membersDTO dto = new membersDTO(id, null, name, phone, email, zipcode, address1, address2, null);
				boolean result = membersDAO.getInstance().update(dto);
				response.sendRedirect("/MyPage");

				System.out.println("이름 " + name + " 수정결과 " + result);
			} else if(cmd.equals("/ToBoard.members")) {
				System.out.println("게시판으로..");
			}

		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/error.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
