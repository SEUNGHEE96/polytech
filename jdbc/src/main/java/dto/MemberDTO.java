package dto;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MemberDTO implements Comparable<MemberDTO> {

	int id; // id
	String name; // 이름
	Date joinDate; // 가입한 날짜
	String address; // 주소
	String phoneNumber; // 폰번호
	Date birthday; // 생일
	int age; // 나이

	public MemberDTO() {

	}

	public MemberDTO(int id, String name, Date joinDate, String address, String phoneNumber, Date birthday) {
		super();
		this.id = id;
		this.name = name;
		this.joinDate = joinDate;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
		// 현재 시간을 가져옵니다.
		Calendar now = Calendar.getInstance();
		// 생일을 기준으로 Calendar 객체를 만듭니다.
		Calendar birth = Calendar.getInstance();
		birth.setTime(birthday);
		// 생일이 오늘 이후인 경우 -1 해줍니다.
		int age = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR) + 1;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int compareTo(MemberDTO m) {
		// id를 기준으로 오름차순 정렬
		return this.id - m.getId();
	}

	@Override
	public String toString() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
	    String formattedjoinDate = formatter.format(joinDate);
	    String formattedbirthday = formatter.format(birthday);
		return "Member [이름=" + name + ", 가입일=" + formattedjoinDate + ", 주소=" + address
				+ ", 연락처=" + phoneNumber + ", 생일=" + formattedbirthday + ", 나이=" + age + "]";
	}

}
