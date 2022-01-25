package khie;

import javax.swing.JOptionPane;
import java.util.*;

/*
 * [문제] 키보드로 점수를 입력받아서 입력받은 점수가
 * 		60점 이상이면 "합격" 이라는 문자열을 화면에 
 * 		출력하고 , 그렇지 않으면 "불합격 " 이라는
 * 		문자열을 화면에 출력해 보세요.
 */


public class Ex09 {

	public static void main(String[] args) {
		
//		int su1 = Integer.parseInt(JOptionPane.showInputDialog("점수를 입력하세요 : "));
		
		// System.in : 표준입력장치(키보드)
		Scanner sc = new Scanner(System.in);
		
		System.out.print("점수를 입력하세요 : ");
		
		int su1 = sc.nextInt(); // nextInt 통해 형변환 후 출력가능
	
		if(su1 >= 60 && su1 <= 100) {
			System.out.println("합격");
		}
		else if(su1 <= 59) {
			System.out.println("불합격");
		}else {
			System.out.println("다른값을 입력하셨습니다.");
		}
		
		// Scanner 종료
		sc.close();
	}

}
