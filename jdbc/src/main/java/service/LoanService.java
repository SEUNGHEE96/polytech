package service;

import java.util.List;

import dto.LoanDTO;

public interface LoanService {
	
	// 1. getLoanHistory(): 대출 가능한 책을 조회합니다.
	List<LoanDTO> getLoanHistory(int id);
	
	// 2. addLoan(): 도서를 대출합니다.
	int addLoan(int id, String title);
	
	// 3. returnBook() : 도서 반납
	int returnBook(int id, String title);
	
	// 4. renewableList() : 연장 가능한 책을 조회합니다.
	List<LoanDTO> renewableList(int id);
	
	// 5. extendLoan() : 대출을 연장합니다.
	int extendLoan(int id, String title);
	
}
