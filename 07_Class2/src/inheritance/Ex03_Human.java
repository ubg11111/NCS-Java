package inheritance;

public class Ex03_Human {

	public static void main(String[] args) {
		
		
		// Student 자식 클래스를 호출 (Human 부모클래스를 상속받음)
		Student student = new Student();
		student.name = "홍길동";
		student.age = 27;
		student.job = "대학생";
		student.major = "컴퓨터 공학과";
		student.sutdentInfo();
		System.out.println();
		
		
		// Employee 자식 클래스를 호출 (Human 부모클래스를 상속받음)
		Employee employee = new Employee();
		employee.name = "유병권";
		employee.age = 30;
		employee.job = "백수";
		employee.salary = 100;
		employee.employeeInfo();
		System.out.println();
		
		
	}
}
