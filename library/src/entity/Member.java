package entity;

public class Member implements Comparable<Member> {
	
	int id; // id
	String name; // 이름
	String joinDate; // 가입한 날짜
	String address; // 주소
	String phoneNumber; // 폰번호
	String birthday; // 생일
	int age; // 나이

	public Member() {

	}

	public Member(int id, String name, String joinDate, String address, String phoneNumber, String birthday) {
		super();
		this.id = id;
		this.name = name;
		this.joinDate = joinDate;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
		this.age = (2023 - Integer.parseInt(birthday.substring(0, 4)) + 1);
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

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public int getAge() {
		return age;
	}

	public void setAge(String birthday) {
		this.age = (2023 - Integer.parseInt(birthday.substring(0, 4)) + 1);
	}

	@Override
	public int compareTo(Member m) {
		//id를 기준으로 오름차순 정렬
		return this.id - m.getId();
	}		

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", joinDate=" + joinDate + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + ", birthday=" + birthday + ", age=" + age + "]";
	}

}
