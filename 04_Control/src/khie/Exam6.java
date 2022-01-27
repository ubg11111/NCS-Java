package khie;

import java.util.Scanner;

/*
 * [문제2] coffee 메뉴를 키보드로 입력을 받고 주문수량과
 * 			입금액을 입력하면 아래 화면과 같이 출력되게 하세요.
 * 			* 총금액에는 부가세가 포함된 금액이 나와야 함.
 */

public class Exam6 {

	public static void main(String[] args) {
		
		System.out.println("*** coffee 메뉴 ***");
		System.out.println("1. 아메리카노 - 3,000원");
		System.out.println("2. 카페라떼 - 4,000원");
		System.out.println("3. 마키야또 - 4,500원");
		System.out.println("4. 바닐라라떼 - 4,500원");
		
		System.out.println();
		
		String ame = "아메리카노";
		String rate = "카페라떼";
		String makiato = "마키야또";
		String vanila = "바닐라라떼";
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("위 메뉴 중 하나를 선택 하세요. : ");
		
		int menu = sc.nextInt();
		
		System.out.print("주문수량 >> ");
		
		int su = sc.nextInt();
		
		System.out.print("입금액 >> " );
		
		int inMoney = sc.nextInt();
		
		
 	
		if(menu == 1) {
			int price = 3000;
			int total = (int)((price*su) * 1.1);
			
			System.out.println("주문한 메뉴 : " + ame);
			System.out.println("커피단가 : " + (su*price) + "원");
			System.out.println("주문수량 : " + su + "개");
			System.out.println("입금액 : " + inMoney + "원");
			System.out.println("총금액 : " + total + "원");
			System.out.println("거스름돈 : " + (inMoney - total) + "원");
		} else if(menu == 2) {
			int price = 4000;
			int total = (int)((price*su) * 1.1);
			
			System.out.println("주문한 메뉴 : " + rate);
			System.out.println("커피단가 : " + (su*price) + "원");
			System.out.println("주문수량 : " + su + "개");
			System.out.println("입금액 : " + inMoney + "원");
			System.out.println("총금액 : " + total + "원");
			System.out.println("거스름돈 : " + (inMoney - total) + "원");
		} else if(menu == 3) {
			int price = 4500;
			int total = (int)((price*su) * 1.1);
			
			System.out.println("주문한 메뉴 : " + makiato);
			System.out.println("커피단가 : " + (su*price) + "원");
			System.out.println("주문수량 : " + su + "개");
			System.out.println("입금액 : " + inMoney + "원");
			System.out.println("총금액 : " + total + "원");
			System.out.println("거스름돈 : " + (inMoney - total) + "원");
		} else if(menu == 4) {
			int price = 4500;
			int total = (int)((price*su) * 1.1);
			
			System.out.println("주문한 메뉴 : " + vanila);
			System.out.println("커피단가 : " + (su*price) + "원");
			System.out.println("주문수량 : " + su + "개");
			System.out.println("입금액 : " + inMoney + "원");
			System.out.println("총금액 : " + total + "원");
			System.out.println("거스름돈 : " + (inMoney - total) + "원");
		}
		sc.close();
	}
}
