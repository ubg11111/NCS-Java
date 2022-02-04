package abstracts;

public class Ex01_Super {

	public static void main(String[] args) {
		
		Sub sub = new Sub();
		
		sub.num1 = 135;
		
		System.out.println("calc() 메서드 호출 >>>> " + sub.calc());
		
		sub.output(); // 추상 메서드 재정의
	}
}
