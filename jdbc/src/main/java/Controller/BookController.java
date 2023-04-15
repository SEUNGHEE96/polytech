package Controller;

import java.util.List;

import dto.BookDTO;
import service.BookServiceImpl;
import view.BookView;

public class BookController {

	private BookServiceImpl bs = new BookServiceImpl();
	private BookView bv = new BookView();
	
	// 1. selectAll() : 모든 회원 조회
	public void selectAll() {
		List<BookDTO> list = bs.selectAll();
		for(BookDTO b : list) {
			System.out.println(b);
		}
	}
	
	// 2. addBook() : 도서 추가
	public void addBook() {
		System.out.println("등록할 도서 정보를 입력하세요");
		int cnt = bs.addBook(bv.inputTitle(), bv.inputIssueDate());
		if (cnt > 0) {
			System.out.println("등록에 성공하였습니다.");
		} else {
			System.out.println("등록에 실패하였습니다.");
		}
	}
	
	// 3. searchBookByAvailable() : 대출 가능한 책을 조회합니다.
	public void selectBookByAvailable() {
		List<BookDTO> list = bs.selectBookByAvailable();
		for(BookDTO b : list) {
			System.out.println(b);
		}
	}
	
}
