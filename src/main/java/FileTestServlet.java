
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/fileTest" })
public class FileTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 리스트에서 다운로드 할 파일을 클릭한 이름 가져오기
		String fileName = request.getParameter("fileName").toString();
		System.out.println(fileName);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/" + fileName);

		// 파일명대로 다운로드 헤더 설정
		response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
		rd.forward(request, response);

	}

}
