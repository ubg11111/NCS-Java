package khie;

import java.util.Scanner;

public class Exam2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수형 배열의 크기 입력 >>> ");
		
		int[] score = new int[sc.nextInt()];
		
		for(int i=0; i<score.length; i++) {
			
			System.out.print((i+1) + " 번째 정수 입력 >>> ");
			
			score[i] = sc.nextInt();
		}
		
		// 내림차순으로 정렬을 진행해 보자.
		int temp = 0;
		
		for(int i=0; i<score.length; i++) {
			for(int j=i+1; j<score.length; j++) {
				if(score[j] > score[i]) {
					temp = score[i];
					score[i] = score[j];
					score[j] = temp;
				}
			}
		}
		
		// 내림차순으로 정렬된 배열을 화면에 출력해 보자
		for(int i=0; i<score.length; i++) {
			System.out.println("score["+i+"] >>> " + score[i]);
		}
		
		
		sc.close();
	}
}
