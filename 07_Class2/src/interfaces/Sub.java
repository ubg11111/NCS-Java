package interfaces;


public class Sub implements Inter{ // 상속(extend)가 아닌 인터페이스는 implements로 확장해야한다.
	
	
	// 추상메서드 재정의(오버라이딩)
	@Override
	public void output1() {
		System.out.println("인터페이스 output1() 메서드 재정의");
	}

	@Override
	public void output2() {
		System.out.println("인터페이스 output2() 추상메서드 재정의");
	} 
}
