package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.boardDAO;
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
			try {
				int re_seq = Integer.parseInt(request.getParameter("re_seq"));
				int re_pa_seq = Integer.parseInt(request.getParameter("re_pa_seq"));
				System.out.println("삭제할 댓글 seq"+re_seq);
				
				int result = replyDAO.getInstance().deleteReply(re_seq);
				
				if(result==0) {
					System.out.println(re_seq +"댓글 삭제 실패");
				}else {
					System.out.println(re_seq +"댓글 삭제 성공");
				}
				
				response.sendRedirect("/contents.board?seq="+re_pa_seq);
				
			}catch(Exception e) {
				e.printStackTrace();
				response.sendRedirect("error.jsp");
			}

		}else if(cmd.equals("/update.reply")){
			try {
				String upRe_contents = (String) request.getParameter("re_li_contents");
				int upRe_li_seq = Integer.parseInt(request.getParameter("re_seq"));
				int pa_seq = Integer.parseInt(request.getParameter("re_pa_seq"));
				System.out.println(upRe_contents+" /// "+upRe_li_seq);
				
				
				replyDAO dao = replyDAO.getInstance();
				int result = dao.updateReply(upRe_contents,upRe_li_seq);
				
				if(result==0) {
					System.out.println(upRe_li_seq + " 수정 실패");
				}else {
					System.out.println(upRe_li_seq + " 수정 완료");
				}
				
				response.sendRedirect("/contents.board?seq="+pa_seq);
				
			}catch(Exception e) {
				e.printStackTrace();
				response.sendRedirect("error.jsp");
			}
		}
}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	doGet(request, response);
}

}
