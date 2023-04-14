package domain;

import java.util.Collections;

import entity.Loan;

public class LoanManager extends Manager<Loan> {

	public LoanManager() {
		// BookManager 클래스의 booklist 메서드를 호출하여 반환된 리스트를 list 필드에 할당합니다.
		list = ml.loanlist();
	}
	
	// searchLoanByName() : 대출이력조회
	public void searchLoanByName(String name) {
		Collections.sort(list);
		for (Loan l : list) {
			if(l.getMemberName().equals(name)) {
				System.out.println(l);				
			}
		}
	}
	
	// loanBook(): 책을 대출합니다.
	public void loanBook(Loan loan) {
		int id = 0;
		for (Loan l : list) {
			id = Math.max(id, l.getId() + 1);
		}
		loan.setId(id);
		list.add(loan);
	}
	
	// searchAvaliableRenew() : 연장 가능한 책을 조회합니다.
	public boolean searchAvaliableRenew(String name) {
		boolean result = false;
		for (Loan l : list) {
			if (!l.isExtension() && l.getMemberName().equals(name) && !l.isRenewStatus()) {
				result = true;
				System.out.println(l);
			}
		}
		return result;
	}
	
	// extendLoan() : 대출을 연장합니다.
	public boolean extendLoan(String memberName, String bookName) {
		boolean result = false;
		for (Loan l : list) {
			if (l.getMemberName().equals(memberName) && l.getBookTitle().equals(bookName)) {
				result = true;
				l.setExtension(true);
				l.setDeadline(l.getDeadline() + 7);
				break;
			}
		}
		return result;
	}

}
