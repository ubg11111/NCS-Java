package khie;

/*
 * 다차원 배열
 * 	- 1차원 배열이 여러 개 묶여 있는 형태의 배열을 말함.
 * 	- 행과 열의 개념이 적용이 됨.
 */


public class Ex09 {

	public static void main(String[] args) {
		
		// 다차원 배열 선언 및 메모리 생성.
		int[][] arr = new int[3][4]; // 3행4열 다차원배열
		
		int count = 10;
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++)
				arr[i][j] = count;
			
			count +=10;
		}
		
		for(int  i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.println("arr["+i+"]["+j+"] >>> " + arr[i][j]);
			}
			System.out.println();
		}
	}
}
