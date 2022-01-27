package khie;

import java.util.Scanner;

public class Exam3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("학생 수를 입력하세요. >>> ");
		
		
		
		// 1. 학생이름 , 국어점수 , 영어점수 , 수학점수 , 총점 , 평균 , 학점 , 순위 배열이 필요함.
		
		String[] name = new String[sc.nextInt()];
		
		int[] kor = new int[name.length];
		int[] eng = new int[kor.length];
		int[] mat = new int[eng.length];
		int[] sum = new int[mat.length];
		double[] avg = new double[sum.length];
		String[] grade = new String[avg.length];
		int[] rank = new int[grade.length];
		
		
		// 2. 학 생 수 만큼 이름 , 국어점수 , 영어점수 , 수학점수를
		// 키보드로 입력을 받아서 각각의 배열에 저장을 해 주자.
		
		for(int i=0; i<name.length; i++) {
			//// 이름과 각 과목의 점수를 배열에 저장
			
			System.out.print("이름을 입력하세요 >>> ");
		
			name[i] = sc.next();
			
			System.out.print("국어 점수를 입력하세요 >>> ");
			
			kor[i] = sc.nextInt();
			
			System.out.print("영어 점수를 입력하세요 >>> ");
			
			eng[i] = sc.nextInt();
			
			System.out.print("수학 점수를 입력하세요 >>> ");
			
			mat[i] = sc.nextInt();
			
			/// 총점과 평균 그리고 학점을 구해 주자.
			
			
			// 총점을 구해보자
			sum[i] = kor[i] + eng[i] + mat[i];
			
			
			/// 평균을 구해보자
			
			avg[i] = sum[i] / 3.0;
			
			// 학점을 구해보자.
			
			if(avg[i] >=90) {
				grade[i] = "A학점";
			} else if(avg[i] >= 80) {
				grade[i] = "B학점";
			} else if(avg[i] >= 70) {
				grade[i] = "C학점";
			} else if(avg[i] >= 60) {
				grade[i] = "D학점";
			}else {
				grade[i] = "F학점";
			}
			
			// 석차를 구하자.
			
			// 모든 학생은 자기가 1등인것을 예상
			rank[i] = 1;
		}
		
		// 실제로 석차를 구해 보자.
		for(int i=0; i<name.length; i++) {
			for(int j=0; j<name.length; j++) {
				if(sum[j] > sum[i]) {
					rank[i]++; // 내 등수가 하나씩 올라감
				}
			}
		}
		
		// 마지막으로 성적을 화면에 출력해 보자.
		for(int i=0; i<rank.length; i++) {
			System.out.println(":::::::::::::::::::::::::::::::::");
			System.out.print("이름 : " + name[i] + "\t");
			System.out.print("총점 : " + sum[i] + "점\t");
			System.out.printf("평균 : %.2f점\t", avg[i]);
			System.out.print("학점 : " + grade[i] + "\t");
			System.out.println("석차 : " + rank[i] + "등");
			System.out.println();
		}
		
		sc.close();
	}
}
