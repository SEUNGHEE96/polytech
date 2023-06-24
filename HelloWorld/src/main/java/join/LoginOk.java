package join;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Servlet implementation class LoginOk
 */
@WebServlet("/join/LoginOk")
public class LoginOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String id, pw;
	private String query;
	private Connection conn;
	private Statement stmt;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginOk() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doGet");
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		System.out.println("doPost");
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		id = request.getParameter("id");
		pw = request.getParameter("pw");

		query = "select * from member where id = '" + id + "'";
		
		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@dinkdb_high?TNS_ADMIN=C:/SQLDEV/Wallet_DinkDB";
			String user = "DA2313";
			String passwd = "Data2313";

			Class.forName(driver);			
			Connection conn = DriverManager.getConnection(url, user, passwd);

			stmt = conn.createStatement();
			ResultSet rs = null;
			rs = stmt.executeQuery(query);

			if(rs.next()) {
			    String dbPw = rs.getString("PW");
			    if(pw.equals(dbPw)) {
			    	System.out.println("login success");
		            HttpSession session = request.getSession();
		            // 세션에 값을 저장하여 전달
		            session.setAttribute("id", id);
		            session.setAttribute("pw", pw);
			    	response.sendRedirect("loginResult.jsp");
			    }
			} else {
				System.out.println("login fail");
				response.sendRedirect("login.html");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("login.html");
		} finally {
			try {
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
