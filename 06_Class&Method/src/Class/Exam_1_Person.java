package Class;

import java.util.Scanner;

public class Exam_1_Person {
		
	String name;
	String gender;
	int age;
	
	
	void display() {
		
		Scanner sc = new Scanner(System.in);
		
		
		name = sc.next();
		
	
		if(gender == "male") {
			gender = "male";
		} else {
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
		
		Exam_1_Person person = new Exam_1_Person();
		
		System.out.println("이름, 성별(male/female), 나이를 입력하세요.");
		person.display();
	}
}

