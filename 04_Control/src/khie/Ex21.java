package khie;

public class Ex21 {

	public static void main(String[] args) {
		// ABCDEFGHIJKLMN...XYZ 까지 문자를 출력해 보자.
		
		char alpha = 'A';
		
		while(alpha <= 'Z') {
			System.out.print(alpha);
			alpha++;
		}
		System.out.println();
		System.out.println();
		// ZYX ... DCBA 반대로 출력해보자
		
		char alpha1 = 'Z';
		
		while(alpha1 >= 'A') {
			System.out.print(alpha1);
			alpha1--;
		}
	}
}
