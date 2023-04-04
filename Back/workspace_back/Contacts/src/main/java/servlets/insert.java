package servlets;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContactsDAO;

@WebServlet("/insert")
public class insert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		String name = request.getParameter("name");
		String contact = request.getParameter("contact");
		
		try{
		ContactsDAO dao = new ContactsDAO();

		int result = dao.insert(name, contact);
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		//			response.sendRedirect("succes.html"); 다른페이지로 이동할때 사용하는 명령
		PrintWriter resp = response.getWriter();
		resp.append("<html>");
		resp.append("<head>");
		resp.append("</head>");
		resp.append("<body>");
		resp.append("<button id='toIndex'>");
		resp.append("to Index..");
		resp.append("</button>");
		resp.append("<script>");
		resp.append("alert('Insert complete');");
		resp.append("document.getElementById('toIndex').onclick = function(){location.href='index.html'}");
		resp.append("</script>");
		resp.append("</body>");
		resp.append("</html>");

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
