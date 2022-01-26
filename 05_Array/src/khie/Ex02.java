package khie;

import java.util.Scanner;

/*
 * 내가 여행가고 싶은 5개 나라를
 * 키보드로 입력을 받아서 배열에 저장해 보자.
 */

public class Ex02 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String[] nations = new String[5];
		
//		System.out.print("첫번 째 나라 입력 >>> ");
//		
//		nations[0] = sc.next();
//		
//		System.out.print("두번 째 나라 입력 >>> ");
//		
//		nations[1] = sc.next();
//		
//		System.out.print("세번 째 나라 입력 >>> ");
//		
//		nations[2] = sc.next();
//		
//		System.out.print("네번 째 나라 입력 >>> ");
//		
//		nations[3] = sc.next();
//		
//		System.out.print("다섯 째 나라 입력 >>> ");
//		
//		nations[4] = sc.next();
		
		
		// 반복문을 이용하여 5개 나라 입력 하기
		for(int i=0; i<nations.length; i++) {
			System.out.print((i + 1) + "번째 나라 입력 >>> ");
			
			nations[i] = sc.next();
		}
		
		System.out.println();
		
		// 배열에 저장된 5개 나라를 반복문을 이용하여 화면에 출력해 보기
		for(int i=0; i<nations.length; i++) {
			System.out.println((i+1) + "번째 가고 싶은 나라 : " + nations[i]);
		}
		
		sc.close();
	}
}
