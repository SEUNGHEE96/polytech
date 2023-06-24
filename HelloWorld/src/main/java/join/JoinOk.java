package join;

import java.sql.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Servlet implementation class JoinOk
 */
@WebServlet("/join/JoinOk")
public class JoinOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String name, id, pw, phone1, phone2, phone3, gender;
	private String query;
	private Connection conn;
	private Statement stmt;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JoinOk() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
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

		name = request.getParameter("name");
		id = request.getParameter("id");
		pw = request.getParameter("pw");
		phone1 = request.getParameter("phone1");
		phone2 = request.getParameter("phone2");
		phone3 = request.getParameter("phone3");
		gender = request.getParameter("gender");

		query = "insert into member(name, id, pw, phone1, phone2, phone3, gender) values('" + name + "','" + id + "','"
				+ pw + "','" + phone1 + "','" + phone2 + "','" + phone3 + "','" + gender + "')";

		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@dinkdb_high?TNS_ADMIN=C:/SQLDEV/Wallet_DinkDB";
			String user = "DA2313";
			String passwd = "Data2313";

			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, passwd);

			stmt = conn.createStatement();
			int iResult = stmt.executeUpdate(query);

			if (iResult == 1) {
				System.out.println("insert success");
				System.out.println("id : " + id + "| pw : " + pw + "| name : " + name);
				response.sendRedirect("joinResult.jsp");
			} else {
				System.out.println("insert fail");
				response.sendRedirect("join.html");
			}

		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("join.html");
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
