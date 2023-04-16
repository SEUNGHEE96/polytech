package view;

import java.util.ArrayList;
import java.util.List;

import message.InputMessage;

public class MemberView extends View{

	// 입력
	// 회원 이름 입력
	public String inputName() {
		System.out.print(InputMessage.inputName.getValue());
		return sc.nextLine();
	}

	// 회원 주소 입력
	public String inputAddress() {
		System.out.print(InputMessage.inputAddress.getValue());
		return sc.nextLine();
	}
	
	// 회원 전화번호 입력
	public String inputPhone() {
		System.out.print(InputMessage.inputPhone.getValue());
		return sc.nextLine();
	}
	
	// 회원 생일 입력
	public String inputBirthday() {
		System.out.print(InputMessage.inputBirthday.getValue());
		return sc.nextLine();
	}
	
	// 회원 등록 (정보 모두 입력)
	public List<String> inputMember() {
		List<String> member = new ArrayList<>();
		String name = inputName();
		member.add(name);
		String address = inputAddress();
		member.add(address);
		String phoneNumber = inputPhone();
		member.add(phoneNumber);
		String birthday = inputBirthday();
		member.add(birthday);
		//원래라면 MemberDTO 객체를 하나 만들어서 값을 삽입하는게 맞지만,
		//최대한 많은 연산을 SQL로 하기 위해 List로 반환하였음.
		return member;
	}
	
	// 회원 정보 수정 (하나의 정보만 입력)
	public List<String> updateMember() {
		List<String> updateContents = new ArrayList<>();
		String menu = sc.nextLine();
		switch(menu) {
			case "1" : 
				updateContents.add("NAME");
				updateContents.add(inputName());
				break;
			case "2" : 
				updateContents.add("ADDRESS");
				updateContents.add(inputAddress());
				break;
			case "3" : 
				updateContents.add("PHONENUMBER");
				updateContents.add(inputPhone());
				break;
			case "4" : 
				updateContents.add("BIRTHDAY");
				updateContents.add(inputBirthday());
				break;
			default :
		}
		return updateContents;
	}
	
}
