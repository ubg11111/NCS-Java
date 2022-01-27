package khie;

/*
 * [문제] 다중 for문을 적용하여 다음과 같은 출력결과가 나타나도록 하시오.
 */

public class Exam4 {

	public static void main(String[] args) {
		
		char ch1 = 'A';
		
		for(int i=26; i>=1; i--) {
			for(int j=1; j<=i; j++) {
				System.out.print(ch1);
				ch1+=1;
			}
			ch1 = 'A';
			System.out.println();
		}
	}
}
