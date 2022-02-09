package khie;


/*
 * 2.throws 키워드
 * 	- 예외 처리를 위임시키는 명령어
 * 	  형식 ) 메서드명 throws 예외처리클래스 { }
 * 	- throws 로 지정된 메서드를 호출할 경우
 * 	  메서드 내에서 예외가 발생이 되면 해당 예외를
 * 	  메서드를 호출한 곳으로 위임시켜서 예외를 처리하는 방법.
 */

public class Ex09 {
	void excetion1() throws Exception{
		String str1 = "java";
		String str2 = null;
		
		
		System.out.println("str1 문자열의 길이 >>> " + str1.length());
		System.out.println("str2 문자열의 길이 >>> " + str2.length());

		/*
		 * e.printStackTrace()
		 * 
		 * -에러 메세지의 발생 근원을 찾아서 단계별로 에러를 출력해 주는 메서드
		 */
		
	}
	
	void excetion2() throws Exception{
		
		int num1 = 15, num2 = 0, result = 0;
		
		
		result = num1 / num2;
	
	}

	public static void main(String[] args) {
		Ex09 ex09 = new Ex09();
		
		try {
			ex09.excetion1();
			ex09.excetion2();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
