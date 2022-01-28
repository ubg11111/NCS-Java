package Class;

public class Ex04_Student {

	public static void main(String[] args) {
		
		
		// 기본 생성자로 객체를 생성.
		
		Student student = new Student();
		
		student.hakbun = 2022001;
		student.name = "유병권";
		student.major = "관광과";
		student.addr = "동두천시";
		student.display();
		System.out.println();
		
		
		// 매개변수(인자생성자)로 객체를 생성.
		
		Student student1 = new Student(2022001, "유병권", "관광과", "동두천시");
		student1.display();
	}
}
