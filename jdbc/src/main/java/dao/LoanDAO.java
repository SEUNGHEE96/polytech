package dao;

import static jdbc.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.LoanDTO;

public class LoanDAO {

	// 1. getLoanHistory(): 로그인한 회원의 대출 내역
	public List<LoanDTO> getLoanHistory(Connection conn, int id) {
		List<LoanDTO> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT L.ID, L.MEMBERID, B.TITLE, L.ISRETURNED, L.LOANDATE, L.DAYSLEFT, L.ISRENEWED "
				+ "FROM LOAN L INNER JOIN BOOK B " + "ON L.BOOKID = B.ID " + "WHERE MEMBERID = ? " + "ORDER BY L.DAYSLEFT";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			rs = ps.executeQuery();
			while (rs.next()) {
				LoanDTO l = new LoanDTO(rs.getInt("ID"), rs.getInt("MEMBERID"), rs.getString("TITLE"),
						rs.getString("ISRETURNED").equals("Y") ? true : false, rs.getDate("LOANDATE"),
						rs.getInt("DAYSLEFT"), rs.getString("ISRENEWED").equals("Y") ? true : false);
				list.add(l);
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

	// 2. addLoan(): 도서 대출
	public int addLoan(Connection conn, int id, String title) {
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		int result = 0;
		String sql = "INSERT INTO LOAN(ID, MEMBERID, BOOKID, LOANDATE) "
				+ "VALUES(LOAN_ID.NEXTVAL, ?, (SELECT ID FROM BOOK WHERE TITLE = ?) , TRUNC(SYSDATE))";
		String sql2 = "UPDATE BOOK SET RETURNSTATUS = 'N' WHERE TITLE = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps2 = conn.prepareStatement(sql2);
			ps.setInt(1, id);
			ps.setString(2, title);
			ps2.setString(1, title);

			ps2.executeUpdate();
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

	// 3. returnBook() : 도서 반납
	public int returnBook(Connection conn, int id, String title) {
		PreparedStatement ps = null;
		int result = 0;
		String sql = "UPDATE LOAN SET ISRETURNED = 'Y' " + "WHERE BOOKID = (SELECT ID FROM BOOK WHERE TITLE = ?) "
				+ "AND MEMBERID = ? " + "AND ISRETURNED = 'N'";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, title);
			ps.setInt(2, id);

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

	// 4. renewableList() : 연장 가능한 도서 조회
	public List<LoanDTO> renewableList(Connection conn, int id) {
		List<LoanDTO> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT L.ID, L.MEMBERID, B.TITLE, L.ISRETURNED, L.LOANDATE, L.DAYSLEFT, L.ISRENEWED "
				+ "FROM LOAN L INNER JOIN BOOK B " + "ON L.BOOKID = B.ID " + "WHERE MEMBERID = ? "
				+ "AND ISRETURNED = 'N' " + "AND ISRENEWED = 'N'";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			rs = ps.executeQuery();
			while (rs.next()) {
				LoanDTO l = new LoanDTO(rs.getInt("ID"), rs.getInt("MEMBERID"), rs.getString("TITLE"),
						rs.getString("ISRETURNED").equals("Y") ? true : false, rs.getDate("LOANDATE"),
						rs.getInt("DAYSLEFT"), rs.getString("ISRENEWED").equals("Y") ? true : false);
				list.add(l);
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

	// 5. extendLoan() : 대출 연장
	public int extendLoan(Connection conn, int id, String title) {
		PreparedStatement ps = null;
		int result = 0;
		String sql = "UPDATE LOAN " + "SET ISRENEWED = 'Y' , DAYSLEFT = DAYSLEFT + 7 "
				+ "WHERE BOOKID = (SELECT ID FROM BOOK WHERE TITLE = ?) " + "AND MEMBERID = ? "
				+ "AND ISRETURNED = 'N' " + "AND ISRENEWED = 'N'";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, title);
			ps.setInt(2, id);

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

}
