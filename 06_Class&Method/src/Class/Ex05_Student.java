package Class;

import java.util.*;

public class Ex05_Student {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("학번, 이름, 학과, 주소를 입력하세요...");
		
		
		// 클래스 인자생성을 스캐너를 통해서 입력받는 경우 매개변수에 각 스캐너값을 인자로 넣어주면 된다.
		Student student = new Student(sc.nextInt(), sc.next(), sc.next(), sc.next());
		
		student.display();
		
		sc.close();
	}
}
