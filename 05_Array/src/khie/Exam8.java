package khie;

import java.util.Scanner;

public class Exam8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수값을 입력하세요 >>> ");
		int[] score = new int[sc.nextInt()];
		
		int sum = 0;
		
		for(int i=0; i<score.length; i++) {
			System.out.print((i+1) + " 번째 배열의 정수값을 입력하세요. >>> ");
			score[i] = sc.nextInt();
			sum += score[i];
		}
		
		for(int i=0; i<score.length; i++) {
			for(int j=0; j<score.length -1 -i; i++) {
				// score.length = {4,3,2,1,5}
				// score[j] = 4 > score[j+1] = 3
				// 4가 3보다 큰경우 if조건문에 의해 아래 조건문실행
				// score[4]를 temp에 저장 > 빈 score[]에 score[j+1] 저장하여 score[3]이 저장
				// 빈스코어 score[j+1]에 저장된 temp를 초기화 
				// 결과값은 score[j+1 = 3] , score[j = 4] 서로 위치값이 바뀌게됨. ex) {[j+1 = 3],[j=4],2,1,5}
				// 상기 j문을 큰값이 나올때까지 반복하고 반복문을 종료 다시 외부 for반복문을 진행
				
				if(score[j] > score[j+1]) {
					int temp = 0;
					temp = score[j];
					score[j] = score[j+1];
					score[j+1] = temp;
				}
			}
		}
		for(int i=0; i<score.length; i++) {
			System.out.printf("오름차순 : %d%n", score[i] );
		}
		System.out.println("정수의 합은 : " + sum + "입니다");
		sc.close();
	}
}
