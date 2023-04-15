package service;

import static jdbc.JDBCTemplate.close;
import static jdbc.JDBCTemplate.commit;
import static jdbc.JDBCTemplate.getConnection;
import static jdbc.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import dao.BookDAO;
import dto.BookDTO;

public class BookServiceImpl {
	
	private BookDAO bd = new BookDAO();
	
	// 1. selectAll() : 모든 회원 조회
	public List<BookDTO> selectAll() {
		Connection conn = getConnection();
		List<BookDTO> list = bd.selectAll(conn);
		close(conn);
		return list;
	}
	
	// 2. addBook() : 도서 등록
	public int addBook(String title, String issueDate) {
		Connection conn = getConnection();
		int result = bd.addBook(conn, title, issueDate);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	// 3. selectBookByAvailable() : 대출 가능한 책을 조회합니다.
	public List<BookDTO> selectBookByAvailable() {
		Connection conn = getConnection();
		List<BookDTO> list = bd.selectBookByAvailable(conn);
		close(conn);
		return list;
	}
	
	
}