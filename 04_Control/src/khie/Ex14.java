package khie;

public class Ex14 {

	public static void main(String[] args) {
		
		
		// 주사위를 굴려서 임의의 숫자를 받아서 처리해 보자.
		
		
		// Math.random 기본은 double타입이기에 int 형변환이 필요하다.
		int num = (int)(Math.random() * 6) + 1;
		
		
		if(num == 1) {
			System.out.println("주사위의 1번이 나왔습니다.");
		} else if(num == 2) {
			System.out.println("주사위의 2번이 나왔습니다.");
		} else if(num == 3) {
			System.out.println("주사위의 3번이 나왔습니다.");
		} else if(num == 4) {
			System.out.println("주사위의 4번이 나왔습니다.");
		} else if(num == 5) {
			System.out.println("주사위의 5번이 나왔습니다.");
		} else {
			System.out.println("주사위의 6번이 나왔습니다.");
		}
		
	}
}
