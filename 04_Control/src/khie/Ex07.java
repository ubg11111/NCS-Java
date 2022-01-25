package khie;

import javax.swing.JOptionPane;

/*
 * [문제] 키보드로부터 입력받은 정수값을 5의 배수이면
 *  
 *  " 이정수는 5의 배수입니다." 라고 출력을 하고 , 그렇지 않으면
 * 	" 이 정수는 5의 배수가 아닙니다" 라고 화면에 출력을 해 보자.
 * 단 , 입력받은 정수가 음수이면  "음수 값이 입력 되었습니다. " 라고 출력해보자.
 */

public class Ex07 {

	public static void main(String[] args) {
		
		int su = Integer.parseInt(JOptionPane.showInputDialog("값을 입력하세요"));
	
	
		if(su % 5 == 0) {
			System.out.println("이 정수는 5의 배수 입니다.");
		} else if(su <= 0) {
			System.out.println("입력받은 값은 음수입니다.");
		}else {
			System.out.println("이 정수는 5의 배수가 아닙니다.");
		}
		System.out.println("반복문 종료");
	}
}
