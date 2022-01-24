package khie;


/*
 * [문제] 이름과 국어점수 , 영어점수 , 수학점수 , 자바점수를
 * 		키보드로 입력을 받아서 성적을 처리해보세요.
 * 
 * 		총점 , 평균까지 출력해 보자.
 */


public class Exam_01 {

	public static void main(String[] args) {

		// 1. 키보드로 이름 , 국어 , 영어 , 수학 , 자바점수를 입력을 받자.
		
		String name = args[0];
		int kor = Integer.parseInt(args[1]); // 국어점수
		int eng = Integer.parseInt(args[2]); // 영어점수
		int mat = Integer.parseInt(args[3]); // 수학점수
		int java = Integer.parseInt(args[4]); // 자바점수
		
		System.out.println("이름 = " + name);
		System.out.println();
		System.out.println("국어점수 = " + kor + "점");
		System.out.println();
		System.out.println("영어점수 = " + eng + "점");
		System.out.println();
		System.out.println("수학점수 = " + mat + "점");
		System.out.println();
		System.out.println("자바 점수 = " + java + "점");
		System.out.println();
		
		
		
		//총점을 구하자
		int total = kor+eng+mat+java;
		System.out.println("총점 = " + total + "점");
		System.out.println();
		
		//평균을 구하자
		double avg = total / 4.0;
		System.out.printf("평균 = %.2f점%n ", avg);
		System.out.println();
	}
}
