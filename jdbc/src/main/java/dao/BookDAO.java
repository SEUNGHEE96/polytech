package dao;

import static jdbc.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.BookDTO;

public class BookDAO {

	// 1. selectAll() : 모든 도서 조회 (최근 출간 순)
	public List<BookDTO> selectAll(Connection conn) {
		List<BookDTO> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM BOOK ORDER BY ISSUEDATE DESC";
		try {
			ps = conn.prepareStatement(sql);
	        rs = ps.executeQuery();
			while (rs.next()) {
				BookDTO b = new BookDTO(rs.getInt("ID"), rs.getString("TITLE"), rs.getDate("ISSUEDATE"),
						rs.getString("RETURNSTATUS").equals("Y") ? true : false);
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				close(ps);
				close(rs);
			} catch (SQLException e) {
			}
		}
		return list;
	}

	// 2. addBook(): 도서 등록
	public int addBook(Connection conn, String title, String issueDate) {
		PreparedStatement ps = null;
		int result = 0;
		String sql = "INSERT INTO BOOK(ID, TITLE, ISSUEDATE)\r\n"
				+ "VALUES (BOOK_ID.NEXTVAL, ?, TO_DATE(?,'YYYY/MM/DD'))";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, issueDate);

			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				close(ps);
			} catch (SQLException e) {
			}
		}
		return result;
	}

	// 3. selectBookByAvailable(): 대출 가능한 도서 조회
	public List<BookDTO> selectBookByAvailable(Connection conn) {
		List<BookDTO> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM BOOK WHERE RETURNSTATUS = 'Y' ORDER BY ISSUEDATE DESC";
		try {
			ps = conn.prepareStatement(sql);
	        rs = ps.executeQuery();
			while (rs.next()) {
				BookDTO b = new BookDTO(rs.getInt("ID"), rs.getString("TITLE"), rs.getDate("ISSUEDATE"),
						rs.getString("RETURNSTATUS").equals("Y") ? true : false);
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				close(ps);
				close(rs);
			} catch (SQLException e) {
			}
		}
		return list;
	}

}
