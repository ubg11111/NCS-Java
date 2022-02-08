package polymorphsim;

public class Ex01_Animal {

	public static void main(String[] args) {
		
		// 다형성에 의해 조상 Animal 가져오기
		Animal dog = new Dog();
		
		dog.sound();
		
		// 자손클래스에서 만들어진 멤버에 접근 불가능
		// dog.output();
	}
}
