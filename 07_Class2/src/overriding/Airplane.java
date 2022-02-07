package overriding;

public class Airplane extends Flyer{
	
	
	
	// Flyer를 상속받은 airplane의 메서드를 재선언해준것이다. (상속은 상속받은 부모클래스의 값이 어떤값이든 상속받은 자식은 강제적으로 메서드재정의(오버라이딩)을 해주어야한다.
	
	
	@Override
	void takeOff() {
		System.out.println("비행기가 땅에서 하늘로 날아 올랏다.");
	}
	
	@Override
	void fly() {
		System.out.println("비행기가 하늘에서 날고잇다.");
	}
	
	@Override
	void land() {
		System.out.println("비행기가 하늘에서 땅으로 내려왓삼.");
	}
}
