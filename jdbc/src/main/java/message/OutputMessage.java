package message;

public enum OutputMessage {
	
	// 공통 Controller에서 쓰이는 것들
	wrongNumber("잘못된 번호입니다."),
	finishMain("종료 합니다."),
	// 각 Controller에서 쓰이는 것들
	addMember("등록할 회원 정보를 입력하세요."),
	updateMember("수정 할 정보를 선택해주세요.\r\n1. 이름 2. 주소 3. 전화번호 4. 생일"),
    deleteMember("삭제하고 싶은 회원의 이름를 입력하세요"),
    addBook("등록할 도서 정보를 입력하세요."),
    selectBookByAvailable("대출 가능한 도서 목록입니다."),
	addLoan("대출 할 도서 정보를 입력하세요"),
	renewableList("나의 현재 대출 내역입니다.");
	
    private final String value;

    OutputMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
