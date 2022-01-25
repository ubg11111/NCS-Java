package khie;

import javax.swing.JOptionPane;

/*
 * [문제] 키보드로 입력 받은 정수가 5로 나누어 떨어지면
 * 	"이 정수는 5의 배수입니다." 라고 메세지를 출력해 보세요.
 */


public class Ex03 {

	public static void main(String[] args) {
		
		
		System.out.println("프로그램 시작");
		
		int su = Integer.parseInt(JOptionPane.showInputDialog("정수를 입력하세요"));
		
		if((su % 5) == 0) {
			System.out.printf("이 정수는 %d값의 5배수입니다.%n",su);
		}
		System.out.println("프로그램 종료");
	}
}
