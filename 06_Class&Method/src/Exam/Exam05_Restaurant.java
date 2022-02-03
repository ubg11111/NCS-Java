package Exam;

import java.util.Scanner;

public class Exam05_Restaurant {
	
	public static final double TAX_RATE = 1.1; // 부가세액 static 상수 (상수는 대문자로만 표현)
	
	public static void main(String[] args) {
	
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("메뉴는 몇 개인가요? : ");
		
		Restaurant[] res  = new Restaurant[sc.nextInt()]; // 객체배열(sc.nextInt)스캐너로 저장
		
		// 메뉴와 단가 , 수량을 키보드로 입력을 받아서 객체 배열의 각각의 index에 저장
		for(int i=0; i<res.length; i++) {
			System.out.println((i+1) + " 번째 메뉴의 품명, 단가, 수량을 입력하세요.......");
			
			res[i] = new Restaurant(sc.next(),sc.nextInt(),sc.nextInt());
		}
		
		System.out.println();
		
		int totalPrice = 0;  // 총금액 변수
		
		System.out.println("------------------------------------------");
		System.out.println("품명\t단가\t수량\t금액");
		System.out.println("------------------------------------------");
		
		for(int i=0; i<res.length; i++) {
			System.out.printf("%s\t%,d\t%d\t%,d원%n", res[i].name , res[i].unitPrice, res[i].amount, (res[i].unitPrice * res[i].amount));
			
			
			totalPrice += (res[i].unitPrice * res[i].amount);
		}
		
		// 공급가액을 구하자 ==> 총금액(totalPrice) / 부가세액 
		int supplyPrice = (int)(totalPrice / Exam05_Restaurant.TAX_RATE);
	
		// 부가세액을 구하자 ==> 총금액 - 공급가액
		int vat =  totalPrice - supplyPrice;
		
		
		System.out.println("--------------------------------------");
		System.out.printf("공급가액\t\t\t%,d원\n",supplyPrice);
		System.out.printf("부가세액\t\t\t%,d원\n",vat);
		System.out.println("--------------------------------------");
		System.out.printf("청구금액\t\t\t%,d원\n",totalPrice);
	
		sc.close();
	}
}
