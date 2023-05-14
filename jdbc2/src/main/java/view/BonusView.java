package view;

public class BonusView{

	// 출력
	// 성공 혹은 실패 여부 출력
	public void successOrFail(int cnt) {
		if (cnt > 0) {
			System.out.println("보너스 입력 성공");
		} else {
			System.out.println("보너스 입력 실패");
		}
	}

}
