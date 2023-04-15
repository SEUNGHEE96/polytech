package dao;

import static jdbc.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.BookDTO;

public class BookDAO{
	
	// 1. 도서 전체 조회 (최근출간순)
	// 2. 도서 등록
	// 3. 대출 가능 도서 조회
	
	// 1. selectAll() : 모든 도서를 최근 출간 순으로 조회
	public List<BookDTO> selectAll(Connection conn) {
		List<BookDTO> list = new ArrayList<>();
		Statement st = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM BOOK ORDER BY ISSUEDATE DESC";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				BookDTO b = new BookDTO(rs.getInt("ID"), 
									rs.getString("TITLE"), 
									rs.getDate("ISSUEDATE"),
			                        rs.getString("RETURNSTATUS").equals("Y") ? true : false);
			list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				close(st);
				close(rs);
			} catch (SQLException e) {
			}
		}
		return list;
	}
	
	// 2. addBook(): 새로운 책을 추가합니다.
	public int addBook(Connection conn, String title, String issueDate) {
		PreparedStatement pt = null;
		int result = 0;
		String sql = "INSERT INTO BOOK(ID, TITLE, ISSUEDATE)\r\n"
				+ "VALUES (BOOK_ID.NEXTVAL, ?, TO_DATE(?,'YYYY/MM/DD'))";
		try {
			pt = conn.prepareStatement(sql);
			pt.setString(1, title);
			pt.setString(2, issueDate);
			
			result = pt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				close(pt);
			} catch (SQLException e) {
			}
		}
		return result;
	}
	
	// 3. selectBookByAvailable(): 대출 가능한 책을 조회합니다.
	public List<BookDTO> selectBookByAvailable(Connection conn) {
		List<BookDTO> list = new ArrayList<>();
		Statement st = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM BOOK WHERE RETURNSTATUS = 'N' ORDER BY ISSUEDATE DESC";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				BookDTO b = new BookDTO(rs.getInt("ID"), 
									rs.getString("TITLE"), 
									rs.getDate("ISSUEDATE"),
			                        rs.getString("RETURNSTATUS").equals("Y") ? true : false);
			list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				close(st);
				close(rs);
			} catch (SQLException e) {
			}
		}
		return list;
	}

	/*
	// loanBook() : 반납 여부를 false로 바꿉니다.
	public void loanBook(String name) {
		for (BookDTO b : list) {
			if (b.getTitle().equals(name)) {
				b.setReturnStatus(false);
			}
		}
	}
	*/
	
}
