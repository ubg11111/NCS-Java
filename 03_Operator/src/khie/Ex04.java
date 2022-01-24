package khie;

/*
 * 4. 단항연산자 / 이항연산자 / 3항연산자 
 * 	- 단항연산자 : 1개의 항을 대상으로 연산을 수행.
 * 	- 이항연산자 : 2개의 항을 대상으로 연산을 수행.
 *  - 3항연산자 : 3개의 항을 대상으로 연산을 수행.
 */


public class Ex04 {

	public static void main(String[] args) {
		
		// 단항연산자(++, --) 
		int su1 = 10, su2 =10;
		
		System.out.println("su1 ++ = " + su1++); // 후위형 - su1본래의 값을 출력 후 다음에 증가시키고 출력 
		System.out.println("++su1 = " + ++su2); // 전위형 - su1본래의값을 증가시키고 출력
	
	
		/*
		 *  단항연산자(++, --)
		 *  -전위연산자 : 단항연산자가 변수명 앞에 온다. ++i , 변수의 값을 하나 증가 또는 감소시킨 후 처리
		 *  -후위연산자 : 단항연산자가 변수명 뒤에 온다. i++ , 변수의 값을 처리한 후 증가 또는 감소 처리
		 */
		
		int su3 = 10 , su4 = 20;
		
		System.out.println(++su3 + su4++);
		System.out.println();
		
		System.out.println((++su3 % 3) + (su3 * ++su4)); 
		System.out.println();
		
		
		/*
		 * 3항 연산자
		 * 형식) 
		 * 	(조건) ? 수식1 : 수식2 = 수식1 true , 수식2 false
		 * 
		 * - 간단한 조건문을 대신해서 사용하는 연산자.
		 */
		
		int num1 = 45, num2 = 23;
		
		
		// String 자료형은 참조형자료로 문자열인 "" 자료를 저장할 때 사용.
		String result = ((num1 > num2) ? "num1값이 크다" : "num2값이 크다");
		System.out.println("result의 삼항연산자 값은 = " + result);
	}
}
