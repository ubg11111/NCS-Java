package polymorphsim;

public class Gengi implements OverWatch {

	@Override
	public void name() {
		System.out.println("이름 : 겐지");
	}

	@Override
	public void leftClick() {
		System.out.println("왼쪽 버튼 : 표창던지기");
	}

	@Override
	public void rightClick() {
		System.out.println("오른쪽 버튼 : 표창 3개 던지기");
	}

	@Override
	public void shiftButton() {
		System.out.println("Shife 버튼 : 돌진");
	}

	@Override
	public void eButton() {
		System.out.println("E 버튼 : 칼로 막기");
	}

	@Override
	public void qButton() {
		System.out.println("Q버튼 : 류승룡소환");
	}
}
