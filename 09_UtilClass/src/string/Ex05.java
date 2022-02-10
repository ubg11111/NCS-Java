package string;

import java.util.StringTokenizer;

/*
 * StringTokenizer 클래스
 * - 특수 문자를 기준문자(delimiter)를 기준으로 문자열을 잘라주는 클래스(파싱).
 * - 기준 문자로 분리 된 문자열을 토큰(token)이라고 함.
 * - 웹에서 전화번호를 하이픈(-) 기준으로 앞자리, 중간자리, 뒷자리 형식으로
 * 	 구분해서 번호를 추출할 때 사용함.
 * 	 (예 : 주민번호, 핸드폰 번호 등등)
 */


public class Ex05 {

	public static void main(String[] args) {
		
		String str = 
				"id=hong&pwd=1234&age=27&addr=서울시 중구&phone=010-1111-1234";
		
		
		StringTokenizer st = new StringTokenizer(str, "&");
		
		
		// countTokens() : 기준 문자로 분리된 토큰의 갯수를 정수값으로 반환해 주는 메서드.
		System.out.println("토큰 수 >>> " + st.countTokens());
		
		
		//hasMoreTokens() : 반환할 다음 토큰이 있는지를 확인 하는 메서드.
		//					있으면 true 값을 반환, false 값을 반환.
		//nextToken() : 존재하는 토큰이 있다면 반환해주는 메서드.
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}
}
