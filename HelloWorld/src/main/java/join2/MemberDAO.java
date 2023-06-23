package join2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class MemberDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@192.168.119.119:1521/dink13";
	String user = "c##scott";
	String passwd = "tiger";
	DataSource ds = null;
	
	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oraclellg");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<MemberDTO> memberSelect() {
		ArrayList<MemberDTO> dtos = new ArrayList<MemberDTO>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from member");
			
			while(rs.next()) {
				String name = rs.getString("name");
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String phone1 = rs.getString("phone1");
				String phone2 = rs.getString("phone2");
				String phone3 = rs.getString("phone3");
				String gender = rs.getString("gender");
				
				MemberDTO dto = new MemberDTO(name, id, pw, phone1, phone2, phone3, gender);
				dtos.add(dto);
			}
		} catch(Exception e) {
			
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return dtos;
	}
	
	/*
	public MemberDTO selectMember(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MemberDTO dto = new MemberDTO();
		int result = 0;
		try {
			conn = DriverManager.getConnection(url, user, passwd);
			String id = request.getParameter("id");
			
			String sql = "select * from member where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String name = rs.getString("name");
				String pw = rs.getString("pw");
				String phone1 = rs.getString("phone1");
				String phone2 = rs.getString("phone2");
				String phone3 = rs.getString("phone3");
				String gender = rs.getString("gender");
				
				dto = new MemberDTO(name, id, pw, phone1, phone2, phone3, gender);
			}
		} catch(Exception e) {
			
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return dto;
	}
	*/
	
	/*
	public MemberDTO updateMember(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();

		String id = (String) session.getAttribute("id");
		String name = request.getParameter("name");
		String pw = request.getParameter("pw");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String gender = request.getParameter("gender");

		String query = "UPDATE MEMBER "
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
	 */
}
