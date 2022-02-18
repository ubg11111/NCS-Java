package khie;

/*
 * 멀티 스레드와 스레드 이름 지정
 * - 멀티 스레드 : 하나의 스레드 클래스를 대상으로
 * 				 2개 이상의 스레드 객체를 생성하는 기법.
 * - 스레드 이름 지정 : 멀티스레드에서 생성한 스레드 객체에
 * 					 이름을 부여하는 과정.
 * 					형식) super(name);
 * - 멀티 스레드는 자신의 이름을 가지고 있음.
 * - 스레드의 이름이 큰 역할을 하지는 않지만, 디버깅 시
 * 	 어떤 스레드가 현재 실행이 되어 작업하는지를 조사(확인)할
 * 	 목적으로 많이 사용됨.
 */


class ThreadA extends Thread{
	
	public ThreadA() {}
	
	public ThreadA(String name) {
		super(name);
	}
	
	public void run() {
		
		System.out.println(this.getName());
		// getName() : 현재 run() 메서드를 실행중인 
		// 				스레드의 이름을 반환해 주는 메서드.
	};
	
}



public class Ex06 {

	public static void main(String[] args) {
		
		// ThreadA 라는 클래스를 대상으로 멀티 스레드 객체 생성 방법.
		Thread t1 = new Thread("첫번째 스레드");
		Thread t2 = new Thread("두번째 스레드");
		Thread t3 = new Thread("세번째 스레드");
		Thread t4 = new Thread("네번째 스레드");
		Thread t5 = new Thread("다섯번째 스레드");
		Thread t6 = new Thread("여섯번째 스레드");
		
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
	}
}
