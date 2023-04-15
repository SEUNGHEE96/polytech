package service;

import java.util.List;

import dto.BookDTO;

public interface BookService {
	
	// 1. selectAll() : 모든 회원 조회
	List<BookDTO> selectAll() ;
	
	// 2. addBook() : 도서 등록
	int addBook(String title, String issueDate);
	
	// 3. selectBookByAvailable() : 대출 가능한 책을 조회합니다.
	List<BookDTO> selectBookByAvailable();
	
}
