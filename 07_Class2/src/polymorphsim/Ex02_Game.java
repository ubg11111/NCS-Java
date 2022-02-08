package polymorphsim;

import java.util.Scanner;

public class Ex02_Game {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// if조건문에 상속받은 OverWatch watch = null; <<null 참조변수값에 if조건문 번호로 다형성 객체를 생성한다.
		OverWatch watch = null;
		
		System.out.print("플레이하실 캐릭터를 선택하세요. (1.메이 / 2.겐지 / 3.맥크리) : ");
		int bunho = sc.nextInt();
	
	
		if(bunho == 1) {
			watch = new Mei(); // 다형성
		}else if(bunho == 2) {
			watch = new Gengi(); // 다형성
		}else if(bunho == 3) {
			watch = new Mccree(); // 다형성
		}
		
		watch.name();
		watch.leftClick();
		watch.rightClick();
		watch.shiftButton();
		watch.eButton();
		watch.qButton();
	
		sc.close();
	}
}
