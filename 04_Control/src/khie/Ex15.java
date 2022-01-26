package khie;

import java.util.Scanner;

/*
 *  switch~case문 - 분기문(조건문) 
 *  - 식(정수 또는 char)을 사용해서 다중 분기하는 명령문.
 *  - jdk 1.7 버전부터는 공식에 String 사용이 가능함.
 *  
 *  형식)
 *  	switch(식 또는 변수 또는  값){
 *  		case 값1 : 값이1일때 실행문
 *  					break; // switch 케이스는 break; 를 통해 해당 조건문을 탈출함
 *  		case 값2 : 값이2일때 실행문
 *  					break;
 *  		case 값3 : 값이3일때 실행문
 *  					break;
 *  		default : 값1 ~ 값3 이외의 값이 들어온 경우 실행문;
 *  					// 생략도 가능함. // else 문이랑 비슷함
 *  	}
 */

public class Ex15 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1 ~ 3 사이의 숫자 중 하나를 입력하세요 ===>");
		
		int su = sc.nextInt();
		
		switch(su) {
			case 1 : 
				System.out.println("입력 받은 숫자는 1 입니다.");
				break; 
			case 2 : 
				System.out.println("입력 받은 숫자는 2 입니다.");
				break;
			case 3 :
				System.out.println("입력 받은 숫자는 3 입니다.");
				break;
			default :
				System.out.println("1 ~ 3 이외의 숫자가 입력 되었습니다.");
		}
		
		sc.close();
	}
}
