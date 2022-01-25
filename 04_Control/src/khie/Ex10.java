package khie;

import java.util.*;

/*
 * [문제] 키보드로 입력받은 정수가 홀수인지 짝수인지 판별해 보세요..
 */

public class Ex10 {

	public static void main(String[] args) {
		
		
		// Scanner를 사용하려면 해당 기능을 import 해야된다. import java.util.*; / import java.util.Scanner
		Scanner sc = new Scanner(System.in);
		
		System.out.print("값을 입력하세요 : ");
		
		int su = sc.nextInt();
		
		
		if(su % 2 == 0) {
			System.out.println("짝수");
		} else {
			System.out.println("홀수");
		}
		
		sc.close();
	}
}
