package message;

public enum OutputMessage {
	
	wrongNumber("잘못된 입력입니다."),
	availablelist("대출 가능한 책 목록입니다."),
	extendablelist("연장 신청 가능 목록입니다."),
	unextendablelist("연장 신청 가능한 목록이 없습니다."),
	failToExtend("연장할 책이 없습니다."),
	finishMain("종료합니다.");
    
    private final String value;

    OutputMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
