package string;

public class Ex02 {

	public static void main(String[] args) {
		
		String str1 = "Hello";
		String str2 = "Java";
		
		
		System.out.println
			("str1 문자열 주소 >>> " + System.identityHashCode(str1));
		System.out.println
			("str2 문자열 주소 >>> " + System.identityHashCode(str2));
		
		System.out.println();
		
		// 문자열 연산(결합)
		str1 = str1 + str2; 
		
		// "Hello Java" ; 새로운 주소값이 생성됨 final 상수의 특징 중 하나임.
		// 상수는 값이 초기화 될 수 없기에 연산자에 의해 새로운주소가 생성됨.
		
		// str1 0x100 = "Hello";
		// str2 0x200 = "Java";
		// str1 0x300 = "Hello Java"; 
		// str1의 이름은 같지만 주소값이 틀리다.
		
		System.out.println
		("str1 문자열 주소 >>> " + System.identityHashCode(str1));
	}
}
