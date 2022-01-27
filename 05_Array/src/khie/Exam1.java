package khie;

import java.util.Scanner;

/*
 * 문제) 키보드로 배열의 크기를 입력 받아서 생성된 배열요소 만큼 임의의 정수를 키보드로 입력받은 후 그 중 최대값과 최소값을 구하시오.
 */

public class Exam1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("배열의 크기를 입력하세요 >>> ");
		
		int[] su = new int[sc.nextInt()];
		
		for(int i=0; i<su.length; i++) {
			
			System.out.print((i+1) + "번째 정수값을 입력하세요 >>> ");
			
			su[i] = sc.nextInt();
		}
		
		int max = su[0];
		int min = su[0];
		
		for(int i=0; i<su.length; i++) {
			if(min > su[i]) {
				min = su[i];
			} else if(max < su[i]) {
				max = su[i];
			}
		}
		System.out.println("max : " + max);
		System.out.println("min : " + min);
	
		sc.close();
	}
}
