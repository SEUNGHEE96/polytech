package join2;

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

public class MemberDAO {
	private String name, id, pw, phone1, phone2, phone3, gender;
	private String sql;
	private Connection conn;
	private Statement stmt;
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
	
	public int insertMember(MemberDTO dto) {
		ArrayList<MemberDTO> dtos = new ArrayList<MemberDTO>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			conn = ds.getConnection();			
			String sql = "insert into member(id, pw, name, phone1, phone2, phone3, gender) values(?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);

			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPw());
			ps.setString(3, dto.getName());
			ps.setString(4, dto.getPhone1());
			ps.setString(5, dto.getPhone2());
			ps.setString(6, dto.getPhone3());
			ps.setString(7, dto.getGender());
			
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
	
	public MemberDTO selectMember(String id, String pw) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MemberDTO dto = null;
		
		try {
			conn = ds.getConnection();
			String sql = "select * from member where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				String dbPw = rs.getString("PW");
			    if(pw.equals(dbPw)) {
					String name = rs.getString("name");
					String phone1 = rs.getString("phone1");
					String phone2 = rs.getString("phone2");
					String phone3 = rs.getString("phone3");
					String gender = rs.getString("gender");
					dto = new MemberDTO(id, pw, name, phone1, phone2, phone3, gender);
			    }
		    } else {
				System.out.println("login fail");
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
	
	public MemberDTO updateMember(MemberDTO dto) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		MemberDTO updateDto = null;
		int result = 0;
		
		try {
			conn = ds.getConnection();
			String sql = "UPDATE MEMBER "
					+ "SET "
					+ "PW = ?,"
					+ "NAME = ?,"
					+ "PHONE1 = ?,"
					+ "PHONE2 = ?,"
					+ "PHONE3 = ?,"
					+ "GENDER = ? "
					+ "WHERE "
					+ "ID = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getPw());
			ps.setString(2, dto.getName());
			ps.setString(3, dto.getPhone1());
			ps.setString(4, dto.getPhone2());
			ps.setString(5, dto.getPhone3());
			ps.setString(6, dto.getGender());
			ps.setString(7, dto.getId());
			result = ps.executeUpdate();
			
			if (result == 1) {
				System.out.println("update success");
				updateDto = new MemberDTO(id, pw, name, phone1, phone2, phone3, gender);
				//response.sendRedirect("modifyResult.jsp");
			} else {
				System.out.println("update fail");
				//response.sendRedirect("modify.jsp");
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
		return updateDto;
	}
}
