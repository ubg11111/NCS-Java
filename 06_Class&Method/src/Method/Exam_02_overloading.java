package Method;


class Overloading{
	
	
	// 오버로딩은 하나의 메서드의 이름을 사용하여 메소드를 중복으로 여러개 사용하는것을 말한다.
	// 여기서 오버로딩의 경우 과적이라는 내용으로 본래 메서드는 한개의 메서드에서만 기능을 활용해야하지만.
	// 오버로딩을 사용하게되면 같은 메서드이름이라도 인자타입이나, 인자의 매개변수값이 다를때마다 같은 메서드내 새로운메서드로 인식하게된다.
	// 오버로딩의 규칙의 경우 타입반환의값은 상관없으나, 메서드이름이같아야하고, 메서드 매개변수 인자값의 타입이다르거나 인자의 개수가 달라야한다.
	// 메서드의 이름을 절약하거나. (메서드는 중복되는 경우 같은 프로젝트내 에러가뜸) 하나의 메서드에서 다양한 구현이 가능하다.
	
	public void print() {
		System.out.println("오버로딩1");
	}
	
	int print(int s) {
		System.out.println("오버로딩2");
		return s;
	}
	
	public void print(String a) {
		System.out.println("오버로딩3");
		System.out.println(a);
	}
	
	public int print(int b, int c) {
		System.out.println("오버로딩4");
		return b+c;
	}
}



public class Exam_02_overloading {
	public static void main(String[] args) {
		Overloading over = new Overloading();
		
		over.print();
		System.out.println(over.print(2));
		over.print("hello");
		System.out.println(over.print(10,20));
		
		
	}
}
