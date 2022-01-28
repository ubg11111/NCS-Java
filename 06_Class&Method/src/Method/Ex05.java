package Method;


/*
 * ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
 	메서드 호출 방식 - 2가지
 	1. call by value 방식
 		- 값을 전달하여 호출하는 방식
 		- 매개변수가 기본자료형(int, double) 사용.
 	
 	2. call by reference 방식
 		- java에서 많이 사용하는 방식(매우 중요한 방식)
 		-주소값을 전달하여 호출하는 방식.
 		- 매개변수가 참조자료형(배열, 클래스) 사용.
 	★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
 */


public class Ex05 {
	
	public static void call(int num) { // call by value 방식 메서드기능에서 변수 초기화 후 메모리값에 저장된 변수초기화값은 없어짐
		
		System.out.println("call() 메서드 호출 ...... ");
		
		num = 100;
		
		System.out.println("num >>> " + num);
		
	}
	
	
	public static void main(String[] args) {
		
		// 1. caal by value 방식
		
		int num = 200;
		
		System.out.println("메서드 호출 전 .....");
		System.out.println("num >>> " + num);
		
		
		call(num);
		
		System.out.println("메서드 호출 후 ..... ");
		
		System.out.println("num >>> " + num);
	}
}
