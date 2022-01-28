package Method;

import java.util.Scanner;

/*
 * 매개변수가 있는 메서드 정의.
 * 
 * 형식) [접근제한] 반환형 메서드이름(type 변수1 , type 변수2) {
 * 				
 * 				메서드 호출 시 실행 문장 ;
 * 			}
 * 
 * - 실인수와 가인수
 * 	 실인수 : 매개변수에 전달할 실제 값 ==> 메서드를 호출할 때 사용.
 * 	 가인수 : 매개변수(가인수) ==> 메서드에 정의.
 * 	 실인수와 가인수는 반드시 type, 순서, 갯수가 일치해야 함.(중요한내용)
 */


public class Ex03 {
	
	public static void total(int k , int e, int m) { // 가인수 k =95 , e = 88 , m = 92 값이 각각 저장됨 .. 매개변수(가인수) 자료형을 지정해주어야한다.
		System.out.println("sum = > " + (k + e + m));
	}
	
	public static void total(int su) {
		
		int sum = 0;
		
		for(int i=1; i<=su; i++) {
			sum += i;
		}
		System.out.println("1 부터 " + su + " 까지의 합 >>> " + sum);
	}
	
	public static void main(String[] args) {
		
		total(95, 88 , 92); // 실인수 (매개변수에 전달할 실제 값 메서드를 호출할 때 사용)
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("수를 입력 하세요 >>> ");
		
		total(sc.nextInt());
		
		sc.close();
	}
}
