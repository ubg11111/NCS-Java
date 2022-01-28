package Class;

public class Ex07_Static {

	public static void main(String[] args) {
		
		// 클래스메서드 호출 (정적) 공통변수
		System.out.println("num >>> " + Static.num);
		System.out.println("adder() " + Static.adder(150, 32));
		
		// 인스턴스메서드 호출 (해당 클래스를 호출해야함)
		Static static1 = new Static();
		System.out.println("su1 >>>" + static1.su1);
		System.out.println("su2 >>>" + static1.su2);
		static1.sum();
	}
}
