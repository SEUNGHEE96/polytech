package controller;

import java.util.List;

import dto.LoanDTO;
import message.OutputMessage;
import service.impl.LoanServiceImpl;
import view.LoanView;

public class LoanController extends Controller {

	private LoanServiceImpl ls = new LoanServiceImpl();
	private LoanView lv = new LoanView();

	// 1. getLoanHistory(): 로그인한 회원의 대출 내역
	public void getLoanHistory(int id) {
		List<LoanDTO> list = ls.getLoanHistory(id);
		lv.printAll(list);
	}

	// 2. addLoan(): 도서 대출
	public void addLoan(int id) {
		System.out.println(OutputMessage.addLoan.getValue());
		int cnt = ls.addLoan(id, lv.inputTitle());
		lv.successOrFail(cnt, "대출");
	}

	// 3. returnBook() : 도서 반납
	public void returnBook(int id) {
		String title = lv.inputTitle();
		int cnt = ls.returnBook(id, title);
		lv.successOrFail(cnt, "반납");
	}

	// 4. renewableList() : 연장 가능한 도서 조회
	public void renewableList(int id) {
		System.out.println(OutputMessage.renewableList.getValue());
		List<LoanDTO> list = ls.renewableList(id);
		lv.printAll(list);
	}

	// 5. extendLoan() : 대출 연장
	public void extendLoan(int id) {
		String title = lv.inputTitle();
		int cnt = ls.extendLoan(id, title);
		lv.successOrFail(cnt, "연장");
	}

}
