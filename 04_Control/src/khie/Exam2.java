package khie;

import java.util.Scanner;

/*
 * [문제] 1부터 사용자가 입력한 수까지의 합 구하기
 *  	예) 100을 입력하면 1에서 100까지의 홀수 합과 짝수 합계 출력
 */

public class Exam2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("홀수를 입력하세요 >>> ");
		
		int oddSum = sc.nextInt();
		
		System.out.print("짝수를 입력하세요 >>> ");
		
		int evenSum = sc.nextInt();
		
		for(int i=0; i<=100; i++) {
			if((i % 2) == 1) {
				oddSum += i;
			} else {
				evenSum += i;
			}
		}
		System.out.println("홀수의 합계 >>> " + oddSum);
		System.out.println("짝수의 합계 >>> " + evenSum);
		
		sc.close();
	}
}
