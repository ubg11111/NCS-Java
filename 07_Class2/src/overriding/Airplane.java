package overriding;

public class Airplane extends Flyer{

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
