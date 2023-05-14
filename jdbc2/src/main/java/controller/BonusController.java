package controller;

import java.util.HashMap;

import service.BonusService;
import view.BonusView;

public class BonusController{

	private BonusService bs = new BonusService();
	private BonusView bv = new BonusView();

	// 1. addBonus() : 보너스 insert문 실행 후 리턴 반환
	public void addBonus() {
		HashMap<Integer, Integer> emplist = bs.getBonus();
		int result = bs.addBonus(emplist);
		bv.successOrFail(result);
	}

}
