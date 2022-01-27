package khie;

import java.util.Scanner;

/*
 * 다중 for문을 사용하여 *을 찍어내세요
 */

public class Exam3 {

	public static void main(String[] args) {
		
//		for(int i=1; i<=6; i++) {
//			for(int j=1; j<=i; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		for(int i=1; i<=5; i++) {
//			for(int j=1; j<=(6-i); j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		
		// 다른 공식
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("별의 최대 갯수를 입력하세요. >>> ");
		
		int starCount = sc.nextInt();
		
		// 전체 라인 수는 (입력받은 별의 최대 갯수 * 2 - 1)
		
		for(int i=1; i<=(starCount * 2 - 1); i++) {
			int line = (i <= starCount) ? i : (starCount * 2 - i );
		
			for(int j=1; j<line; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		sc.close();
	}
}
