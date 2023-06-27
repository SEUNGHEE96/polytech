package join;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UsersDAO {
	private String name, id, pw, phone, email, status, auth;
	private String sql;
	private Connection conn;
	private Statement stmt;
	DataSource ds = null;
	
	public UsersDAO() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oraclellg");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<UsersDTO> memberSelect(String status) {
		ArrayList<UsersDTO> dtos = new ArrayList<UsersDTO>();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from users where status = ? order by id";
		
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, status);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String auth = rs.getString("auth");
				
				UsersDTO dto = new UsersDTO(id, pw, name, phone, email, status, auth);
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
	
	public int insertMember(UsersDTO dto) {
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			conn = ds.getConnection();			
			String sql = "insert into users(id, pw, name, phone, email, status, auth) values(?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);

			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPw());
			ps.setString(3, dto.getName());
			ps.setString(4, dto.getPhone());
			ps.setString(5, dto.getEmail());
			ps.setString(6, "1");
			ps.setString(7, "N");
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				ps.close();
			} catch (SQLException e) {
			}
		}
		return result;
	}
	
	public UsersDTO selectMember(String id, String pw) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UsersDTO dto = null;
		String sql = "select * from users where id = ?";
		
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				String dbPw = rs.getString("PW");
			    if(pw.equals(dbPw)) {
					String name = rs.getString("name");
					String phone = rs.getString("phone");
					String email = rs.getString("email");
					String status = rs.getString("status");
					String auth = rs.getString("auth");
					dto = new UsersDTO(id, pw, name, phone, email, status, auth);
			    }
		    }
		} catch(Exception e) {
			e.printStackTrace();
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
	
	public UsersDTO updateMember(UsersDTO dto) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			conn = ds.getConnection();
			String sql = "UPDATE USERS "
					+ "SET "
					+ "PW = ?,"
					+ "NAME = ?,"
					+ "PHONE = ?,"
					+ "EMAIL = ? "
					+ "WHERE "
					+ "ID = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getPw());
			ps.setString(2, dto.getName());
			ps.setString(3, dto.getPhone());
			ps.setString(4, dto.getEmail());
			ps.setString(5, dto.getId());
			result = ps.executeUpdate();
			
			if (result == 1) {
				System.out.println("update success");
			} else {
				System.out.println("update fail");
			}
		} catch (Exception e) {
			e.printStackTrace();
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
		return dto;
	}
	
	public int updateStatus(String column, String value, String id) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			conn = ds.getConnection();
			
			String sql = "UPDATE USERS SET " + column + " = ? WHERE ID = ?";
	        ps = conn.prepareStatement(sql);
	        ps.setString(1, value);
	        ps.setString(2, id);
	        result += ps.executeUpdate();
			
			if (result >= 1) {
				System.out.println("update success");
			} else {
				System.out.println("update fail");
			}
		} catch (Exception e) {
			e.printStackTrace();
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
		return result;
	}
}
