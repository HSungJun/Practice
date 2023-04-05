package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContactsDAO;
import dto.ContactsDTO;

@WebServlet("/selectAll")
public class selectAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		response.setContentType("text/html; charset=UTF-8");
		
		ContactsDAO dao = new ContactsDAO();
		
		PrintWriter pw = response.getWriter();

		pw.append("<html>");
		pw.append("<head>");
		pw.append("<script src=\"https://code.jquery.com/jquery-3.6.4.min.js\"></script>");
		pw.append("</head>");
		pw.append("<body>");

		pw.append("<table border ='1' align = 'center'>");
		pw.append("<tr><th>id</th><th>name</th><th>contact</th></tr>");

		List<ContactsDTO> list = dao.selectAll();	
		for(int i = 0; i<list.size(); i++) {
			int id = list.get(i).getId();
			String name = list.get(i).getName();
			String contact= list.get(i).getContact();
			pw.append("<tr>");
			pw.append("<td>"+id+"</td>");
			pw.append("<td>"+name+"</td>");
			pw.append("<td>"+contact+"</td>");
			pw.append("</tr>");
		}
		
		pw.append("<form action='modify' method='get'>");
		pw.append("<tr>");
		pw.append("<td colspan='3'>");
		pw.append("<input type='text' placeholder='Input id to modify' name='modID'>");
		pw.append("<input type='text' placeholder='Input writer to modify' name='modName'>");
		pw.append("<input type='text' placeholder='Input message to modify' name='modContact'>");
		pw.append("<button type='submit'>Modify</button>");
		pw.append("</td>");
		pw.append("</tr>");
		pw.append("</form>");
		
		pw.append("<form action='delete' method='get'>");
		pw.append("<tr>");
		pw.append("<td colspan='3'>");
		pw.append("<input type='text' name='delid' id='text' placeholder='input delete id'> <button>delete</button>");
		pw.append("</td>");
		pw.append("</tr>");
		pw.append("</form>");
		pw.append("<tr><td align='center' colspan='3'><a href='index.html'>Back</a></td></tr>");
		pw.append("</table>");
		
		pw.append("</body>");
		pw.append("</html>");
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
