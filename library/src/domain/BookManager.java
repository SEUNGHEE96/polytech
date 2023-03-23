package domain;

import entity.Book;

public class BookManager extends Manager<Book> {

	public BookManager() {
		// BookManager 클래스의 booklist 메서드를 호출하여 반환된 리스트를 list 필드에 할당합니다.
		list = ml.booklist();
	}
	
	// 최근 출간순으로 조회
	@Override
	public void printAllList() {
		// TODO Auto-generated method stub
		super.printAllList();
	}

	// searchBookByAvailable(): 대출 가능한 책을 조회합니다.
	public void searchBookByAvailable() {
		for (Book b : list) {
			if (b.isReturnStatus()) {
				System.out.println(b);
			}
		}
	}
	
	// loanBook() : 반납 여부를 false로 바꿉니다.
	public void loanBook(String name) {
		for(Book b : list) {
			if (b.getTitle().equals(name)) {
				b.setReturnStatus(false);
			}
		}
	}

}
