package console;

public enum OutputMessage {
	wrongNumber("잘못된 입력입니다"),
	addMember("등록이 완료되었습니다!"),
	editMember("수정이 완료되었습니다!"),
	deleteMember("삭제가 완료되었습니다!"),
	failToDelete("삭제할 회원이 없습니다!"),
	rollbackMember("삭제 취소 되었습니다"),
	failToRollback("취소할 삭제 내역이 없습니다"),
	availablelist("대출 가능한 책 목록입니다"),
	loanBook("대출 완료 되었습니다"),
	extendablelist("연장 신청 가능 목록입니다"),
	unextendablelist("연장 신청 가능한 목록이 없습니다."),
	extendBook("연장 되었습니다"),
	failToExtend("연장할 책이 없습니다"),
	finishMain("종료합니다");
    
    private final String value;

    OutputMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
