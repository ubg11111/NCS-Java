package Class;

/*
 * 외부 클래스를 호출하는 방법 같은 패키지내 Person Class를 호출하는 내용
 */

public class Ex03_Person {

	public static void main(String[] args) {
		
		Person person = new Person();
		
		person.name = "홍길동";
		
		person.age = 27;
		
		
		person.display();
	}
}
