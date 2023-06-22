package ex;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * Servlet implementation class FoamEx
 */
public class FoamEx extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoamEx() {
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
		
		/*
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String[] hobby = request.getParameterValues("hobby");

		String major = request.getParameter("major");
		String protocol = request.getParameter("major");
		*/
		Enumeration<String> names = request.getParameterNames();
		
		/*
		System.out.println("name : " + name + "| id : " + id + "| passwd : " + passwd);
		System.out.println("hobby : " + Arrays.toString(hobby));
		*/
		
		response.setContentType("text/html; charset-UTF-8");
		PrintWriter pw = response.getWriter();
		
		pw.println("<htmll>");
		pw.println("<head>");
		pw.println("</head>");
		pw.println("<body>");
		
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			String[] data = request.getParameterValues(name);
			
			if(data != null) {
				pw.println(name);
				for(String each : data) {
					pw.println(each);
				}
				pw.println("<br/>");
			}
		}
		/*
		pw.println("이름 : " + name + "<br/>");
		pw.println("아이디 : " + id + "<br/>");
		pw.println("비밀번호 : " + passwd + "<br/>");
		pw.println("취미 : " + Arrays.toString(hobby) + "<br/>");
		
		pw.println("전공 : " + major + "<br/>");
		pw.println("프로토콜 : " + protocol + "<br/>");
		*/
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost");
		
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String[] hobby = request.getParameterValues("hobby");
		
		System.out.println("name : " + name + "| id : " + id + "| passwd : " + passwd);
		System.out.println("hobby : " + Arrays.toString(hobby));
		
		response.setContentType("text/html; charset-UTF-8");
		PrintWriter pw = response.getWriter();
		
		pw.println("<htmll>");
		pw.println("<head>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("이름 : " + name + "<br/>");
		pw.println("아이디 : " + id + "<br/>");
		pw.println("비밀번호 : " + passwd + "<br/>");
		pw.println("취미 : " + Arrays.toString(hobby) + "<br/>");
		pw.println("</body>");
		pw.println("</html>");
		
		pw.close();
	}

}
