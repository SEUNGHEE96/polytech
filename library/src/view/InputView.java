package view;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entity.Member;

public class InputView {

	Scanner sc = new Scanner(System.in);
	
	public Member newMember(int id) {
		System.out.print("이름 : ");
		String name = sc.nextLine();
		Date now = new Date();
		String joinDate = new SimpleDateFormat("yyyyMMdd").format(now);
		System.out.print("주소 : ");
		String address = sc.nextLine();
		System.out.print("폰번호 : ");
		String phoneNumber = sc.nextLine();
		System.out.print("생일 : ");
		String birthday = sc.nextLine();
		Member mem = new Member(id, name, joinDate, address, phoneNumber, birthday);
		return mem;
	}

}
