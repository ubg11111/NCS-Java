package inheritance;

public class Sonata extends Car{ // 부모 클래스인 Car를 상속받음
	
	String model; // 차량 모델명
	
	void output() {
		System.out.println("모델명 : " + model);
		System.out.println("배기량 : " + cc); // 부모클래스인 Car 멤버변수를 상속받아서 사용가능
		System.out.println("차량 문 수 : " + door);
	}
	
}
