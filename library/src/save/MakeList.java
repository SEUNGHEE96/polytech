package save;

import java.util.ArrayList;
import java.util.List;

import entity.Book;
import entity.Loan;
import entity.Member;

public class MakeList {

	CSVReader cr = new CSVReader();

	public List<Member> memberlist() {
		List<List<String>> list = cr.readCSV("member.csv");
		List<Member> memberlist = new ArrayList<>();
		for (int i = 1; i < list.size(); i++) {
			List<String> l = list.get(i);
			Member mem = new Member(Integer.parseInt(l.get(0)), l.get(1), l.get(2), l.get(3), l.get(4), l.get(5));
			memberlist.add(mem);
		}
		return memberlist;
	}

	public List<Book> booklist() {
		List<List<String>> list = cr.readCSV("book.csv");
		List<Book> booklist = new ArrayList<>();
		for (int i = 1; i < list.size(); i++) {
			List<String> l = list.get(i);
			Book b = new Book(Integer.parseInt(l.get(0)), l.get(1), l.get(2), Boolean.valueOf(l.get(3)));
			booklist.add(b);
		}
		return booklist;
	}

	public List<Loan> loanlist() {
		List<List<String>> list = cr.readCSV("loan.csv");
		List<Loan> loanlist = new ArrayList<>();
		for (int i = 1; i < list.size(); i++) {
			List<String> l = list.get(i);
			Loan loan = new Loan(Integer.parseInt(l.get(0)), l.get(1), l.get(2), Boolean.valueOf(l.get(3)), l.get(4),
					Integer.parseInt(l.get(5)), Boolean.valueOf(l.get(6)));
			loanlist.add(loan);
		}
		return loanlist;
	}

}
