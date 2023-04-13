
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		File dir = new File("C:\\Workspace\\file_test\\src\\main\\webapp\\WEB-INF\\files");
		File[] files = dir.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.toLowerCase().endsWith(".mkv");
			}
		});
		List<String> fileNameList = new ArrayList<String>();
		System.out.println("<list>");
		for (int i = 0; i < files.length; i++) {
			fileNameList.add(files[i].getName());
			System.out.println(files[i].getName());
		}
		System.out.println("</list>");
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/ListPage.jsp");
		request.setAttribute("list", fileNameList);
		rd.forward(request, response);
	}

}
