package entity;

import java.util.Objects;

public class Book implements Comparable<Book>{
	int id; //id
	String title; //제목
	String issueDate; //출간일
	boolean returnStatus; //반납여부
	
	public Book () {
		
	}
	
	public Book(int id, String title, String issueDate, boolean returnStatus) {
		super();
		this.id = id;
		this.title = title;
		this.issueDate = issueDate;
		this.returnStatus = returnStatus;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	public boolean isReturnStatus() {
		return returnStatus;
	}
	public void setReturnStatus(boolean returnStatus) {
		this.returnStatus = returnStatus;
	}

	@Override
	public int compareTo(Book o) {
		// 출간일을 기준으로 오름차순으로 정렬
	    return this.issueDate.compareTo(o.issueDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, issueDate, returnStatus, title);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return id == other.id && Objects.equals(issueDate, other.issueDate) && returnStatus == other.returnStatus
				&& Objects.equals(title, other.title);
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", issueDate=" + issueDate + ", returnStatus=" + returnStatus
				+ "]";
	}

}
