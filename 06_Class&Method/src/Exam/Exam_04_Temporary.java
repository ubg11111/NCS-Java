package Exam;

import java.util.Scanner;

class Temporary{
	
	// 멤버변수 설정
	String name; // 입력값을 main으로부터 키보드로 입력받아 초기화 됨.
	int time; 
	int pay;
	
	void total() {
		int total = time * pay;
		System.out.printf("총 급여 %,d원%n", total);
	}
	
	void avg() {
		int total = time * pay;
		int avg = (int)(total * 0.03);
		System.out.printf("공제액 %,d원%n", avg);
	}
	
	void inMoney() {
		int total = time * pay;
		double avg = total * 0.03;
		int inMoney = (int)(total - avg);
		System.out.printf("실지급액 %,d원%n", inMoney);
	}
	
	// 멤버메서드 설정
	void myMoney() {
		System.out.println("=========================");
		System.out.println("이름 : " + name);
		total();
		avg();
		inMoney();
	}
}


public class Exam_04_Temporary {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("이름,작업시간,시간당 급여를 입력하세요.");
		
		Temporary temporary = new Temporary();
		
		temporary.name = sc.next();
		temporary.time = sc.nextInt();
		temporary.pay = sc.nextInt();
		temporary.myMoney();
		
		sc.close();
	}
}
