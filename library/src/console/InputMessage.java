package console;

public enum InputMessage {
	start("1.회원관리  2.도서관리  3.종료"),
    member("0.뒤로  1.회원조회  2.회원등록  3.회원수정  4.회원삭제  5.삭제취소"),
    addMember("등록할 회원 정보를 입력하세요"),
    deleteMember("삭제할 id를 입력하세요"),
	book("0.뒤로  1.도서전체조회  2.대출가능도서조회  3.대출이력조회  4.대출신청  5.연장신청");
    
    private final String value;

    InputMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
