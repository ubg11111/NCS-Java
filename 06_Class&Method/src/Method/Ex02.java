package Method;

import java.util.Scanner;

public class Ex02 {
	
	
	public static void total() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("수를 입력하세요. >>> ");
		
		int su = sc.nextInt();
		
		int sum = 0;
		
		for(int i=1; i<=su; i++) {
			
			sum += i;
		}
		
		System.out.println(su + " 까지의 합 : " + sum);
		
		sc.close();
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("프로그램 시작");
		
		// [문제] 1부터 키보드로 입력받은 수까지의
		// 		합을 구하는 메서드를 호출해 보세요.
		
		total();
		
		System.out.println("프로그램 종료");
	}
}
