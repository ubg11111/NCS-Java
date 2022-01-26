package khie;

import java.util.Scanner;

/*
 * [문제] 배열에 5개의 정수를 키보드로 입력을 받아서
 * 		 저장한 후 저장된 5개의 정수를 화면에 출력해 보세요.
 */


public class Ex03 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 1. 배열 선언 및 배열 메모리 생성.
		int[] su = new int[5];
		
		
		// 2. 배열의 초기화 작업 => 5개의 정수를 키보드로 입력을 받아서 배열에 저장.
		for(int i=0; i<su.length; i++) {
			System.out.print((i+1) + "번째 수 입력 >>> " );
			
			su[i] = sc.nextInt();
		}
		
		System.out.println();
		
		
		// 3. 배열에 저장된 5개의 데이터를 출력
		for(int i=0; i<su.length; i++) {
			System.out.println((i+1) + "번째 수의 값은 >>> " + su[i]);
		}
		
		sc.close();
	}
}
