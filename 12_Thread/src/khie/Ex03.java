package khie;


/*
 *  2.Runnable 인터페이스를 구현(implements)하여 사용하는 방법.
 *    1) Runnable 인터페이스를 구현(implements)
 *    2) run() 추상메서드를 재정의
 *    3) Thread 클래스(자식클래스) 객체 생성.
 *    4) Thread 라는 클래스 객체 생성.
 *    	 ==> Thread 라는 클래스의 생성자의 인자에 
 *    		 자식클래스의 참조변수를 기재.
 *    5) Thread 라는 클래스의 참조변수. start() 메서드 호출
 *  
 */


class Runnable1 implements Runnable{
	
	public void run() { // 추상메서드를 재정의
		
		int i = 1;
		while(true) {
			System.out.println("i >>>" + i);
		
			i++;
		}
	}

}

class Runnable2 implements Runnable{
	
	public void run() { // 추상메서드를 재정의
		
		int j = 1;
		while(true) {
			System.out.println("j >>>" + j);
		
			j++;
		}
	}
}

public class Ex03 {

	public static void main(String[] args) {
		Runnable1 r1 = new Runnable1();
		Runnable2 r2 = new Runnable2();
		
		// 4) Thread 라는 클래스 객체 생성.
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		// 5) Thread 라는 클래스의 참조변수. stract()
		t1.start();
		t2.start();
	}
}
