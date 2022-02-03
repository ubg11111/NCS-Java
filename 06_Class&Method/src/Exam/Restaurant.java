package Exam;

/*
 *  품명, 단가 , 수량은 키보드로 입력 받아서 배열에 저장한다.
 *  부가가치세율 : 1.1 이며, 클래스 멤버로 선언한다.
 *  		-예) 공급가액 = 총금액 / 1.1 (부가세율)
 * 	품명별 금액, 총금액, 공급가액, 부가세, 청구금액은 [관련 수식을]참조한다.
 * 
 */


public class Restaurant {
	
	// 멤버 변수
	String name; // 품명
	int unitPrice; // 단가
	int amount; // 수량
	
	public Restaurant() {} //기본생성자
	
	public Restaurant(String name, int unitPrice , int amount) { // 매개변수생성자
		this.name = name;
		this.unitPrice = unitPrice;
		this.amount = amount;
	}
}
