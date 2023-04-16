package service;

import java.util.List;

import dto.LoanDTO;

public interface LoanService {

	// 1. getLoanHistory(): 로그인한 회원의 대출 내역
	List<LoanDTO> getLoanHistory(int id);

	// 2. addLoan(): 도서 대출
	int addLoan(int id, String title);

	// 3. returnBook() : 도서 반납
	int returnBook(int id, String title);

	// 4. renewableList() : 연장 가능한 도서 조회
	List<LoanDTO> renewableList(int id);

	// 5. extendLoan() : 대출 연장
	int extendLoan(int id, String title);

}
