package controllers;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.FilesDAO;
import dto.FilesDTO;

@WebServlet("*.file")
public class FileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FilesDAO dao = FilesDAO.getInstance();
		String cmd = request.getRequestURI();
		System.out.println("요청된 URL : " + cmd);

		try {
			if (cmd.equals("/uploadForm.file")) {
				response.sendRedirect("/file/upload.jsp");

			} else if (cmd.equals("/upload.file")) {
				// request에 multipart/form-data 형태로 인코딩된 데이터가 전송됨 > request에 이러한 방식을 처리해 줄 수 있는
				// 라이브러리가 필요함.

				// 업로드된 파일을 다운로드 할 수 있도록 하기 위해선 보관하기 위한 폴더를 접근이 쉽도록 만들어준다.
				String realPath = request.getServletContext().getRealPath("upload");
				// servletContext = 맥락, 톰캣에서는 서버가 실행되는 환경
				// RealPath = 실제 경로
				System.out.println("경로: " + realPath);
				File realPathFile = new File(realPath);
				if (!realPathFile.exists()) {
					realPathFile.mkdir();
				} // 경로설정 및 폴더 없으면 만듬

				MultipartRequest multi = new MultipartRequest(request, realPath, 1024 * 1024 * 10, "utf8",
						new DefaultFileRenamePolicy());
				// 인코딩된 (어떤) request를 해석/해석한 파일을 realpath로 저장/ size 제한(byte단위) /utf8로 해석
				// /FileRenamePolicy 파일 이름 겹칠시 처리방법

				String message = multi.getParameter("message");
				System.out.println("전송된 메세지 : " + message);
				// seq

				// 업로드 시 원본의 이름 (입력 form의 name 속성)
				String oriName = multi.getOriginalFileName("file");

				// 업로드 되어 RenamePolicy 영향을 받은 후 이름
				String sysName = multi.getFilesystemName("file");
				// 두가지 정보를 모두 저장해 놓아야 이후 사용자가 재 다운로드를 받을 때에 다른 이름으로 변경되어 다운받지 않도록 하기 위해서.

				// parent_seq = n번 글에 담긴 파일이다.

				dao.insert(new FilesDTO(0, oriName, sysName, 0));

				response.sendRedirect("/");

			}else if (cmd.equals("/list.file")) {
				 List<FilesDTO> dto = dao.getInstance().select();
				 
				 request.setAttribute("list", dto);
				 request.getRequestDispatcher("/file/fileList.jsp").forward(request, response);
				 
			}

		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
