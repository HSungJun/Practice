package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MessagesDAO;
import dto.MessagesDTO;

// WebServlet을 통한 요청 주소부분을 지움
// *을 통한 모든 기능을 받겠다 라는 의미 대입
// *. 

@WebServlet("*.message")
public class MessageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf8");

		String cmd = request.getRequestURI();
		// System.out.println(cmd);

		try {
			if (cmd.equals("/select.message")) {
				MessagesDAO dao = MessagesDAO.getInstance();
				List<MessagesDTO> result = dao.selectAll();
				request.setAttribute("list", result);

				request.getRequestDispatcher("list.jsp").forward(request, response);

			} else if (cmd.equals("/insert.message")) {
				String writer = request.getParameter("writer");
				String msg = request.getParameter("msg");

				MessagesDAO dao = MessagesDAO.getInstance();
				int result = dao.insert(writer, msg);

				response.sendRedirect("index.html");

			} else if (cmd.equals("/delete.message")) {
				int delid = Integer.parseInt(request.getParameter("delid"));
				MessagesDAO dao = MessagesDAO.getInstance();
				dao.delete(delid);
				response.sendRedirect("select.message");

			} else if (cmd.equals("/modify.message")) {
				MessagesDAO dao = MessagesDAO.getInstance();

				int modId = Integer.parseInt(request.getParameter("modID"));
				String modWriter = request.getParameter("modWriter");
				String modMessage = request.getParameter("modMessage");

				dao.modify(modId, modWriter, modMessage);

				response.sendRedirect("select.message");
			}

		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/rerror.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
