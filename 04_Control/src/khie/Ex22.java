package khie;

// 1 ~ 100까지의 홀수의 합과 짝수의 합을 구해 보자.

public class Ex22 {
	public static void main(String[] args) {
		
		
		// 홀수의 합 변수, 짝수의 합 변수
		int oddSum = 0, evenSum = 0;
		
		// 반복문에서의 초기식
		int su = 1;
		
		while(su <= 100) {
			if((su % 2) == 1) {
				oddSum = oddSum + su;
			} else {
				evenSum = evenSum + su;
			}
			su++;
		}
		System.out.println("홀수의 합 >>> " + oddSum);
		System.out.println("작수의 합 >>> " + evenSum);
	}
}
