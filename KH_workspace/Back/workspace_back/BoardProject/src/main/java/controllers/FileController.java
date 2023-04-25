package controllers;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
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

			}else if (cmd.equals("/download.file")) {

				//한글이름 등은 깨지는 경우가 존재. > 인코딩해주어야함
				String oriName = request.getParameter("oriName");
				
				//chrome의 경우 이런식으로 인코딩.
				oriName = new String(oriName.getBytes("utf8"),"ISO-8859-1");
				
				
				response.reset();
				//브라우저에 출력하는것이아닌 client에게 렌더링이아닌 다운로드 받을 수 있도록 설정해줌
				response.setHeader("Content-Disposition", "attachment;filename="+oriName);
				//Contents-Disposition 설정값을 attachment(첨부파일)로 바꾸고 다운로드되는 파일이름을 바꾸어준다.
				
				
				//서버에서 파일을 올려 client에게 다운로드 받을 수 있도록 전송해야함.
				String uploadPath = request.getServletContext().getRealPath("upload");
				String sysName = request.getParameter("sysName");

				//파일 객체 생성
				File target = new File(uploadPath+"/"+sysName);
				
				//client에게 파일을 전송해주어야함.
				try(
						ServletOutputStream sos = response.getOutputStream();
						//파일업로드를 위해 리얼패스 위치와 파일 이름을 입력
						FileInputStream fis = new FileInputStream(target);
						DataInputStream dis = new DataInputStream(fis);

						){
					//파일 사이즈 만큼의 byte 배열을 만들어줌
					byte[] fileContents = new byte[(int)target.length()];
					dis.readFully(fileContents);
					sos.write(fileContents);
					sos.flush();
				}


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
