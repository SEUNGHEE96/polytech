import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import console.InputMessage;
import console.OutputMessage;
import domain.BookManager;
import domain.LoanManager;
import domain.MemberManager;
import entity.Loan;
import entity.Member;
import save.Exportlist;
import view.InputView;

public class Main {

	public static void main(String[] args) {

		// Manager에서 각 Entity 리스트를 갖고있다.
		MemberManager mm = new MemberManager();
		BookManager bm = new BookManager();
		LoanManager lm = new LoanManager();

		// 입력
		InputView iv = new InputView();

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println(InputMessage.start.getValue());
			int menu = sc.nextInt();
			if (menu < 1 || menu > 3) {
				System.out.println(OutputMessage.wrongNumber.getValue());
				continue;
			}
			if (menu == 1) {
				// 1. 회원관리
				while (true) {
					System.out.println(InputMessage.member.getValue());
					int memberMenu = sc.nextInt();
					if (menu < 0 || menu > 5) {
						System.out.println(OutputMessage.wrongNumber.getValue());
						continue;
					}
					// 0. 뒤로
					if (memberMenu == 0) {
						break;
					}
					// 1. 회원조회
					if (memberMenu == 1) {
						mm.printAllList();
						continue;
					}
					// 2.회원 등록
					if (memberMenu == 2) {
						System.out.println(InputMessage.addMember.getValue());
						Member mem = iv.newMember(0);
						mm.addMember(mem);
						System.out.println(OutputMessage.addMember.getValue());
						continue;
					}
					// 3.회원 수정
					if (memberMenu == 3) {
						System.out.println(InputMessage.editMember.getValue());
						int id = sc.nextInt();
						Member mem = iv.newMember(id);
						mm.editMember(id, mem);
						System.out.println(OutputMessage.editMember.getValue());
						continue;
					}
					// 4.회원 삭제
					if (memberMenu == 4) {
						System.out.print(InputMessage.deleteMember.getValue());
						int id = sc.nextInt();
						boolean check = mm.deleteMember(id);
						if (check) {
							System.out.println(OutputMessage.deleteMember.getValue());
						} else if (!check) {
							System.out.println(OutputMessage.failToDelete.getValue());
						}
						continue;
					}
					// 5.삭제 취소
					if (memberMenu == 5) {
						boolean check = mm.rollbackDelete();
						if (!check) {
							System.out.println(OutputMessage.failToRollback.getValue());
							continue;
						}
						System.out.println(OutputMessage.rollbackMember.getValue());
						continue;
					}
				}
			}
			// 2. 도서관리
			if (menu == 2) {
				while (true) {
					System.out.println(InputMessage.book.getValue());
					int BookMenu = sc.nextInt();
					if (menu < 0 || menu > 5) {
						System.out.println(OutputMessage.wrongNumber.getValue());
						continue;
					}
					// 0. 뒤로
					if (BookMenu == 0) {
						break;
					}
					// 1. 도서 전체 조회 (최근출간순)
					if (BookMenu == 1) {
						bm.printAllList();
						continue;
					}
					// 2. 대출가능도서조회
					if (BookMenu == 2) {
						bm.searchBookByAvailable();
						continue;
					}
					// 3. 대출이력조회
					if (BookMenu == 3) {
						System.out.println(InputMessage.inputName.getValue());
						String memberName = sc.next();
						lm.searchLoanByName(memberName);
						continue;
					}
					// 4. 대출신청
					if (BookMenu == 4) {
						System.out.println(InputMessage.inputName.getValue());
						String memberName = sc.next();

						System.out.println(OutputMessage.availablelist.getValue());
						bm.searchBookByAvailable();

						System.out.println(InputMessage.inputBookName.getValue());
						String bookName = sc.next();

						String loanDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
						Loan newLoan = new Loan(0, memberName, bookName, false, loanDate, 14, false);
						lm.loanBook(newLoan);
						bm.loanBook(bookName);
						continue;
					}
					// 5. 연장신청
					if (BookMenu == 5) {
						System.out.println(InputMessage.inputName.getValue());
						String memberName = sc.next();

						System.out.println(OutputMessage.extendablelist.getValue());
						lm.searchAvaliableRenew(memberName);

						System.out.println(InputMessage.inputBookName.getValue());
						String bookName = sc.next();

						if (lm.extendLoan(memberName, bookName)) {
							System.out.println(OutputMessage.extendBook.getValue());
						} else {
							System.out.println(OutputMessage.failToExtend.getValue());
						}
						continue;
					}
				}
			}
			// 3. 종료
			if (menu == 3) {
				System.out.println(OutputMessage.finishMain.getValue());
				break;
			}
		}
		// 프로그램 종료시, 바뀐 데이터를 저장하고 마무리한다.
		Exportlist el = new Exportlist();
		el.exportBook(bm.getList());
		el.exportMember(mm.getList());
		el.exportLoan(lm.getList());
	}
}