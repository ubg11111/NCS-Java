package util;

import java.util.Arrays;

/*
 * 4. Arrays 클래스
 * 	- 배열 객체를 처리해 주는 클래스.
 */


public class Ex04 {

	public static void main(String[] args) {
		
		String[] str = {"홍길동","이순신","유관순"};
		
		for(String k : str) {
			System.out.println("str 배열 요소 >>> " + k);
			
		}
		
		System.out.println();
		
		// 1.fill() : 배열의 요소를 특정한 값(데이터)으로 채우는 메서드.
		
		Arrays.fill(str, "김유신");
		
		for(String k : str) {
			System.out.println("str 배열 요소 >>> " + k);
		}
		
		System.out.println();
		
		String[] str2 = {"김유신","김유신","김유신"};
		
		// 2. equals() : 두 객체의 내용(데이터)이 같은지 틀린지를 비교하는 메서드. (문자열을 비교하는 메서드)
		if(Arrays.equals(str, str2)) {
			System.out.println("두객체의 내용(데이터)은 같습니다.");
		} else {
			System.out.println("두객체의 내용(데이터)는 다릅니다.");
		}
		
		System.out.println();
		// 3. sort() : 배열의 원소(데이터)를 정렬(오름차순)하는 메서드.
		
		int[] arr = {54,67,13,97,41};
		
		System.out.println("정렬 전....");
		for(int k  : arr) {
			System.out.print(k + "\t");
		}
		System.out.println();
		System.out.println();
		
		Arrays.sort(arr); // 오름차순 정렬 
		
		System.out.println("정렬 후 .....");
		for(int k : arr) {
			System.out.print(k + "\t");
		}
		System.out.println();
	}
}
