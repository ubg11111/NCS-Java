package Exam;

public class Permanent extends Employee{
	
	int salary;
	int bonus;
	
	public Permanent() {} // 기본생성자
	
	public Permanent(String name, int pay , int bonus) {
		this.name = name;
		this.bonus = bonus;
		this.salary = pay;
	} // 인자 생성자
	
	
	public void setPay(int pay) {
		this.salary = pay;
	}
	public int getPay() {
		return salary;
	}
	
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
	public int getBonus() {
		return bonus;
	}
	
	void getPays() { // 추상화 클래스의 메서드 재정의 (구현부) - 오버라이딩
		int total = salary + bonus;
		System.out.printf("급여 : %,d원%n", total);
	}
}
