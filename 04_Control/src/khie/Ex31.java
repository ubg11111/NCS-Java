package khie;

// 다중 for문을 이용하여 구구단을 만들어보자.

public class Ex31 {

	public static void main(String[] args) {
		for(int i=2; i<=9; i++) {
			
			System.out.println("*** " + i + "단 ***");
			for(int j =1; j<=9; j++) {
				System.out.printf("%d * %d = %d%n", i , j , (i*j) );
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
		
		for(int a=1; a<=9; a++) {
			System.out.println("*** " + a + "수 ***");
			for(int b=2; b<=9; b++) {
				System.out.printf("%d * %d = %d%n", b , a , (b*a));
			}
			System.out.println();
		}
	}
}
