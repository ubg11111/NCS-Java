package Method;

public class Ex06 {
	
	
	public static void change(int[] array) { // int[] 배열 선언 , 메서드(arr)주소값이 복사되어 메모리값을 보유
		
		
		System.out.println("array 주소값 >>> " + array); // main 메서드의 arr주소가 복사되어 같은 주소를 공유한다
		
		array[0] = 100;
		array[1] = 200;
		array[2] = 300;
		
	
	}
	
	public static void main(String[] args) {
		
		// call by referance 방식
		
		int[] arr = new int[3];
		
		arr[0] = 10 ; arr[1] = 20; arr[2] = 30;
		
		
		System.out.println("arr 주소값 >>> " + arr);
		
		System.out.println("change() 메서드 호출 전 ..... ");
		
		for(int i=0; i<arr.length; i++) {
			System.out.println("arr["+i+"] >>> " + arr[i]);
		}
		
		change(arr); // arr 실인수와 int[] array 매개변수(가인수)의 주소값은 서로 공유되어있다. (copy)
		
		System.out.println("change() 메서드 호출 후......");
		
		for(int i=0; i<arr.length; i++) {
			System.out.println("arr["+i+"] >>> " + arr[i]);
		}
	
	}
}
