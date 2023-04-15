package Controller;

import java.util.List;

import dto.LoanDTO;
import service.LoanServiceImpl;
import view.LoanView;

public class LoanController {
	
	private LoanServiceImpl ls = new LoanServiceImpl();
	private LoanView lv = new LoanView();
	
	// 1. getLoanHistory(): 로그인한 회원의 대출 내역
	public void getLoanHistory(int id) {
		List<LoanDTO> list = ls.getLoanHistory(id);
		for(LoanDTO b : list) {
			System.out.println(b);
		}
	}
	
	// 2. addLoan(): 도서 대출
	public void addLoan(int id) {
		System.out.println("대출 할 도서 정보를 입력하세요");
		int cnt = ls.addLoan(id, lv.inputTitle());
		if (cnt > 0) {
			System.out.println("등록에 성공하였습니다.");
		} else {
			System.out.println("등록에 실패하였습니다.");
		}
	}
	
	// 3. returnBook() : 도서 반납
	public void returnBook(int id) {
		String title = lv.inputTitle();
		int cnt = ls.returnBook(id, title);
		if (cnt > 0) {
			System.out.println("반납에 성공하였습니다.");
		} else {
			System.out.println("반납에 실패하였습니다.");
		}
	}
	
	// 4. renewableList() : 연장 가능한 도서 조회
	public void renewableList(int id) {
		System.out.println("나의 현재 대출 내역입니다.");
		List<LoanDTO> list = ls.renewableList(id);
		for(LoanDTO b : list) {
			System.out.println(b);
		}
	}
	
	// 5. extendLoan() : 대출 연장
	public void extendLoan(int id) {
		String title = lv.inputTitle();
		int cnt = ls.extendLoan(id, title);
		if (cnt > 0) {
			System.out.println("연장에 성공하였습니다.");
		} else {
			System.out.println("연장에 실패하였습니다.");
		}
	}
	
}
