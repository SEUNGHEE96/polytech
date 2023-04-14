package save;

import java.util.ArrayList;
import java.util.List;

import entity.Book;
import entity.Loan;
import entity.Member;

public class Exportlist {
	
	CSVWriter csvwriter = new CSVWriter();

	public void exportMember(List<Member> memberlist) {
		List<String[]> export = new ArrayList<>();
		String[] index = {"id", "name", "joinDate", "address", "phoneNumber", "birthday", "age"};
		export.add(index);
		for(int i=0; i<memberlist.size(); i++) {
			String[] member = new String[7];
			member[0] = String.valueOf(memberlist.get(i).getId());
			member[1] = memberlist.get(i).getName();
			member[2] = memberlist.get(i).getJoinDate();
			member[3] = memberlist.get(i).getAddress();
			member[4] = memberlist.get(i).getPhoneNumber();
			member[5] = memberlist.get(i).getBirthday();
			member[6] = String.valueOf(memberlist.get(i).getAge());
			export.add(member);
		}
		csvwriter.writeCSV(export, "member.csv");
	}
	
	public void exportBook(List<Book> booklist) {
		List<String[]> export = new ArrayList<>();
		String[] index = {"id", "title", "issueDate", "returnStatus"};
		export.add(index);
		for(int i=0; i<booklist.size(); i++) {
			String[] book = new String[4];
			book[0] = String.valueOf(booklist.get(i).getId());
			book[1] = booklist.get(i).getTitle();
			book[2] = booklist.get(i).getIssueDate();
			book[3] = String.valueOf(booklist.get(i).isReturnStatus());
			export.add(book);
		}
		csvwriter.writeCSV(export, "book.csv");
	}
	
	public void exportLoan(List<Loan> loanlist) {
		List<String[]> export = new ArrayList<>();
		String[] index = {"id", "memberName", "bookTitle", "renewStatus" , "loanDate", "deadline", "extension"};
		export.add(index);
		for(int i=0; i<loanlist.size(); i++) {
			String[] loan = new String[7];
			loan[0] = String.valueOf(loanlist.get(i).getId());
			loan[1] = loanlist.get(i).getMemberName();
			loan[2] = loanlist.get(i).getBookTitle();
			loan[3] = String.valueOf(loanlist.get(i).isRenewStatus());
			loan[4] = loanlist.get(i).getLoanDate();
			loan[5] = String.valueOf(loanlist.get(i).getDeadline());
			loan[6] = String.valueOf(loanlist.get(i).isExtension());
			export.add(loan);
		}
		csvwriter.writeCSV(export, "loan.csv");
	}
	
}
