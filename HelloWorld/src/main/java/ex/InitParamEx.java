package ex;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class InitParamEx
 */
@WebServlet(urlPatterns = { "/InitParamEx" }, initParams = { @WebInitParam(name = "dbId", value = "abcd"),@WebInitParam(name = "dbPwd", value = "123456789"),@WebInitParam(name = "dbSid", value = "orac") })
public class InitParamEx extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitParamEx() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doGet");

		request.setCharacterEncoding("UTF-8");

		String dbId = getInitParameter("dbId");
		String dbPwd = getInitParameter("dbPwd");
		String dbSid = getInitParameter("dbSid");
		// String testId = getInitParameter("testId");

		System.out.println("dbId : " + dbId + "| dbPwd : " + dbPwd + "| dbSid : " + dbSid);

		response.setContentType("text/html; charset-UTF-8");
		PrintWriter pw = response.getWriter();

		pw.println("<htmll>");
		pw.println("<head>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("dbId : " + dbId + "<br/>");
		pw.println("dbPwd : " + dbPwd + "<br/>");
		pw.println("dbSid : " + dbSid + "<br/>");
		pw.println("</body>");
		pw.println("</html>");

		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
