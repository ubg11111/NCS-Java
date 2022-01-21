package khie;

public class Ex06 {

	public static void main(String[] args) {
		// System.out.printf()
		// 형식에 맞게 출력하는 메서드.
		
		System.out.printf("%,d%n", 100000); // ,%d를 통해 ,숫자표현
		System.out.printf("%5d%n",1); // 1을 포함하여 5자리 수를 10진수(정수)로 표시함
		System.out.printf("%o%n", 10); // 8진수 표현
		System.out.printf("%x%n", 10); // 16진수 표현
		System.out.printf("%s%n", "안녕"); // 문자열을 출력 참조변수 %s
		
		
		System.out.printf("%f%n", 3.2582); // float(소수점)표시 
		// 형식("%정수.소수점자릿수.f) 즉, 정수는 모든값이 표현되고 뒤에 .실수 부터 적용함
		System.out.printf("%4.2f%n", 3.2582); // (2582)4개의 실수중 (82)뒤에서 두번째자리를 정리하고 반올림
		System.out.printf("%.3f%n", 3.2582); // .소수점 3번째까지만 표시(반올림 x)
		
	}
}
