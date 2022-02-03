package inheritance;

public class Student extends Human{
	
	// 하기와 같이 Human을 통해서 멤버변수 상속받음
	// String name;
	// int age;
	// String job; 
	String major; // 학과
	
//	public Student(String name, int age, String job, String major) {
//		
//		this.name = name;
//		this.age = age;
//		this.job = job;
//		this.major = major;
//	} // 인자 생성자
	
	
	void sutdentInfo() {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("직업 : " + job);
		System.out.println("학과 : " + major);
	}
}
