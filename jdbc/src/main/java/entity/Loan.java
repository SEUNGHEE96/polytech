package entity;

import java.util.Objects;

public class Loan implements Comparable<Loan>{
	int id; // id
	String memberName; // 회원이름
	String bookTitle; // 책이름
	boolean renewStatus; // 반납여부
	String loanDate; // 대출일
	int deadline; // 반납기한
	boolean extension; //연장여부
	
	public Loan() {
		
	}

	public Loan(int id, String memberName, String bookTitle, boolean renewStatus, String loanDate, int deadline,
			boolean extension) {
		super();
		this.id = id;
		this.memberName = memberName;
		this.bookTitle = bookTitle;
		this.renewStatus = renewStatus;
		this.loanDate = loanDate;
		this.deadline = deadline;
		this.extension = extension;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public boolean isRenewStatus() {
		return renewStatus;
	}

	public void setRenewStatus(boolean renewStatus) {
		this.renewStatus = renewStatus;
	}

	public String getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(String loanDate) {
		this.loanDate = loanDate;
	}

	public int getDeadline() {
		return deadline;
	}

	public void setDeadline(int deadline) {
		this.deadline = deadline;
	}
	
	public boolean isExtension() {
		return extension;
	}

	public void setExtension(boolean extension) {
		this.extension = extension;
	}
	
	@Override
	public int compareTo(Loan l) {
		//반납 기준으로 오름차순 정렬
		return this.deadline - l.deadline;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookTitle, deadline, extension, id, loanDate, memberName, renewStatus);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loan other = (Loan) obj;
		return Objects.equals(bookTitle, other.bookTitle) && deadline == other.deadline && extension == other.extension
				&& id == other.id && Objects.equals(loanDate, other.loanDate)
				&& Objects.equals(memberName, other.memberName) && renewStatus == other.renewStatus;
	}

	@Override
	public String toString() {
		return "Loan [id=" + id + ", memberName=" + memberName + ", bookTitle=" + bookTitle + ", renewStatus="
				+ renewStatus + ", loanDate=" + loanDate + ", deadline=" + deadline + ", extension=" + extension + "]";
	}

}
