package Class;

import java.util.Scanner;

public class Ex06_Member {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("회원의 이름, 나이, 연락처 , 직업을 순서대로 입력해주세요.");
		
		// 매개변수 생성자 (인자를 통해서 값을 입력해주면 그대로 출력이가능)
		Member member = new Member(sc.next(), sc.nextInt(), sc.next() , sc.next());
		
		member.display();
		
		System.out.println();
		
		
		// 기본생성자로 출력 클래스에 매개변수가 없는것..
		Member member2 = new Member();
		
		member2.name = "이순신";
		member2.age = 22;
		member2.phone = "010-5555-4442";
		member2.job = "나라를 구한 영웅";
		member2.display();
		
		System.out.println();
		
		sc.close();
	}
}
