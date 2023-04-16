package message;

public enum InputMessage {
	
	// APP에서 쓰이는 것들
	start("도서관리 프로그램을 시작합니다."),
	login("1.로그인  2.종료"),
	menu("1.회원관리  2.도서관리  3.대출관리  4.종료"),
    member("0.뒤로  1.회원전체조회  2.회원등록  3.정보수정  4.회원삭제  5.삭제취소"),
    book("0.뒤로  1.도서전체조회  2.도서등록  3.대출가능도서조회"),
    loan("0.뒤로  1.대출이력조회  2.도서대출  3.도서반납  4.도서연장"),
    // 공통 View에서 쓰이는 것들
    inputTitle("책 제목 : "),
    success(" 성공 하였습니다."),
    fail(" 실패 하였습니다."),
    // 각 View에서 쓰이는 것들
    inputName("이름 : "),
    inputAddress("주소 입력 : "),
	inputPhone("전화번호 입력 (010-1234-1234) : "),
	inputBirthday("생일 입력 (19990101) : "),
	inputIssueDate("발행일 : ");

    private final String value;

    InputMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
