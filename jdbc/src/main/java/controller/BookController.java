package controller;

import java.util.List;

import dto.BookDTO;
import message.OutputMessage;
import service.impl.BookServiceImpl;
import view.BookView;

public class BookController extends Controller {

	private BookServiceImpl bs = new BookServiceImpl();
	private BookView bv = new BookView();

	// 1. selectAll() : 모든 도서 조회
	public void selectAll() {
		List<BookDTO> list = bs.selectAll();
		bv.printAll(list);
	}

	// 2. addBook() : 도서 등록
	public void addBook() {
		System.out.println(OutputMessage.addBook.getValue());
		int cnt = bs.addBook(bv.inputTitle(), bv.inputIssueDate());
		bv.successOrFail(cnt, "등록");
	}

	// 3. selectBookByAvailable() : 대출 가능한 도서 조회
	public void selectBookByAvailable() {
		System.out.println(OutputMessage.selectBookByAvailable.getValue());
		List<BookDTO> list = bs.selectBookByAvailable();
		bv.printAll(list);
	}

}
