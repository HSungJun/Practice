package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.replyDAO;
import dto.replyDTO;
@WebServlet("*.reply")
public class replyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");


		String cmd = request.getRequestURI();

		if(cmd.equals("/write.reply")) {
			try {
			String re_writer = (String) request.getParameter("re_writer");
			String re_contents = (String) request.getParameter("re_contents");
			int pa_seq = Integer.parseInt(request.getParameter("seq"));
			
			System.out.println("댓글작성"+ re_writer +":"+ re_contents + ":" + pa_seq);
			
			replyDAO dao = replyDAO.getInstance();
			dao.addReply(re_writer, re_contents, pa_seq);
			
			response.sendRedirect("/contents.board?seq="+pa_seq);
				
			} catch (Exception e) {
				e.printStackTrace();
				response.sendRedirect("error.jsp");
			}
			
		}else if(cmd.equals("/delete.reply")) {

		}else if(cmd.equals("/update.reply")){
			
		}
}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	doGet(request, response);
}

}
