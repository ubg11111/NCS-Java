package khie;

/*
 *  문제 ) 아래와 같은 결과가 나타나도록 코딩해ㅔ 보세요.
 */

public class Exam4 {

	public static void main(String[] args) {
		
		int[][] score = new int[5][5]; // new int[i(5)] [j(5)]
			
			
			int su = 1;
		
			for(int i=0; i<score.length; i++) { // 행이 1씩 증가한다
				for(int j=0; j<score[i].length; j++) { // 열이 1씩 증가한다
					score[i][j] = su;
					
					++su;
				}
			}
			for(int i=0; i<score.length; i++) {
				for(int j=0; j<score[i].length; j++) {
					System.out.printf("%2d ", score[i][j]);
				}
				System.out.println();
			}
	}
}
