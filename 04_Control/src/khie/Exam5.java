package khie;


/*
 * [문제1] 1 - 2 + 3 - 4 + 5 - 6 + 7 - 8 + 9 - 10 ..... - 100
 * 		  을 실행한 결과값을 화면에 출력해 보세요.
 */

public class Exam5 {

	public static void main(String[] args) {
		
		int sum = 0;
		
		for(int i=1; i<=100; i++) {
			if((i % 2) == 1) {
				sum += i;
			} else if((i% 2) != 1) {
				sum -= i;
			}
		}
		System.out.println("sum ==> " + sum);
	}
}
