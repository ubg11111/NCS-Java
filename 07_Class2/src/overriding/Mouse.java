package overriding;


// 포함관계 Mouse안에 Animal 객체가 있다.

public class Mouse{
	Animal animal = new Animal();
	
	
	void mouse() {
		System.out.println("찍찍~~");
	}
}
