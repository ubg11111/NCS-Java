package inner;

/*
 * 3. 중첩 클래스 선언
 * 
 * 중첩 클래스 (inner class)?
 * 1. 클래스 내부에 또 다른 클래스 선언.
 * 		==> 두 클래스가 서로 긴밀한 관계로 연결되어 있는 경우에 사용함.
 * 			두 클래스 멤버 간에 서로 쉽게 전급할 수 있다는 장점이 있음.
 * 	
 * 2. 내부 클래스를 하나의 멤버로 사용할 수 있음.
 * 3. 클래스 멤버 : 멤버변수, 멤버메서드, 외부클래스, 내부클래스
 * 4. 내부 클래스 객체 생성 방법 
 * 	  
 		형식)
 			외부클래스명.내부클래스명 참조변수 = 외부클래스참조변수.new 내부클래스 생성자();
 			
 	[내부클래스의 특징]
 	- 내부 클래스는 외부 클래스의 멤버를 마치 자기 자신처럼 사용이 가능함.
 	  외부 클래스 멤버의 접근지정자가 private 접근지정자 일지라도 접근이 가능함.
 	- 내부 클래스의 접근은 반드시 외부 클래스를 통하여 접근해야 함.
 */

class Outer { // 외부 클래스
	
	private int su1 = 50;
	final int su2 = 33;
	
	class Inner { // 내부 클래스
		
		void output() {
			su1 = 135; // su1이 private 접근지정자여도 접근이 가능하다.
//			su2 = 20; // su2가 final 상수이기에 내부에서도 값 초기화는 불가능
			System.out.println("su1 >>> " + su1); // 외부 Outer에 있는 멤버변수에 접근 가능
			System.out.println("su2 >>> " + su2);
		}
	}
	
}


public class Ex02 {

	public static void main(String[] args) {
		
		// 중첩 클래스 객체 생성 방법
		// 1. 외부(Outer) 클래스 객체가 우선적으로 생성이 되어야 함.
		Outer outer = new Outer();
		
		// 2. 내부(inner) 클래스 객체 생성
		Outer.Inner inner = outer.new Inner();
		
		inner.output();
		
	}
}
