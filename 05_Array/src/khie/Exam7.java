package khie;

import java.util.Scanner;

public class Exam7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("정수형 배열의 크기 입력 >>>");
		int[] arr = new int[sc.nextInt()];
		
		for(int i=0; i<arr.length; i++) {
			System.out.print((i+1) + " 번째 정수 입력 >>> ");
			
			arr[i] = sc.nextInt();
		}
		
		// 내림차순 정렬
		int tmp;
		
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(arr[j] > arr[i]) {
					tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			} // for(j)의 엔드문
		} // for(i)의 엔드문
		
		// 내림차순 출력
		for(int i=0; i<arr.length; i++) {
			System.out.println("arr["+i+"] = " + arr[i]);
		}
		sc.close();
	}
}
