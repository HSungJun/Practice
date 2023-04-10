package servlets;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MessagesDAO;

@WebServlet("/insertMsg")
public class insertMsg extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		String writer = request.getParameter("writer");
		String msg = request.getParameter("msg");
		
		try{
			MessagesDAO dao = MessagesDAO.getInstance();	
			int result = dao.insert(writer, msg);
			
//			response.sendRedirect("index.html");
			
			//페이지를 jsp로 전환하여 실행해야함
//			response.sendRedirect("");
			// ---- 연결을 종료하고 페이지를 전환해야함 > response.sendRedirect 는 데잍터를 가져갈 수 없음.
//			request.getRequestDispatcher("insertView.jsp").forward(request, response);
			//forward - 페이지 전환.(데이터를 저장하고 페이지 전환.) > MVC2 로 전환하기 위해 프론트 페이지는 jsp에 작성.
			//보낼 데이터가 있는 경우 forward / 데이터가 없음 sendRedirect 로 페이지 전환

			//redirect는 서버에서 클라이언트에게 페이지를 다시 요청하도록 하여 request가 새로 생성되어 데이터를 유지하지 못함
			//forward의 경우 서버가 클라이언트에게 보여줄 페이지를 직접 찾아 바꾸어 데이터를 유지한 상태로 직접 페이지를 변경시킴 
			
			
			//jsp로 보내서 작성함.
//		PrintWriter resp = response.getWriter();
//		resp.append("<html>");
//		resp.append("<head>");
//		resp.append("</head>");
//		resp.append("<body>");
//		resp.append("<button id='toIndex'>");
//		resp.append("to Index..");
//		resp.append("</button>");
//		resp.append("<script>");
//		resp.append("alert('Insert complete');");
//		resp.append("document.getElementById('toIndex').onclick = function(){location.href='index.html'}");
//		resp.append("</script>");
//		resp.append("</body>");
//		resp.append("</html>");
		
		}catch(Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
		//			response.sendRedirect("succes.html"); 다른페이지로 이동할때 사용하는 명령
		

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
