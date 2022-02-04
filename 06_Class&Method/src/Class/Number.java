package Class;

/*
 * ★중요함. 
 * 
 * 캡슐화(Encapsulation)?
 * -객체 지향 프로그램 4대 특징 중 하나.
 * -데이터를 감추기, 데이터를 외부에서 함부로 변경하지 못하도록 외부의 접근을 제한하는 방법.
 * - 정보 은닉 : 클래스 멤버 접근 제어 기법.
 * 		*private : 외부에서 직접 접근차단. 
 * 		*public : 누구나 접근이 가능. 해킹의 위험성이 있다.
 * 	- setter() / getter() 메서드로 접근 가능.
 * 		==> setter() : 지정자 메서드.
 * 		==> getter() : 획득자 메서드.
 * 
 * ★중요함.
 */


public class Number {
	
	// 멤버변수 선언
	private int num1; // private 선언시 다이렉트로 접근이 제한되어 접근 불가능함 (외부에서 해당 인스턴스변수에 접근을 못함)
	private int num2;

	public int getNum1() { // int 반환형으로 return 하여 num1을 반환
		return num1;
	}
	
	public void setNum1(int num1) { // this. <<< 인스턴스변수 자신을 가리킨다. // 멤버변수 num1 == 지역변수 num1 서로 이름이 같을 때 멤버변수임을 표시 this.num1
		this.num1 = num1; // 매개변수(지역변수)를 멤버변수(전역변수)로 초기화값을 할당 (this사용하여 멤버변수 = 매개변수;)
	}
	
	public int getNum2() {
		return num2;
	}
	public void setNum2(int num2) {
		this.num2 = num2;
	}
	
	/*
	 * this 키워드 : 객체(Number 클래스) 자기 자신을 의미함.
	 * - 주로 멤버변수와 메서드 또는 생성자의 매개변수 이름이 동일할 때
	 * 	객체의 멤버임을 명확하게 하기 위하여 사용되는 키워드.
	 * - 매개변수(지역변수)의 이름과 멤버변수(전역변수)의 이름이 같을 때
	 * 	멤버변수(전역변수) 앞에 this라는 키워드를 붙여서 구분하여 사용함.
	 * - 지역변수와 전역변수의 이름이 같으면 지역변수의 우선순위가 높음.
	 */
	
	
	
	/*
	 *	 setter() 메서드로 멤버변수에 초기값을 설정.
	 *		-private 멤버변수에 값을 지정(초기값 설정)하는 역할을 하는 메서드.
	 *		
	 *		형식) 
	 *			public void set멤버변수명(자료형 매개변수){
	 *				멤버변수 = 매개변수;
	 *			} 
	 */
//	
//	public void setNum1(int n1) { // setter 메서드 사용
//		num1 = n1; // 멤버변수 = 매개변수; 
//	}
//	
//	public void setNum2(int n2) {
//		num2 = n2;
//	}
	
	/*
	 *	 getter() 메서드로 멤버변수에 할당된 초기값을 가져오는 설정.
	 *		-private 멤버변수에 할당된 값을 가져오는 역할을 하는 메서드.
	 *		
	 *		형식) 
	 *			public 반환형 get멤버변수명(){
	 *				return 멤버변수명;
	 *			} 
	 */
	
//	public int getNum1() {
//		return num1;
//	}
//	
//	public int getNum2() {
//		return num2;
//	}
	
}
