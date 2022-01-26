package khie;

/*
 * 3. 기타(보조 제어문)
 * 	-continue 명령어.
 * 	- 반복문에서만 사용되는 명령어.
 * 	- 반복문을 탈출하는 것이 아니라, 다음 증감식으로 가는 명령어.
 */


public class Ex35 {

	public static void main(String[] args) {
		
		for(int i =1; i<=10; i++) {
			
			if((i % 2) ==1) { // 홀수인 경우 
				continue; // 홀수를 제외하고 나머지값은 출력하면서 반복문 계속 진행
			}
			System.out.println("i >>> " + i); // 짝수만 출력
		
		
			System.out.println();
			
		}
		
		int sum = 0;
		
		for(int i=1; i<=100; i++) {
			
			if((i % 2 )== 1) {
				continue;
			}
			
			sum += i;
		}
		
		System.out.println("sum >>>" + sum);
	}
}
