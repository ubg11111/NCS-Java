package khie;

import java.util.Scanner;

/*
 * [문제] 지방(fat), 탄수화물(carbohydrat), 단백질(protein)
 * 		칼로리의 합계를 계산하는 프로그램
 * 		지방, 탄수화물 , 단백질의 그램을 키보드 입력(Scanner 사용)
 * 		총 칼로리 구하기
 * 			지방 1그램 : 9칼로리
 * 			단백질과 탄수화물 1그램 : 4칼로리
 * 			총 칼로리 = 지방 * 9 + 단백질 * 4 + 탄수화물 * 4 
 */

public class Exam1 {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("지방의 그램을 입력하세요 >>> ");
		
		int fat = sc.nextInt();
		
		System.out.print("탄수화물의 그램을 입력하세요 >>> ");
		
		int car = sc.nextInt();
		
		System.out.print("단백질의 그램을 입력하세요 >>> ");
		
		int pro = sc.nextInt();
		
		int total = ((fat * 9) + (pro * 4) + (car *4));
		
		System.out.println("총 칼로리 : " + total + "cal");
	
		sc.close();
	}
}
