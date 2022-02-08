package polymorphsim;

// A 부모 클래스
class A {}

// A부모를 상속받은 B자녀 클래스
class B extends A{}

// A부모를 상속받은 C자녀 클래스
class C extends A{}

// B부모를 상속받은 D자녀클래스
class D extends B{}

// C부모를 상속받은 E자녀클래스
class E extends C{}

public class Ex03_Main {

	public static void main(String[] args) {
		B b = new B();
		C c = new C();
		D d = new D();
		E e = new E();
		
		A b1 = new B(); // 부모의 참조변수를 활용하여 자식객체를 생성
		A c1 = new C();
		A d1 = new D();
		A e1 = new E();
		
		B d2 = new D(); 
		C e2 = new E();
		
		// 아래는 다형성에 해당되지않는다.
		// B e3 = new E(); // error
		// C d3 = new D(); // error
	}
}
