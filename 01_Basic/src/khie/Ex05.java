package khie;

public class Ex05 {

	public static void main(String[] args) {
		
		// 숫자 + 숫자 => 숫자 ( 숫자의 + 역할은 덧셈의 의미)
		System.out.println(10 + 2);
		
		// 문자열 + 숫자 => 문자열(+의 역할은 연결(결합)의 의미)
		System.out.println("10" + 2);
		
		// 문자열 + 문자열 => 문자열(+의 역할은 연결(결합)의 의미)
		System.out.println("1" + "2");
		
		// 문자 + 문자 => 문자 (문자(값)으로 계산)
		System.out.println('1' + '2'); // 1은 49 + 2는 50 = 99 
		
		System.out.println("a >>>" + 10 + 2);  // 우선순위가 문자열로 결합하여 102
		
		System.out.println("a >>>" + (10+2)); // 우선순위가 (+) 괄호부터 연산하여 12 출력
	}
}
