package khie;

import java.util.Scanner;

public class Ex07 {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열 배열의 크기 입력 >>> ");
		
		String[] str = new String[sc.nextInt()]; // 0x100
		
		/*
		 * 상당히 중요한 개념이다.
		 * 배열의 이름은 heap 영역의 시작 주소값을 저장하고 있기 때문에
		 * 아래 문장은 시작 주소값을 다른 배열의 배열명에 복사해 주는 명령문이다.
		 * 즉, 배열의 공유가 이루어지게 된다.
		 */
		
		String[] strCopy = str; // 0x100 주소를 같이 가리킴
	
		
		// 하기 두 String배열의 주소값은 같은 0x100의 주소값을 가리키고 있음.
		System.out.println("str 배열 주소값 >>> " + str);
		System.out.println("strCopy 배열 주소값 >>> " + strCopy);
		
		
		// strCopy 배열에 초기값을 할당해 보자.
		
		for(int i=0; i<strCopy.length; i++) {
			System.out.print((i+1) + " 번째 문자열 입력 >>> ");
			
			strCopy[i] = sc.next();
		}
		
		// str 배열을 출력해 보자.
		
		for(int i =0; i<str.length; i++) {
			System.out.println("str["+i+"] >>> " + str[i]);
		}
		
		sc.close();
	}
}
