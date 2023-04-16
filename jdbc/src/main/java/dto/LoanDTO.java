package dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class LoanDTO implements Comparable<LoanDTO> {
	int id; // id
	int memberID; // 회원ID (FK)
	String title; // 책 제목 -책ID (FK)로 부터 읽어오는 것
	boolean isReturned; // 반납여부
	Date loanDate; // 대출일
	int daysLeft; // 대출 만료일까지 남은 일 수
	boolean isRenewed; // 연장여부

	public LoanDTO() {

	}

	public LoanDTO(int id, int memberID, String title, boolean isReturned, Date loanDate, int daysLeft,
			boolean isRenewed) {
		super();
		this.id = id;
		this.memberID = memberID;
		this.title = title;
		this.isReturned = isReturned;
		this.loanDate = loanDate;
		this.daysLeft = daysLeft;
		this.isRenewed = isRenewed;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMemberID() {
		return memberID;
	}

	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String bookTitle) {
		this.title = bookTitle;
	}

	public boolean isReturned() {
		return isReturned;
	}

	public void setReturned(boolean isReturned) {
		this.isReturned = isReturned;
	}

	public Date getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}

	public int getDaysLeft() {
		return daysLeft;
	}

	public void setDaysLeft(int daysLeft) {
		this.daysLeft = daysLeft;
	}

	public boolean isRenewed() {
		return isRenewed;
	}

	public void setRenewed(boolean isRenewed) {
		this.isRenewed = isRenewed;
	}

	@Override
	public int compareTo(LoanDTO l) {
		// 반납 기준으로 오름차순 정렬
		return this.daysLeft - l.daysLeft;
	}

	@Override
	public int hashCode() {
		return Objects.hash(title, daysLeft, id, isRenewed, isReturned, loanDate, memberID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoanDTO other = (LoanDTO) obj;
		return title == other.title && daysLeft == other.daysLeft && id == other.id && isRenewed == other.isRenewed
				&& isReturned == other.isReturned && Objects.equals(loanDate, other.loanDate)
				&& memberID == other.memberID;
	}

	@Override
	public String toString() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
	    String formattedloanDate = formatter.format(loanDate);
		return "Loan [책제목=" + title + ", 반납여부=" + isReturned
				+ ", 대출일=" + formattedloanDate + ", 반납기한=" + daysLeft + "일, 연장여부=" + isRenewed + "]";
	}

}
