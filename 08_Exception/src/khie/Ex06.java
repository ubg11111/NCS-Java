package khie;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex06 {

	public static void main(String[] args) {
		
		System.out.println("프로그램 시작");
		
		Scanner sc = new Scanner(System.in);
		
		try {
		int su = sc.nextInt();
		System.out.println("입력받은 수 >>> " + su);
		}
		
		catch(Exception e) {
			// e.printStackTrace(); 해당 메서드를 사용하게되면 try문에서 발생한 임의의 오류를 무저건적으로 잡아내고 오류상황을 출력함
			e.printStackTrace();
			System.out.println("숫자를 입력해주셔야 합니다.");
			System.out.println("예외(오류) 정보 >>> " + e);
		}
		
		finally {
			// 입출력과 관련된 데이터를 처리하는 코드
			sc.close();
		}
		
		System.out.println("프로그램 종료");
		
	}
}
