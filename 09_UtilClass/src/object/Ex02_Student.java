package object;

import java.util.Scanner;

public class Ex02_Student {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("학생의이름 , 학번 , 학과, 연락처를 입력하세요... ");
		
		Student st = new Student(sc.next(),sc.next(),sc.next(),sc.next());
		
		System.out.println("학생 정보");
		
		System.out.println(st.toString());
		
		sc.close();
	}
}
