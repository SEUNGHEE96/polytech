package view;

public class BookView extends View {

	// 발행일 입력
	public String inputIssueDate() {
		System.out.print("발행일 : ");
		return sc.nextLine();
	}

}
