package abstracts;

public class Ex03_SmartPhone {

	public static void main(String[] args) {
		
		Galaxy galaxy = new Galaxy();
		galaxy.purpose();
		galaxy.spec(); // 추상메서드 재정의한 메서드
		
		System.out.println();
		
		IPhone iphone = new IPhone();
		iphone.purpose();
		iphone.spec(); // 추상메서드에 재정의한 메서드
		
		
	}
}
