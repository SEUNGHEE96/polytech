package view;

import java.util.Scanner;

public class LoanView {
	
	Scanner sc = new Scanner(System.in);

	// 책 이름 입력
	public String inputTitle() {
		System.out.print("책 제목 : ");
		return sc.nextLine();
	}
	
}
