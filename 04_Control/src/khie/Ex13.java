package khie;

import java.util.Scanner;

/*
 *  [문제] 이름과 국어점수, 영어점수 , 수학점수 , 자바점수를 
 *  	키보드로 입력을 받아서 성적을 처리해 보자.
 *  	총점, 평균 , 학점까지 출력해보자.
 */



public class Ex13 {

	public static void main(String[] args) {
		
		// 스캐너를 활용하여 화면출력
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름을 입력해주세요  ==>");
		
		String name = sc.next();
		
		System.out.print("국어점수를 입력해주세요 ==>");
		
		int kor = sc.nextInt();
		
		System.out.print("영어점수를 입력해주세요 ==>");
		
		int eng = sc.nextInt();
		
		System.out.print("수학점수를 입력해주세요 ==>");
		
		int mat = sc.nextInt();
		
		System.out.print("자바점수를 입력해주세요 ==>");
		
		int java = sc.nextInt();
		System.out.println();
		
		int total = kor+eng+mat+java;
		
		double avg = total / 4.0;
		
		
		// 개인점수 출력
		System.out.printf("국어점수는 %d입니다.\t", kor);
		System.out.printf("영어점수는 %d입니다.\t", eng);
		System.out.printf("수학점수는 %d입니다.\t", mat);
		System.out.printf("자바점수는 %d입니다.%n", java);
		System.out.println();
		
		// 총점 출력
		System.out.println(name + "님의 총점은 " + total + "입니다.");
		
		// 평균점수 출력
		System.out.printf("%s님의 평균은 %.2f입니다.%n", name , avg);
		
		
		// 학점 출력 
		if(total >= 300) {
			System.out.println(name + "님의 학점은 A학점 입니다.");
		} else if(total >= 200) {
			System.out.println(name + "님의 학점은 B학점 입니다.");
		} else if(total >= 100) {
			System.out.println(name + "님의 학점은 C학점 입니다.");
		} else {
			System.out.println(name + "님의 학점은 D학점 입니다.");
		}
		
		sc.close();
	}
}
