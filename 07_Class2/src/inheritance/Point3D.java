package inheritance;

/*
 * 1. super() 키워드 
 * 	- 자식 클래스에서 부모클래스의 생성자를 호출하는 키워드 
 * 		형식) super(인자); // 인자는 생략도 가능.
 * 		
 * 
 * 2. this() 키워드
 *  - 현재 클래스에서 현재 클래스내의 다른 생성자를 호출하는 명령어.
 *  	형식) this(인자); // 인자는 생략 가능.
 *  	주의) this() 키워드는 생성자 첫 문장에 와야 한다. 
 *  		그렇지 않으면 error 발생
 *  		* 이유 : 생성자 내에서 초기화 작업 도중에 다른 생성자를 호출하게 되면 호출된 다른 생성자도 멤버변수들의 초기화 작업을 진행하게 됨.
 *					다른 생성자를 호출하기 이전에 진행되는 초기화 작업들은 무의미한 작업이 될 수 있기 때문이다.
 */



public class Point3D extends Point{

	
	int z;
	
	public Point3D() {
		super(); // 부모클래스의 기본생성자를 호출하는 명령어
	}
	
	
	public Point3D(int x, int y) {
//		this.x = x;
//		this.y = y; 
		
		super(x,y); // 부모인 Point 클래스로부터 x,y 멤버변수를 호출 
	}
	
	public Point3D(int x, int y, int z) {
		this(x,y); // 생성자에서 다른 생성자 호출하기 this() << 인자가 2개인 int x , int y 위에 2개의 인자 생성자를 가져옴
		this.z = z;
	} // 인자 생성자
	
	void output() {
		System.out.println("x좌표 >>> " + x);
		System.out.println("y좌표 >>> " + y);
		System.out.println("z좌표 >>> " + z);
	}
}
