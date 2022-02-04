package abstracts;

public class Student extends Person{
	
	private String major; // 과목
	
	public Student() {} // 기본생성자
	
	public Student(String name, String major) {
		this.name = name;
		this.major = major;
	}
	
	
	@Override
	void output() {
		System.out.println(getName() + " 학생입니다.");
		System.out.println(major + " 과목을 수강 중입니다.");
	}
}
