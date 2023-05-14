package app;

import controller.BonusController;

public class App {

	public static void main(String[] args) {

		BonusController mc = new BonusController();
		
		//로직 실행 시작 전 시간 저장
		long startTime = System.currentTimeMillis();
		//만들어놓은 로직 실행
		mc.addBonus();
		//로직 실행 완료 후 시간 저장
		long endTime = System.currentTimeMillis();
		//시작 후 - 시작 전 시간 연산
		long elapsedTime = endTime - startTime;
		
		System.out.println("실행 시간: " + elapsedTime + "ms");		
	}
}
