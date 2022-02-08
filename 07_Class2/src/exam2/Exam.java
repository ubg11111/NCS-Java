package exam2;

public class Exam {

	public static void main(String[] args) {
		
		Student student1 = new Student("박정환" , 50000);
		Student student2 = new Student("남태현" , 50000);
		
		
		// bus100은 주소값을 가진 참조변수
		Bus bus100 = new Bus(100);
		
		// subwayGreen 또한 주소값을 가진 참조 변수
		Subway subwayGreen = new Subway(2);
		
		student1.takeBus(bus100);
		
		student2.takeSubway(subwayGreen);
		
		
		// student1 학생에 대한 정보를 출력.
		student1.showStudentInfo();
		System.out.println();
		
		//sutdent2 학생에 대한 정보를 출력.
		student2.showStudentInfo();
		System.out.println();
		
		// bus100에 대한 정보를 출력.
		bus100.showBusInfo();
		
		// subwayGreen에 대한 정보를 출력.
		subwayGreen.showSubwayInfo();
		
	}
}
