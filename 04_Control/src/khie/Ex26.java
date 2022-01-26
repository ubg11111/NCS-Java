package khie;

import java.util.Scanner;

// 숫자 맞추기 게임


public class Ex26 {

	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in);
		
		System.out.println("**** 숫자 맞추기 게임 ****");
		
		int num = (int)(Math.random() * 99) + 1; // double 기본형이기에 int 형변환
	
		System.out.println("1 ~ 99 사이의 숫자중에서 하나의 숫자를 맞추세요.");
		
		int count = 0; // 몇 번 입력하여 맞추는지 카운트하는 변수
		
		int su = 0; // 키보드로 입력 받은 수 
		
		while(su != num) {
			System.out.print("어떤 숫자일까요 >>> ");
			
			su = sc.nextInt();
			
			if(su > num) {
				System.out.println("더 작은 숫자 입니다.");
			}else if(su < num) {
				System.out.println("더 큰 숫자 입니다.");
			} 
			System.out.println("-----------------------");
			
			count++;
		}
		System.out.println("정답입니다");
		System.out.println("정답 숫자 >>> " + num + "입니다.");
		System.out.println("정답을 맞추는데 소요 횟수 >>> " + count);
		
		sc.close();
	}
}
