package interfaces;

/*
 * 인터페이스(interface)?
 * 1. 완벽한 추상화를 제공한다.
 * 		==> - 일종의 추상클래스. 하지만 추상클래스보다 추상화 정도가 더 높다.
 * 			- 실제 구현된 것이 전혀 없는 기본 설계도(알맹이 없는 껍데기).
 * 			- 추상메서드(알맹이 없는 껍데기)와 상수만을 멤버로 갖는다.
 * 			- 인스턴스를 생성할 수 없고, 클래스 작성에 도움을 줄 목적으로 사용이 됨.
 * 			- 미리 정해진 규칙에 맞게 구현하도록 표준을 제시하는데 사용이 됨 ==> 명세서
 * 	
 * 2. 모든 메서드가 추상화(추상메서드)이다. 
 * 3. 프로젝트 진행 시 표준 규약에 따른다.
 * 		==> 추상 클래스보다 더 많이 사용이 됨.
 * 4. 인터페이스는 상수와 추상메서드로만 구성이 되어 있음.
 * 5. 모든 변수는 상수가 된다.
 * 		예) public static final 로 인식을 함.
 * 6. 모든 메서드는 추상메서드가 된다.
 * 		예) public sbatract 로 인식을 함.
 * 7. 인터페이스는 객체 생성이 불가능 함. (추상클래스와 동일) 구현부가 없기때문;;
 * 8. 자식클래스로 상속을 하여 자식클래스에서 객체 생성. 
 * 		==> 인터페이스의 추상메서드는 반드시 재정의(강제성이 부여됨).
 * 9. 인터페이스는 다중 상속을 제공함.
 * 10. class -> interface 키워드 사용.
 * 	   extends -> implements 키워드 사용.
 * 
 * 인터페이스 사용 목적 : 스펙을 주어 클래스들이 그 기능을 서로 다르게 구현할 수 있도록
 * 						클래스의 규격 선언이며, 클래스의 다형성을 실형하는 도구임.
 * 
 * 
 */


public interface Inter { // 추상메서드가 다중으로 있는경우 클래스 => 인터페이스(상수 추상메서드만 구성)로 전환하여 사용한다
	
	/*final*/ int num = 50;  // 인스턴스 멤버변수 (interface에서 멤버를 선언하는 경우 상수로 적용이 된다.)
	
	void output1(); // 추상 메서드
	void output2(); // 추상 메서드
	
}
