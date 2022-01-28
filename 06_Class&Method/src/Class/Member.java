package Class;

public class Member {
	
	//멤버변수
	String name; // 회원 이름
	int age; // 회원나이
	String phone; // 회원 연락처
	String job; // 회원 직업
	
	public Member() {}; // 기본생성자 생성
	
	public Member(String n, int a, String p, String j) { // 매개변수생성자 생성
		
		name = n;
		age = a;
		phone = p;
		job = j;
	}
	
	void display() {
		System.out.println("회원의 이름은 " + name + "입니다.");
		System.out.println("회원의 나이는 " + age + "입니다.");
		System.out.println("회원의 번호는 " + phone + "입니다.");
		System.out.println("회원의 직업은 " + job + "입니다.");
	}
}
