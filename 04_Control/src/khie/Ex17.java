package khie;

import java.util.*;

public class Ex17 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("직급(사장/전무/부장/차장/과장/대리/사원) 중 하나의 직급을 선택하세요. => ");
		
		
		String position = sc.next();
		
		
		// jdk1.7 이후부터는 switch에서  case "String" :  문자열이 들어갈 수 있음 (형변환 x)
		
		switch(position) {
			case "사장" :
				System.out.println("사장의 급여는 1,000만원 입니다.");
				break;
			case "전무" :
				System.out.println("전무의 급여는 800만원 입니다.");
				break;
			case "부장" :
				System.out.println("부장의 급여는 650만원 입니다.");
				break;
			case "차장" :
				System.out.println("차장의 급여는 500만원 입니다.");
				break;
			case "과장" :
				System.out.println("과장의 급여는 400만원 입니다.");
				break;
			case "대리" :
				System.out.println("대리의 급여는 300만원 입니다.");
				break;
			case "사원" :
				System.out.println("사원의 급여는 200만원 입니다.");
				break;
			default : 
				System.out.println("값을 잘 못 입력하셨습니다.");
				break;
		}
		
		System.out.println();
		
		// 다중 if~else 문을 이용하여 구현한 코드.
		
		if(position.equals("사장")) { // String의 조건문 == 비교연산자는 .equals(문자열비교)메서드를 사용해야함. 
			System.out.println("사장의 급여는 1,000만원 입니다.");
		}else if(position.equals("전무")) {
			System.out.println("전무의 급여는 800만원 입니다.");
		}else if(position.equals("부장")) {
			System.out.println("부장의 급여는 650만원 입니다.");
		}else if(position.equals("차장")) {
			System.out.println("차장의 급여는 500만원 입니다.");
		}else if(position.equals("과장")) {
			System.out.println("과장의 급여는 400만원 입니다.");
		}else if(position.equals("대리")) {
			System.out.println("대리의 급여는 300만원 입니다.");
		}else if(position.equals("사원")) {
			System.out.println("사원의 급여는 200만원 입니다.");
		}else {
			System.out.println("값을 잘못 입력하였습니다.");
		}
		
		sc.close();
	}
}
