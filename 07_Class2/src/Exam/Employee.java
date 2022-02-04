package Exam;

public abstract class Employee { // 추상화 클래스 설정
	
	String name; // 이름의 멤버 변수

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	abstract void getPays();  // 추상 메서드 설정 (선언부)
	
}
