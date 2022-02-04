package abstracts;

public abstract class SmartPhone { // 추상화 클래스 설정 (super 또는 호출이 불가능하다)
	// 공통적인 기능의 특성
	
	String call = "전화";
	String sns = "SNS";
	String search = "인터넷 검색";
	String game = "게임";
	
	// 각각의 기계(단말기)들의 특성.
	String company, name, color, size, weight, price;
	
	void purpose() {
		System.out.println("사용목적 : " + call + " / " + sns + " / " + search + " / " + game);
	}
	
	// 각각의 단말기 (기계)들의 spec
	
	abstract void spec(); // 추상화클래스 (단말기마다 속성이 다 틀리기에)
}
