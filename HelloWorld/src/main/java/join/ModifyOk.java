package join;

import java.sql.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class ModifyOk
 */
@WebServlet("/join/ModifyOk")
public class ModifyOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String name, id, pw, phone1, phone2, phone3, gender;
	private String query;
	private Connection conn;
	private Statement stmt;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyOk() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doGet");
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		System.out.println("doPost");
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");

		name = request.getParameter("name");
		pw = request.getParameter("pw");
		phone1 = request.getParameter("phone1");
		phone2 = request.getParameter("phone2");
		phone3 = request.getParameter("phone3");
		gender = request.getParameter("gender");

		query = "UPDATE MEMBER "
				+ "SET "
				+ "PW = '" + pw + "',"
				+ "NAME = '" + name + "',"
				+ "PHONE1 =  '" + phone1 + "',"
				+ "PHONE2 =  '" + phone2 + "',"
				+ "PHONE3 =  '" + phone3 + "',"
				+ "GENDER =  '" + gender + "' "
				+ "WHERE "
				+ "ID = '" + id + "'";
		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@192.168.119.119:1521/dink13";
			String user = "c##scott";
			String passwd = "tiger";

			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, passwd);

			stmt = conn.createStatement();
			int iResult = stmt.executeUpdate(query);

			if (iResult == 1) {
				System.out.println("update success");
	            session.setAttribute("pw", pw);
	            session.setAttribute("name", name);
	            session.setAttribute("phone1", phone1);
	            session.setAttribute("phone2", phone2);
	            session.setAttribute("phone3", phone3);
	            session.setAttribute("gender", gender);
				response.sendRedirect("modifyResult.jsp");
			} else {
				System.out.println("update fail");
				response.sendRedirect("modify.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("login.html");
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}