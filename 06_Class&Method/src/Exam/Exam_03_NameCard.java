package Exam;

import java.util.Scanner;

class NameCard{
	
	// 멤버변수 (인스턴스변수) 이름 , 전화번호 , 주소 , 직급을 초기

	String name;
	String phone;
	String addrs;
	String rank;

	// 멤버메서드(인스턴스메서드) 멤버 변수값을 콘솔에 출력한다.
	
	void display() {
		System.out.println("=======================");
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phone);
		System.out.println("주소 : " + addrs);
		System.out.println("직급 : " + rank);
	}
}


public class Exam_03_NameCard {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("이름, 전화번호, 주소, 직급을 입력하세요.");
			
		NameCard id = new NameCard(); 
		
	
		id.name = sc.nextLine();
		id.phone = sc.nextLine();
		id.addrs = sc.nextLine();
		id.rank = sc.nextLine();
		id.display();
		
		sc.close();
	}
}
