package khie;

/*
 * [문제] 키도브로부터 임의의 숫자 4개를 입력받아서
 * 		각각의 화폐 매수가 몇 장이 필요한지 코딩을 통해서 구하여 화면에 출력해 보세요.
 */


public class Exam_04 {

	public static void main(String[] args) {
		//1. 키보드로부터 임의의 숫자 4개를 입력받자.
		int su = Integer.parseInt(args[0]);
		
		//2. 각각의 화폐단위 변수를 선언해 주자.
		int oc, c, ob, b, os, s, o, i, res;
		
		//3. 화폐 매수를 계산을 해 보자.
		oc = su / 5000; // 오천원의 몫 ==> 1
		res = su % 5000; // 나머지 값은 ==> 3792
		
		c = res / 1000; // 천원의 몫 ==> 3
		res = res%1000; // 나머지 값은 ==> 792
		
		ob = res / 500; // 오백원의 몫 ==> 1
		res = res%500; // 나머지값은 => 292
		
		b = res / 100; // 이백원의 몫 ==> 2
		res = res%100; // 나머지값은 => 92
		
		os = res / 50; // 오십원의 몫 ==> 1
		res = res%50; // 나머지의 값은 ==> 42
		
		s = res / 10; // 십원의 몫 ==> 4
		res = res%10; // 나머지의 값은 ==> 2
		
		o = res / 5; // 오원의 몫 ==> 0
		res = res%5; // res(나머지) ==> 2
		
		i = res / 1; // 일원의 몫 ==> 2
		res = res%1; // 일원의 나머지 ==> 0
		
		//4. 화면에 출력해 보자.
		System.out.println("입력받은 숫자 : " + su);
		System.out.println("오천원 지폐 : : " + oc);
		System.out.println("천원 지폐 : " + c);
		System.out.println("오백원 동전 : " + ob);
		System.out.println("백원 동전 : " + b);
		System.out.println("오십원 동전 : " + os);
		System.out.println("십원 동전 : " + s);
		System.out.println("오원 동전 : " + o);
		System.out.println("일원 동전 : " + i);
	}
}
