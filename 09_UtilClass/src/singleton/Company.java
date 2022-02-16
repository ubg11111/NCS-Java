package singleton;

/*
 * 싱글톤 방식(singleton)?
 * 
 * - 생성자를 private 접근지정자를 이용하여
 * 	 외부에서 직접 접근을 못하게 불허하는 방식.
 * 
 * - 외부에서해당 인스턴스를 new로 생성하지 못하도록 하는 방식.
 * - 사용하는 이유: 매번 객체를 생성하게 되면 
 * 				 메모리의 성능이 느려지는 단점이 발생하기 때문이다.
 * 
 * 
 */


public class Company {
	
	private static Company singleton; // null이란 값이 생략되어 있다.
	
	private int volume;
	
	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	private Company() {
		
	};
	
	public static Company getInstance() {
		if(singleton == null) { // 싱글턴이 null이면.. 싱글턴 Company 클래스에 객체를 생성해서 리턴해주는 조건문
			singleton = new Company();
		}
		
		return singleton; // 객체를 생성해서 반환해줌
	}
	
	public static Company getCar() {
		if(singleton == null) {
			singleton = new Company();
		}
		
		return singleton;
	}
}
