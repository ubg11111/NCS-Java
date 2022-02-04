package overriding;

public class Bird extends Flyer{
	
	@Override
	void takeOff() {
		System.out.println("새가 땅에서 하늘을 벅차 날아올랏다.");
	}
	
	@Override
	void fly() {
		System.out.println("새가 하늘을 날고 있다.");
	}
	
	@Override
	void land() {
		System.out.println("새가 하늘에서 땅으로 내려왓다");
	}
}
