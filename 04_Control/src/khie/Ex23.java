package khie;

import java.util.Scanner;

/*
 * [문제] 키보드로 입력받은 수까지의 홀수의 합과
 * 		짝수의 합을 구하여 화면에 출력해 보세요.
 * 		(단, while 반복문을 이용하여 처리할 것)
 */


public class Ex23 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요 => ");
		
		int max = sc.nextInt();
		
		int su = 1;
		
		int oddSum =0, evenSum=0;
		
		
		while(su <= max) {
			if((su % 2) == 1) {
				oddSum += su;
			} else {
				evenSum += su;
			}
			su++;
		}
		
		System.out.println("짝수의 합은 : " + oddSum + "입니다.");
		System.out.println("홀수의 합은 : " + evenSum + "입니다.");
		
		sc.close();
	}
}
