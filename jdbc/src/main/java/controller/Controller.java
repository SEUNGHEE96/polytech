package controller;

import message.OutputMessage;

public class Controller {

	// 공통된 출력문
	public void wrongNumber() {
		System.out.println(OutputMessage.wrongNumber.getValue());
	}

	public void finishMain() {
		System.out.println(OutputMessage.finishMain.getValue());
	}

}
