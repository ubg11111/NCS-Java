package khie;

public class Ex20 {

	public static void main(String[] args) {
		
		// while 반복문을 이용하여 1 ~ 10까지의 합을 출력해 보자.
		
		int sum = 0; // 1~ 10까지의 합을 저장할 변수 
		int number = 1; // 반복문에서의 초기식
		
		while(number <= 10) {
			sum += number; // sum = sum + number;
			number++; // 반복문에서의 증감연산식
		}
		System.out.println("sum ===> " + sum);
	}
}
