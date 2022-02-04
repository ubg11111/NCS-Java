package abstracts;

public class Professor extends Person{
	
	
	private String major; // 과목
	
	
	public Professor() {} // 기본생성자
	public Professor(String name, String major) { // 매개변수 생성자
		this.name = name;
		this.major = major;
	}
	
	
	// 추상 메서드 재정의한 메서드.
	@Override
	void output() {
		System.out.println(getName() + " 교수입니다.");
		System.out.println(major + "를 전공하고 있습니다.");
	}
}
