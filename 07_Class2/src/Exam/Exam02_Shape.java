package Exam;

/*
 * 
 *  -- 평가 문제 --
 * Collection(자료구조)란 무엇인가?
 *  : 자바에서 제공하는 자료구조를 담당하는 framework로 자료를 추가, 삭제 , 정렬등의 기능 처리가 구현되어 있어서
 *   	간편하게 사용하기가 쉬움.
 *   
 *   
 *  객체지향프로그래밍의 다형성에 대해서 서술하시오.
 *  : 상속을 이용한 기술의 하나로 부모 타입의 참조변수로 상속관계에 있는 여러 자식 타입의 객체를 다루는 기술 
 *  	부모의 참조변수를 이용하여 자식의 객체를 생성할 수 있음.
 *  
 *  오버로딩과 오버라이딩의 특징(규칙)
 *  
 *  추상화란? 상속이란?
 *  
 *  인터페이스란?
 *  
 *  생성자의 정의?
 *  
 *  캡슐화란?
 */



import java.util.Scanner;

interface Shape{
	
	// 실수값이 포함되어있는 공식이기에 void가 아닌 반환값 double 타입으로 설정
	double findArea();
}

class Cicle implements Shape{
	
	// 멤버변수 기본값 설정
	int ban;
	
	Cicle(){}; // 기본생성자 생성 본래 클래스는 기본생성자가 디폴트값으로 할당되어있음 
	
	Cicle(int ban){ // 매개변수생성자 사용자 정의 생성자라고 한다. 
		this.ban = ban;  // this.ban = 인스턴스변수 자신을 가리킨다. 즉 멤버변수로 설정한 int ban을 가리킨다. this.ban = ban; 전역변수와 지역변수가 이름이 같은경우 this문과같이 선언하여 초기화한다.
	}
	
	@Override
	// 오버라이딩 재정의 또한 타입 double로 변환
	public double findArea() {
		
		// 반환값 double 3.14 실수값이 있어 재정의
		double one = 3.14 * ban * ban;
		return one;
	}
	
	
}

class Rectangle implements Shape{
	
	// 멤버변수 기본값 설정
	int width; // 가로 변수
	int height; // 세로 변수 
	
	// 기본생성자는 아래와같이 명시하지않더라도 컴파일러에 의해 기본생성자를 생성해준다. 왜냐하면 객체가 생성이 필요할 땐 기본생성자를 필요로 하기 때문이다.
	Rectangle(){}; // 기본생성자 생성 - 객채는 생성자없이 생성이 불가능하기에 기본생성자는 생성하는것이 맞다.
	
	@Override
	// 오버라이딩 재정의 또한 타입 double로 변환
	public double findArea() {
		
		return width * height;
	}
}


public class Exam02_Shape {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// shape 공통값 0을 디폴트 설정
		int shape;
		
		System.out.println("도형을 선택하세요.(1.원형, 2.사각형)");
		
		System.out.print("도형 선택 >>> ");
		
		// shape에 sc.nextInt(); 메서드를 통해 키보드로 입력받은 값을 저장
		shape = sc.nextInt();
		
		
		// shape 키보드로 입력받은 값이 1인경우 아래와같은 조건문을 실행
		if(shape == 1) {
			System.out.print("반지름 입력 >>> ");
			Cicle cicle = new Cicle(sc.nextInt()); // 매개변수생성자(사용자정의생성자)에 인자를 전달하여 초기화하는 작업
			System.out.println("========================");
			System.out.println("원의 면적 : " + cicle.findArea());
		} 
		
		// shape 키보드로 입력받은 값이 2인경우 아래와같은 조건문을 실행
		else if(shape == 2) {
			Rectangle rectangle = new Rectangle();
			System.out.print("가로 >>> ");
			rectangle.width = sc.nextInt();
			System.out.print("세로 >>> ");
			rectangle.height = sc.nextInt();
			System.out.println("========================");
			System.out.println("사각형의 면적 : " + rectangle.findArea());
		} else {
			System.out.println("값을 잘못 입력하셨습니다.");
		}
		sc.close();
	}
}
