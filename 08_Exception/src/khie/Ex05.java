package khie;

/*
 * Ex02 클래스에서 발생한 예외를 예외처리 코드를 이용하여 처리해주세요.
 */


public class Ex05 {

	public static void main(String[] args) {
		System.out.println("프로그램 시작");
		
		String str1 = "";
		String str2 = "";
		
		try {
		str1 = "korea";
		str2 = null; // null : 값이 없는 상태
		
		System.out.println("str1 문자열의 길이 >>> " + str1.length());
		System.out.println("str1 문자열의 길이 >>> " + str2.length());
		
		} 
		catch(Exception e) {
			
			System.out.println("str2의 문자열의 값이 없는 상태");
			System.out.println("예외정보 >>> " + e);
		}
		
		
		System.out.println("프로그램 종료");	
	}
}
