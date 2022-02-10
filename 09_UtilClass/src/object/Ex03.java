package object;

public class Ex03 {
	public static void main(String[] args) {
		
		
		// String 배열 객체 생성
		String[] str = new String[4];
		str[0] = "홍길동";
		str[1] = "hong";
		str[2] = "서울시 중구 남대문로";
//		str[3] = 123; // 자료형이 불일치 error 발생
		str[3] = "010-1234-1234";
		
		
		// 향상된 for문을 통해 배열을 출력
		// 향상된 for문의 사용은 ArraysList 또는 배열을 가독성있게 출력할 때 사용한다.
		for(String k : str) {
			System.out.println("str 배열 요소 >>> " + k);
		}
		
		System.out.println();
		
		// Object 배열 객체 생성 (모든 기본 자료형과 참조 자료형을 넣을 수 있음)
		Object[] obj = new Object[4];
		obj[0] = "이순신"; // 문자열 String 자료형
		obj[1] = 150; // 정수 int 자료형
		obj[2] = true; // boolean 자료형 
		obj[3] = 'a'; // char 문자 자료형
	
		for(Object o : obj) {
			System.out.println("Object 배열 요소 >>> " + o);
		}
	}
}
