package Exam;

import java.util.Scanner;

public class Exam01_Employee {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String pt = "";
		
		System.out.println("고용형태-정규직<P>, 임시직<T>를 입력하세요.");
		
		pt = sc.next();
		
		if(pt.equalsIgnoreCase("P")) {
			Permanent permanent = new Permanent();
			
			System.out.println("이름,기본급,보너스를 입력하세요");
			permanent.setName(sc.next());
			permanent.setPay(sc.nextInt());
			permanent.setBonus(sc.nextInt());
			
			System.out.println("===========================");
			System.out.println("고용형태 : 정규직");
			System.out.println("이름 : " + permanent.getName());
			permanent.getPays(); // 추상화 클래스의 반환형 메서드가 아닌 추상클래스 메서드로 재정의하여 사용
			} 
		else if (pt.equalsIgnoreCase("T")){
			Temporary temporary = new Temporary();
			
			System.out.println("이름,작업시간,시간당 급여를 입력하세요.");
			temporary.setName(sc.next());
			temporary.setPay(sc.nextInt());
			temporary.setTime(sc.nextInt());
			
			System.out.println("===========================");
			System.out.println("고용형태 : 임시직");
			System.out.println("이름 : " + temporary.getName());
			temporary.getPays(); // 추상화 클래스의 반환형 메서드가 아닌 추상클래스 메서드로 재정의하여 사용
			}
		else {
			System.out.println("값을 잘못 입력하셨습니다.");
		}
		
		sc.close();
	}
}

