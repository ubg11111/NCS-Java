package khie;

public class Ex08 {

	public static void main(String[] args) {
	
		
		// 키보드를 이용하여 두개의 숫자를 입력을 받아 보자.
		
		// Run configurations -> Aguments에서 각 변수에 맞게 입력 ex) 15 25
		// args는 입력한 순서대로 넘어가게 됨
		
		String su1 = args[0]; // 15 배열 인덱스 첫번째[0]에 15를 키보드로 입력 
		String su2 = args[1]; // 25 배열 인덱스 두번째[1]에 25를 키보드로 입력
		
		System.out.println("su1 + su2 = " + (su1+su2)); // 문자열 + 문자열 = 문자열
		System.out.println();
		
		int num1 = Integer.parseInt(su1); // 문자열을 숫자로 변환하는 메서드 String type => int type
		int num2 = Integer.parseInt(su2);
		
		System.out.println("num1 + num2 = " + (num1+num2)); // 숫자 + 숫자 = 숫자
		System.out.println();
	}
}
