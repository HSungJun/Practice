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
import dto.boardDTO;
import dto.replyDTO;
import statics.Settings;

@WebServlet("*.board")
public class boardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf8");

		String cmd = request.getRequestURI();

		try {
			if (cmd.equals("/write.board")) {

				String writer = (String) request.getParameter("writer");
				String title = (String) request.getParameter("title");
				String contents = (String) request.getParameter("contents");
				int view_count = 0;

				System.out.println(writer + " " + title + " " + contents);

				int dao = boardDAO.getInstance().pushContent(writer, title, contents, view_count);

				if (dao != 0) {
					List<boardDTO> dto = boardDAO.getInstance().select();
					request.setAttribute("list", dto);
					request.getRequestDispatcher("/list.board?cpage=1").forward(request, response);

				} else {
					response.sendRedirect("/error.jsp");
				}

			} else if (cmd.equals("/list.board")) {
				
				
				int currentPage = Integer.parseInt(request.getParameter("cpage"));
				request.getSession().setAttribute("currentPage", currentPage);
				
				boardDAO dao = boardDAO.getInstance();
				String pageNavi = dao.getPageNavi(currentPage);
				
				
				//1페이지 일때 1,10 / 2페이지 일 때 11,20 
				// currentPage *10 = end
				// currentPage *10 -9 = start
				
				int start = currentPage * Settings.BOARD_RECORD_COUNT_PER_PAGE -(Settings.BOARD_RECORD_COUNT_PER_PAGE -1);
				int end = currentPage * Settings.BOARD_RECORD_COUNT_PER_PAGE;
				
				List<boardDTO> dto = boardDAO.getInstance().selectBound(start, end);
				request.setAttribute("list", dto);
				request.setAttribute("navi", pageNavi);
				request.getRequestDispatcher("/board/boardList.jsp?cpage=1").forward(request, response);

			} else if (cmd.equals("/contents.board")) {

				int seq = Integer.parseInt(request.getParameter("seq"));
				System.out.println("선택 글 번호 " + seq);

				boardDTO contentsValue = boardDAO.getInstance().contentsBySeq(seq);

				System.out.println("선택한 글 작성자, 제목, 내용 : " + contentsValue.getWriter() + " / " + contentsValue.getTitle()
						+ " / " + contentsValue.getContents());

				String loginId = (String) request.getSession().getAttribute("loginId");
				request.setAttribute("id", loginId);
				request.setAttribute("dto", contentsValue);
				
				replyDAO rdao = replyDAO.getInstance();
				List<replyDTO> rdto = rdao.listReplyByPa_seq(seq);
//				System.out.println(rdto.get(0).getParent_seq());
				
				request.setAttribute("replyList", rdto);
				
				
				request.getRequestDispatcher("/board/contents.jsp").forward(request, response);
				

			} else if (cmd.equals("/delete.board")) {

				int seq = Integer.parseInt(request.getParameter("seq"));
				System.out.println("삭제 글 번호 " + seq);

				int result = boardDAO.getInstance().delete(seq);
				if (result == 1) {
					List<boardDTO> dto = boardDAO.getInstance().select();
					request.setAttribute("list", dto);
					request.getRequestDispatcher("/list.board?cpage=1").forward(request, response);
				
				} else {
					response.sendRedirect("/error.jsp");
				}
			
			} else if (cmd.equals("/modify.board")) {
				int seq = Integer.parseInt(request.getParameter("seq"));
				System.out.println("수정 글 번호 " + seq);
				
				String title = request.getParameter("title");
				String contents = request.getParameter("contents");
				
				System.out.println(seq+" "+title+" "+contents);
				
				int result = boardDAO.getInstance().modify(seq, title, contents);
				
				List<boardDTO> dto = boardDAO.getInstance().select();
				request.setAttribute("list", dto);
				request.getRequestDispatcher("/contents.board?seq="+seq).forward(request, response);
			
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
