package view;

import message.InputMessage;

public class BookView extends View {

	// 발행일 입력
	public String inputIssueDate() {
		System.out.print(InputMessage.inputIssueDate.getValue());
		return sc.nextLine();
	}

}
