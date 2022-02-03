package inheritance;

public class Ex02_Car2 {

	public static void main(String[] args) {
		Avante avante = new Avante();
		
		// 상속 호출의 우선순위는 부모클래스가 아닌 자식클래스이다.
		
		avante.cc = 1600;
		
		avante.door = 4;
		
		avante.outpur();
	}
}
