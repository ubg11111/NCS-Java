package Exam;

import java.util.Scanner;

public class Exam01_Person {
	
	
	// 멤버변수 선언 (전역변수)
	String name;
	String gender;
	int age;
	
	
	// 멤버메서드 (인스턴스메서드)
	void display() {
		
		Scanner sc = new Scanner(System.in);
		
		
		name = sc.next();
		
	
		if(gender == "male") {
			gender = "male";
		} else if(gender == "female"){
			gender = "female";
		} 
		gender = sc.next();

		age = sc.nextInt();
		
		System.out.println("=====================================");
		
		System.out.println("이름 : " + name);
		System.out.println("성별 : " + gender);
		System.out.println("나이 : " + age);
		
		sc.close();
	}
	
public static void main(String[] args) {
		
		Exam01_Person person = new Exam01_Person();
		
		System.out.println("이름, 성별(male/female), 나이를 입력하세요.");
		person.display();
	}
}

