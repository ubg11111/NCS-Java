package khie;

/*
 * 실수 자료형 : 소숫점이 존재하는 자료형
 * 
 * - float : 소숫점 이하 7(6)자리까지 표현이 가능
 * - double :  소숫점 이하 15~16자리까지 표현가능
 * - float 자료형의 변수에 실수 값을 저장 시에는 반드시 실수값 뒤에
 *  f를 붙여 주어야 함 (생락하면 에러)
 * - 실수형 데이터의 맨 뒤에 f를 붙이거나 데이터의 맨 앞에 (float) 명시를 안 하면 오류가 발생하는 이유
 *  => 실수형의 기본자료형은 double 형이기 때문임.
 * - 실수 자료형에서 명시적 형변환을 진행하게 되더라도 자료의 손실은 거의 발생하지 않음.
 * 
 */


public class Ex04 {

	public static void main(String[] args) {
		
		double dNum = 123.45666; 
		
		System.out.println("dNum = " + dNum);
	
	
		float fNum = (float)dNum; // 명시적 형변환 기본형 double(8byte) -> float(4byte) 큰 값을 작은 값에 넣으려하기에 오류 발생하여 형변환을 진행
		
		System.out.println("fNum = " + fNum);
	}
}
