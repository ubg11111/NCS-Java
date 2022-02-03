package inheritance;

/*
 * 1.super 키워드
 * 	-부모의 멤버를 호출하는 명령어.
 * 		형식) super.부모클래스멤버(멤버변수, 멤버메서드)
 * 
 * 
 * 2.this 키워드
 * 	- 현재 클래스에 소속된 멤버를 호출하는 명령어.
 * 	- this 키워드는 현재 객체 자기 자신을 의미함.
 * 		형식) this.자식클래스멤버(멤버변수, 멤버메서드)
 */



public class Avante extends Car2{
	
	// 멤버 변수
	String color = "흰색"; // this의 영향을 받아 흰색을 출력 (객채네 멤버변수 반영)
	
	void outpur() {
		System.out.println("엔진 : " + cc + ", 문 수 : " + door + ", 색상 : " + color);
		System.out.println("엔진 : " + cc + ", 문 수 : " + door + ", 색상 : " + super.color); // 부모클래스의 color 멤버변수를 super메서드를 통해서 가져옴
		System.out.println("엔진 : " + cc + ", 문 수 : " + door + ", 색상 : " + this.color); // 현재 클래스에 소속된 멤버를 호출 this 현재 객체 자기 자신을 의미함.
	}
	
}
