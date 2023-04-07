package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MessagesDAO;
import dto.MessagesDTO;

@WebServlet("/SelectMsg")
public class SelectMsg extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		try {
		MessagesDAO dao = MessagesDAO.getInstance();	
		
		// jsp에서 목록을 출력하기 위해서는 result List가 필요함.
		List<MessagesDTO> result = dao.selectAll();
		
		String[] arr = new String[] {"EL", "JSTL","PRACTICE"};
		MessagesDTO dto = new MessagesDTO(358, "tester", "DTO EL연습");
		
		request.setAttribute("number",100);
		request.setAttribute("string","Hello JSP");
		request.setAttribute("arr",arr);
		request.setAttribute("dto",dto);
		
		//request에 list 라는 키값에 result를 담아보냄.
		request.setAttribute("list", result);
		
		request.getRequestDispatcher("list.jsp").forward(request, response);
		// forward에 매개변수가 있는 이유는 list.jsp 로 정보를 전달하기 위해서.
		
		
		
		}catch(Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
	}
}




//		PrintWriter pw = response.getWriter();
//		pw.append("<html>");
//		pw.append("<head>");
//		pw.append("<script src=\"https://code.jquery.com/jquery-3.6.4.min.js\"></script>");
//		pw.append("</head>");
//		pw.append("<body>");
//
//		pw.append("<table border ='1' align = 'center'>");
//		pw.append("<tr><th>id</th><th>writer</th><th>message</th></tr>");
//		
//		//message id 작성자 내용 출력
//		List<MessagesDTO> list = dao.selectAll();	
//		for(int i = 0; i<list.size(); i++) {
//			int id = list.get(i).getId();
//			String writer = list.get(i).getWriter();
//			String message = list.get(i).getMessage();
//			pw.append("<tr>");
//			pw.append("<td>"+id+"</td>");
//			pw.append("<td>"+writer+"</td>");
//			pw.append("<td>"+message+"</td>");
//			pw.append("</tr>");
//			
//		}
//		
////		for(MessagesDTO m : list) {
////			pw.append("<tr><td class='ids'>" + m.getId() + "</td><td>" + m.getWriter() + "</td><td>" + m.getMessage() + "</td></tr>");
////		}
//		
//		//update를 위한 UI
//		
//		pw.append("<form action='modifyMsg' method='get'>");
//		pw.append("<tr>");
//		pw.append("<td colspan='3'>");
//		pw.append("<input type='text' placeholder='Input id to modify' name='modID'>");
//		pw.append("<input type='text' placeholder='Input writer to modify' name='modWriter'>");
//		pw.append("<input type='text' placeholder='Input message to modify' name='modMessage'>");
//		pw.append("<button type='submit'>Modify</button>");
//		pw.append("</td>");
//		pw.append("</tr>");
//		pw.append("</form>");
//		
//		pw.append("<form action='deleteMsg' method='get'>");
//		pw.append("<tr>");
//		pw.append("<td colspan='3'>");
//		pw.append("<input type='text' name='delid' id='text' placeholder='input delete id'> <button>delete</button>");
//		pw.append("</td>");
//		pw.append("</tr>");
//		pw.append("</form>");
//		pw.append("<tr><td align='center' colspan='3'><a href='index.html'>Back</a></td></tr>");
//		pw.append("</table>");
//
//		
//		pw.append("</body>");
//		pw.append("</html>");