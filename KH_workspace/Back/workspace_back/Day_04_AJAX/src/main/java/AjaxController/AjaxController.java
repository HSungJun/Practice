package AjaxController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import dto.ContactDTO;

@WebServlet("*.ajax")
public class AjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getRequestURI();
		Gson g = new Gson();
		
		if(cmd.equals("/exam01.ajax")){
			System.out.println("비동기 통신 요청 확인");
		}else if (cmd.equals("/exam02.ajax")) {
			String fruit = request.getParameter("fruit");
			String music = request.getParameter("music");
			
			System.out.println(fruit+":"+music);
		}else if (cmd.equals("/exam03.ajax")) {
			
			response.getWriter().append("Hello AJAX");
			
		}else if (cmd.equals("/exam04.ajax")) {
			
			String[] arr = new String[] {"Apple","Orange","Mango"};
			
			String resp = g.toJson(arr);
			
			response.getWriter().append(resp);
		}else if (cmd.equals("/exam05.ajax")) {
			
			ContactDTO dto = new ContactDTO(100,"Ryan","01012344321");
			
			String resp = g.toJson(dto);
			
			response.getWriter().append(resp);
			//dto를 Javascript가 알아 볼 수 있는 데이터 형태로 직렬화 시켜야 함. ()로 객체 타입으로 전환함.
			
			   
		}else if (cmd.equals("/exam06.ajax")) {
			
			List<ContactDTO> list = new ArrayList<>();
					list.add(new ContactDTO(1000,"Tom","01012344321"));
					list.add(new ContactDTO(1001,"Ryan","01012345431"));
					list.add(new ContactDTO(1002,"becket","01012345321"));
			
			String resp = g.toJson(list);
			response.getWriter().append(resp);
			
			
		}else if (cmd.equals("/exam07.ajax")) {
			
			String[] arr = new String[] {"Apple","Orange","Mango"};
			ContactDTO dto = new ContactDTO(100,"Ryan","01012344321");

			
			String arrJson = g.toJson(arr);
			String dtoJson = g.toJson(dto);
			
			JsonObject resp = new JsonObject();
			
			resp.addProperty("arr", arrJson);
			resp.addProperty("dto", dtoJson);
//			{addProperty 를 통해 이런 식으로 데이터를 정령함.
//				arr:[---],
//				dto:{---}
//				> arr 과 dto 는 역직렬화가 되었으나 안에 데이터는 역직렬화가 안됨.
//			}
			
			response.getWriter().append(resp.toString());
			
		}
	
	
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
