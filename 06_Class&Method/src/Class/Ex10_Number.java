package Class;

public class Ex10_Number {

	public static void main(String[] args) {
		
		Number number = new Number();
		
		// number.num1 = 50; // error 접근불가 (private)
		
		number.setNum1(350); // set 인자값을 저장함.
		number.setNum2(170);
		
		System.out.println("num1 >>> " + number.getNum1()); // get 저장한 set 인자값을 출력함(가져옴)
		System.out.println("num1 >>> " + number.getNum2());
	}
}
