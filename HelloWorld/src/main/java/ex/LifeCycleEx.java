package ex;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Servlet implementation class LifeCycleEx
 */
public class LifeCycleEx extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LifeCycleEx() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doGet");

		request.setCharacterEncoding("UTF-8");

		String dbId = getServletContext().getInitParameter("dbId");
		String dbPwd = getServletContext().getInitParameter("dbPwd");
		String dbSid = getServletContext().getInitParameter("dbSid");
		// String testId = getInitParameter("testId");

		System.out.println("dbId : " + dbId + " | dbPwd : " + dbPwd + "| dbSid : " + dbSid);

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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost");
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("init");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("destroy");
	}

	@PostConstruct
	private void PostConstructor() {
		// TODO Auto-generated method stub
		System.out.println("PostConstructor");
	}

	@PreDestroy
	private void PreDestroy() {
		// TODO Auto-generated method stub
		System.out.println("PreDestroy");
	}
}
