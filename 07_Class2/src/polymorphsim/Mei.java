package polymorphsim;

public class Mei implements OverWatch {
	
	
	// 다중추상메서드(인터페이스) 모든 메서드에 대해서 오버라이딩(재정의) 해줘야한다.
	@Override
	public void name() {
		System.out.println("이름 : 메이");
	}

	@Override
	public void leftClick() {
		System.out.println("왼쪽 버튼 :  냉각총");
	}

	@Override
	public void rightClick() {
		System.out.println("오른쪽 버튼 : 고드름");
	}

	@Override
	public void shiftButton() {
		System.out.println("Shift 버튼 : 급속 빙결");
	}

	@Override
	public void eButton() {
		System.out.println("E 버튼 : 빙벽 ");
	}

	@Override
	public void qButton() {
		System.out.println("Q 버튼 : 절대동토");
	}
}
