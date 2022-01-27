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
	}
}
