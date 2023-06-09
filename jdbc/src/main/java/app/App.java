package app;

import java.util.Scanner;

import controller.BookController;
import controller.Controller;
import controller.LoanController;
import controller.MemberController;
import dto.MemberDTO;
import message.InputMessage;

public class App {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Controller c = new Controller();
		MemberController mc = new MemberController();
		BookController bc = new BookController();
		LoanController lc = new LoanController();

		System.out.println(InputMessage.start.getValue());
		while (true) {
			int loginMemberId = 0;
			// 1.로그인  2.종료
			System.out.println(InputMessage.login.getValue());
			int start = Integer.parseInt(sc.nextLine());

			// 1. 로그인
			if (start == 1) {
				MemberDTO loginMember = mc.loginMember();
				if (loginMember == null) {
					// 로그인에 실패하면 다시 로그인 시도
					continue;
				}
				// 성공하면 자주 쓰이는 로그인한 회원의 ID 저장
				loginMemberId = loginMember.getId();
				while (true) {
					// 0.뒤로  1.회원관리  2.도서관리  3.대출관리
					System.out.println(InputMessage.menu.getValue());
					int menu = Integer.parseInt(sc.nextLine());
					// 0. 뒤로
					if (menu == 0) {
						break;
					}
					// 1. 회원관리
					if (menu == 1) {
						while (true) {
							// 0.뒤로  1.회원전체조회  2.회원등록  3.정보수정  4.회원삭제  5.삭제취소
							System.out.println(InputMessage.member.getValue());
							int memberMenu = Integer.parseInt(sc.nextLine());
							// 0. 뒤로
							if (memberMenu == 0) {
								break;
							}
							// 1. 모든 회원 조회
							if (memberMenu == 1) {
								mc.selectAll();
								continue;
							}
							// 2. 회원 등록
							if (memberMenu == 2) {
								mc.addMember();
								continue;
							}
							// 3. 회원 수정
							if (memberMenu == 3) {
								mc.updateMember(loginMemberId);
								continue;
							}
							// 4. 회원 삭제
							if (memberMenu == 4) {
								mc.deleteMember();
								continue;
							}
							// 5.삭제 취소
							if (memberMenu == 5) {
								mc.rollbackDelete();
								continue;
								// 회원 관리 그 외
							} else {
								mc.wrongNumber();
								continue;
							}
						}
					}
					// 2. 도서관리
					if (menu == 2) {
						while (true) {
							// 0.뒤로  1.도서전체조회  2.도서등록  3.대출가능도서조회
							System.out.println(InputMessage.book.getValue());
							int BookMenu = Integer.parseInt(sc.nextLine());
							// 0. 뒤로
							if (BookMenu == 0) {
								break;
							}
							// 1. 모든 도서 조회 (최근출간순)
							if (BookMenu == 1) {
								bc.selectAll();
								continue;
							}
							// 2. 도서 등록
							if (BookMenu == 2) {
								bc.addBook();
								continue;
							}
							// 3. 대출 가능한 도서 조회
							if (BookMenu == 3) {
								bc.selectBookByAvailable();
								continue;
								// 도서 관리 그 외
							} else {
								bc.wrongNumber();
								continue;
							}
						}
					}
					// 3. 대출 관리
					if (menu == 3) {
						while (true) {
							// 0.뒤로  1.대출이력조회  2.도서대출  3.도서반납  4.도서연장
							System.out.println(InputMessage.loan.getValue());
							int LoanMenu = Integer.parseInt(sc.nextLine());
							// 0. 뒤로
							if (LoanMenu == 0) {
								break;
							}
							// 1. 로그인한 회원의 대출 내역
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
								// 연장 가능한 도서 조회
								lc.renewableList(loginMemberId);
								lc.extendLoan(loginMemberId);
								continue;
								// 대출 관리 그 외
							} else {
								lc.wrongNumber();
								continue;
							}
						}
					}
				}
				// 2. 종료
			} else if (start == 2) {
				c.finishMain();
				break;
				// 로그인 그 외
			} else {
				c.wrongNumber();
				continue;
			}
		}
	}
}
