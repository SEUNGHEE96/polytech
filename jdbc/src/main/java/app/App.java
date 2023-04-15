package app;

import java.util.Scanner;

import Controller.BookController;
import Controller.LoanController;
import Controller.MemberController;
import dto.MemberDTO;
import message.InputMessage;
import message.OutputMessage;

public class App {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		MemberController mc = new MemberController();
		BookController bc = new BookController();
		LoanController lc = new LoanController();

		System.out.println("도서관리 프로그램을 시작합니다.");
		while (true) {
			System.out.println("1. 로그인 2. 종료");
			int start = sc.nextInt();
			int loginMemberId = 0;
			if (start == 1) {
				MemberDTO loginMember = mc.loginMember();
				if (loginMember == null) {
					continue;
				} else {
					loginMemberId = loginMember.getId();
				}
			} else {
				System.out.println(OutputMessage.finishMain.getValue());
				break;
			}
			System.out.println(InputMessage.start.getValue());
			int menu = sc.nextInt();
			if (menu == 1) {
				// 1. 회원관리
				while (true) {
					System.out.println(InputMessage.member.getValue());
					int memberMenu = sc.nextInt();
					// 0. 뒤로
					if (memberMenu == 0) {
						break;
					}
					// 1. 회원조회
					if (memberMenu == 1) {
						mc.selectAll();
						continue;
					}
					// 2.회원 등록
					if (memberMenu == 2) {
						mc.addMember();
						continue;
					}
					// 3.회원 수정
					if (memberMenu == 3) {
						mc.updateMember(loginMemberId);
						continue;
					}
					// 4.회원 삭제
					if (memberMenu == 4) {
						mc.deleteMember();
						continue;
					}
					// 5.삭제 취소
					if (memberMenu == 5) {
						mc.rollbackDelete();
						continue;
					} else {
						System.out.println(OutputMessage.wrongNumber.getValue());
						continue;
					}
				}
			}
			// 2. 도서관리
			if (menu == 2) {
				while (true) {
					System.out.println(InputMessage.book.getValue());
					int BookMenu = sc.nextInt();
					// 0. 뒤로
					if (BookMenu == 0) {
						break;
					}
					// 1. 도서 전체 조회 (최근출간순)
					if (BookMenu == 1) {
						bc.selectAll();
						continue;
					}
					// 2. 도서 등록
					if (BookMenu == 2) {
						bc.addBook();
						continue;
					}
					// 3. 대출 가능 도서 조회
					if (BookMenu == 3) {
						bc.selectBookByAvailable();
						continue;
					} else {
						System.out.println(OutputMessage.wrongNumber.getValue());
						continue;
					}
				}
			}
			// 3. 대출 관리
			if (menu == 3) {
				while (true) {
					System.out.println(InputMessage.loan.getValue());
					int LoanMenu = sc.nextInt();
					// 0. 뒤로
					if (LoanMenu == 0) {
						break;
					}
					// 1. 대출이력조회
					if (LoanMenu == 1) {
						lc.getLoanHistory(loginMemberId);
						continue;
					}
					// 2. 도서 대출
					if (LoanMenu == 2) {
						lc.addLoan(loginMemberId);
						continue;
					}
					// 3. 도서 반납
					if (LoanMenu == 3) {
						lc.returnBook(loginMemberId);
						continue;
					}
					// 4. 도서 연장
					if (LoanMenu == 4) {
						lc.renewableList(loginMemberId);
						lc.extendLoan(loginMemberId);
						continue;
					} 
					else {
						System.out.println(OutputMessage.wrongNumber.getValue());
						continue;
					}
				}
			}
			// 3. 종료
			if (menu == 4) {
				System.out.println(OutputMessage.finishMain.getValue());
				break;
			}
		}
	}
}
