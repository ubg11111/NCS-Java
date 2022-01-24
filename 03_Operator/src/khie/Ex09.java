package khie;


// 키보드로부터 두 개의 숫자를 입력을 받자.
// 입력 받은 두 수를 이용하여 산술연산을 진행해 보자.


public class Ex09 {

	public static void main(String[] args) {
		
		
	
//	 1. 키보드로부터 두 개의 숫자를 입력을 받자. 입력받은 두 수를 숫자로 변환을 시키자.
//		String su1 = args[0]; // 첫번째 배열 [0] 인덱스를 기준으로 시작
//		String su2 = args[1];
//	
//		int num1 = Integer.parseInt(su1);
//		int num2 = Integer.parseInt(su2);
		
		
		// String(문자열) 참조형은 기본자료형과는 달리 아래 메서드기등을 사용하여 형변환을 진행해주어야한다. 기본형자료는 (type)형변환을 통해 타입형변환이 가능
		int num1 = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[1]);
			
		
		// 2. 두 수를 가지고 산술연산을 진행해 보자.
		System.out.println("두 수를 더하면 = " + (num1 + num2));
		System.out.println("두 수의 빼면 = " + (num1 -  num2));
		System.out.println("두 수의 곱하면 = " + (num1 * num2));
		System.out.println("두 수의 나누면 = " + (num1 / num2));
		System.out.println("두 수의 나머지는? = " + (num1 % num2));
		
	}
}
