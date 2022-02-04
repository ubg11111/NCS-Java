package Exam;

public class Temporary extends Employee{
	
	int time; // 작업시간
	int pay; // 시간당급여
	
	public Temporary () {} // 기본생성자
	
	public Temporary(String name, int time, int pay) {
		
		this.name = name;
		this.time = time;
		this.pay = pay;
		
	} // 인자생성자
 	
	public void setPay(int pay) {
		this.pay = pay;
	}
	public int getPay() {
		return pay;
	}
	
	public void setTime(int time) {
		this.time = time;
	}
	
	public int getBonus() {
		return time;
	}
	
	void getPays() { // 추상화 클래스의 메서드 재정의 (구현부) - 오버라이딩
		int total = pay * time;
		System.out.printf("급여 : %,d원%n", total);
	}
}
