package view;

import java.util.List;
import java.util.Scanner;

public class View {

	// 공통된 메소드 모음(부모 클래스)
	Scanner sc = new Scanner(System.in);

	// 입력
	// 책 이름 입력
	public String inputTitle() {
		System.out.print("책 제목 : ");
		return sc.nextLine();
	}

	// 출력
	// 성공 혹은 실패 여부 출력
	public void successOrFail(int cnt, String method) {
		System.out.print(method);
		if (cnt > 0) {
			System.out.println(" 성공 하였습니다.");
		} else {
			System.out.println(" 실패 하였습니다.");
		}
	}

	// 리스트 전부 출력
	public void printAll(List<?> list) {
		for(Object obj : list) {
			System.out.println(obj);
		}
	}

}
