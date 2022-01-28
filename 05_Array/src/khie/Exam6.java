package khie;

public class Exam6 {

	public static void main(String[] args) {
		
		int[][] score = {
				{1},
				{2,3},
				{4,5,6},
				{7,8,9,10},
				{11,12,13,14,15},
			};
		
		for(int i=0; i<score.length; i++) {
			for(int j=0; j<score[i].length; j++) {
				System.out.print(score[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
		
		int[][] arr = new int[5][]; // 가변배열을 사용
		
		int num = 1;
		
		for(int i=0; i<arr.length; i++ ) {
			arr[i] = new int[i + 1];
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] = num++; // arr[i][j] 1씩 증가한다는거... i는 5개고정[5] j[] 가변배열 0부터 1개씩 증가함 i.length까지(5개)
				
				System.out.printf("%d\t", arr[i][j]);
			}
			System.out.println();
		}
		
		System.out.println();
		
		int[][] arryes = new int[5][]; // 가변배열을 사용
		
		int num2 = 5;
		
		for(int i=0; i<arryes.length; i++) {
			arryes[i] = new int[i+1]; // 가변배열의 j 값이 됨
			for(int j=0; j<arryes[i].length; j++) {
				arryes[i][j] = num2++;
				
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
}
