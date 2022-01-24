package khie;

public class Ex07 {

	public static void main(String[] args) {
		
		
		// 두 수를 서로 교환을 해 보자.
		
		int su1 = 47;
		
		int su2 = 82;
		
		// 변경하기전 값
		System.out.println("su1 = " + su1 + ", su2 = " + su2);
		System.out.println();
		
		
		int tmp;
		
		tmp = su1;
		su1 = su2;
		su2 = tmp;
		
		
		// 변경 후 값
		System.out.println("su1 = " + su1 + ", su2 = " + su2);
	}
}
