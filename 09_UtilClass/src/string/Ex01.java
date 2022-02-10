package string;

import java.awt.SystemColor;

/*
 * String 클래스의 특징.
 * 
 * 1. 문자열 객체를 처리하는 클래스.
 * 2. 객체 생성 방법 - 2가지 
 * 		1) 일반 변수 선언 방법으로 객체 생성.
 * 			예) String str1 = "홍길동";	
 * 				 String str2 = "홍길동";	 // "홍길동"이라는 heap 메모리에 str1 주소와 str2 주소가 같은 "홍길동"을 가리킨다.
 * 
 *  	2) new 키워드를 사용하는 방법
 *  		예) String str3 = new String("홍길동");
 *  			String str4 = new String("홍길동");
 *  
 */


public class Ex01 {

	public static void main(String[] args) {
		
		// 1) 일반 변수 선언 방법으로 객체 생성.
		String str1 = "홍길동"; // heap에 있는 str1 객체하고 str2 객체가 "홍길동" 문자열을 같이 바라봄.
		String str2 = "홍길동";
		
		
		if(str1 == str2) {
			System.out.println("참조하는 주소가 같다.");
		} else {
			System.out.println("참조하는 주소가 다르다.");
		}
		
		System.out.println();
		
		System.out.println("str1 주소 >>> "  + System.identityHashCode(str1));
	
		System.out.println("str2 주소 >>> "  + System.identityHashCode(str2));
		
		
		System.out.println();
		// 2) new 키워드를 이용하여 객체 생성
		String str3 = new String("홍길동"); // 0x100번지 객체 생성
		String str4 = new String("홍길동"); // 0X200번지 객체 생성
		
		if(str3 == str4) {
			System.out.println("참조하는 주소가 같다.");
		} else {
			System.out.println("참조하는 주소가 다르다.");
		}
		System.out.println();
		
		System.out.println("str3 주소 >>> "  + System.identityHashCode(str3));
	
		System.out.println("str4 주소 >>> "  + System.identityHashCode(str4));
		
	}
}
