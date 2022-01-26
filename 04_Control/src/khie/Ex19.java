package khie;

/*
 * 2. 반복문
 * 	- 반복해서 실행할 때 사용하는 문장.
 * 	- 반복문의 종류 : while문 , do ~ while문 , for문
 */

/*
 *  while 반복문
 *   - 조건식을 비교하여 참인 경우 계속해서 반복 실행문을 실행하고,
 *   	조건식이 거짓인 경우 반복문을 탈출한다.
 *   - while 반복문은 반복문의 횟수를 알 수 업슨ㄴ 경우에 많이 사용됨.
 *   - 반복문에는 반드시 초기식, 조건식, 증감식이 존재해야 함.
 *   
 *   	형식)
 *   		while(조건식) {
 *   			반복 실행 문장;	
 *  	}
 */


/*
 * do ~ while 반복문
 * - 먼저 반복 실행문을 실행하고 조건식을 비교함.
 * 
 * 	형식) 
 * 		do{
 * 			반복 실행 문장;
 * 		} while(조건식);
 */

public class Ex19 {

	public static void main(String[] args) {
		for(int i=0; i<10; i++) { // for문을 이용하여 1~10까지 출력한 방법.
			System.out.println("for = " + (i + 1));
		}
		
		// while 반복문을 이용하여 1 ~ 10까지 출력해 보자.
		
		int num = 1; // 반복문에서의 초기식
		
		while(num <= 10) { // 반복문에서의 조건식
			System.out.println("while >>>" + num) ;
			num++; // 증감연산자(단항연산자) 후위형
		}
		
		System.out.println();
		
		// do ~ while 반복문을 이용하여 1 ~ 10까지 출력 해 보자.
		
		int number = 1;
		do {
			System.out.println("number ===> " + number);
			number++;
		} while(number >= 10); // do while문은 do문장을 먼저 실행해보고 while 조건식을 비교해보기에 조건이 거짓이여도 실행은 가능 (다만 조건식에 부합하지않음)
	}
}
