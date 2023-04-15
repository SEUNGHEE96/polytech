package service;

import static jdbc.JDBCTemplate.close;
import static jdbc.JDBCTemplate.commit;
import static jdbc.JDBCTemplate.getConnection;
import static jdbc.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import dao.LoanDAO;
import dto.LoanDTO;

public class LoanServiceImpl implements LoanService {
	
	private LoanDAO ld = new LoanDAO();
	
	// 1. getLoanHistory(): 대출 가능한 책을 조회합니다.
	@Override
	public List<LoanDTO> getLoanHistory(int id) {
		Connection conn = getConnection();
		List<LoanDTO> list = ld.getLoanHistory(conn, id);
		close(conn);
		return list;
	}
	
	// 2. addLoan(): 도서를 대출합니다.
	@Override
	public int addLoan(int id, String title) {
		Connection conn = getConnection();
		int result = ld.addLoan(conn, id, title);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	// 3. returnBook() : 도서 반납
	@Override
	public int returnBook(int id, String title) {
		Connection conn = getConnection();
		int result = ld.returnBook(conn, id, title);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	// 4. renewableList() : 연장 가능한 책을 조회합니다.
	@Override
	public List<LoanDTO> renewableList(int id) {
		Connection conn = getConnection();
		List<LoanDTO> list = ld.renewableList(conn, id);
		close(conn);
		return list;
	}
	
	// 5. extendLoan() : 대출을 연장합니다.
	public int extendLoan(int id, String title) {
		Connection conn = getConnection();
		int result = ld.extendLoan(conn, id, title);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
}
