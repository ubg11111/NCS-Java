package Method;

import java.util.Scanner;

// 간단한 계산기 예제


public class Ex04 {
	
	public static void plus(int num1, int num2) {
		System.out.print("덧셈 >>> " + (num1+num2));
	}
	public static void minus(int s1, int s2) {
		System.out.print("마이너스 >>> " + (s1-s2));
	}
	public static void mul(int ss1, int ss2) {
		System.out.print("곱셈 >>> " + (ss1*ss2));
	}
	public static void divide(int sss1, int sss2) {
		System.out.print("나눗셈 >>> " + (sss1/sss2));
	}
	public static void mod(int ssss1, int ssss2){
		System.out.print("나머지 >>> " + (ssss1%ssss2));
	}
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		// 1. 키보드로부터 두개의 정수와 연산자를 입력을 받자.
		System.out.print("첫번째 정수 입력 >>> ");
		int su1 = sc.nextInt();
		
		System.out.print("두번째 정수 입력 >>> ");
		int su2 = sc.nextInt();
		
		System.out.print("연산자(+, -, *, /, %)중 하나를 입력하세요. >>> ");
	
		String op = sc.next();
		
		// 2. 연산자 변수에 입력된 연산기호를 가지고 
		// 	  해당 기호에 맞는 메서드를 호출해 보자.
		
		switch(op) {
			case "+" : 
				plus(su1, su2);
				break;
					
			case "-" : 
				minus(su1, su2);
				break;
				
			case "*" : 
				mul(su1, su2);
				break;
				
			case "/" : 
				divide(su1, su2);
				break;
				
			case "%" : 
				mod(su1, su2);
				break;
		
		}
		sc.close();
	}
}
