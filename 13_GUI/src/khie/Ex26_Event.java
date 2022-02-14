package khie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/*
 * Event Handler(이벤트 핸들러)
 * 
 * - 각 컴포넌트에 대하여 특정 행위를 하였을 때 그 행위에 대한.
 * 	 작업을 처리할 수 있도록 하는 것을 말함.
 * 	사용자 또는 프로그램에 의해 발행 할 수 있는 하나의 사건.
 * 
 * - 이벤트를 처리하는 자바 프로그램 코드로써 클래스를 만듬.
 * 	  이벤트 리스너는 인터페이스를 제공하며, 개발자는 이 인터페이스를
 *   상속을 받고 추상메서드를 구현하여 이벤트 리스너를 작성한다.
 * 
 * - 현재 발생한 이벤트에 관한 정보를 가진 객체를 말함. 이벤트 리스너에게 전달이 됨.
 * 		==> 예를 든다면 버튼을 눌렀다던지, 리스트 메뉴를 선택하였을 때 등등...
 * 
 * - 이벤트 처리 클래스 : java.awt.event 패키지 안에 있는 클래스.
 * 
 * - 각 컴포넌트별 이벤트 처리 메서드 : add로 시작하여 Listener로 끝나는 메서드.
 * - 이벤트 관련 클래스 : Listener 인터페이스, Adapter 클래스 , Event 클래스
 * - 이벤트 리스너는 모두가 다 인터페이스임(xxxListener)
 *   이벤트 리스너는 이벤트를 처리하는 프로그램 코드를 말함.
 *   이벤트 리스너는 컴포넌트에 연결되어 있어야 작동을 함.
 *   즉, 화면에 구성된 컴포넌트들은 이벤트 리스너를 하나씩 가지고 있음.
 *   
 *   - 컴포넌트와 리스너를 연결시키는 메서드 : addXXXXListener() ==> XXXX는 리스너 이름.
 *   - 이벤트 리스너 작성 과정
 *   1) 이벤트와 이벤트 리스너 선택 : 목적에 적합한 이벤트와 리스너 인터페이스 선택
 * 	 2) 이벤트와 리스너 클래스 작성 : 리스너 인터페이스를 상속받은 클래스를 작성하고
 * 							추상메서드를 모두 구현.
 * 	 3) 이벤트 리스너 등록 : 이벤트를 받을 컴포넌트에 이벤트 리스너 등록.
 * 
 * [이벤트 관련 용어]
 * - 이벤트 소스 : 이벤트를 발생시킨 GUI 컴포넌트를 말함.
 * - 이벤트 객체 : 발생한 이벤트에 대한 정보(이벤트 종류, 이벤트 소스, 화면 좌표, 마우스 버튼의 종류, 눌려진 키)를 담는 객체로써, 이벤트에 따라
 * 			      서로 다른 정보가 저장이 됨.
 * 
 * - 이벤트 리스너(Event Listener) : - 이벤트를 처리하는 코드로써 컴포넌트에
 * 								    등록이 되어야 작동이 가능함.
 * 								- 이벤트 소스와 이벤트 핸들러를 연결.
 * 								- 이벤트를 처리하는 객체를 말함.
 * 
 * 
 * Event Handler 클래스 생성 방법 - 4가지
 * 1. Listener 클래스를 구현하는 방법
 * 2. Adapter 클래스를 구현하는 방법
 * 3. Frame 클래스에 Listener를 구현하는 방법 - 가장 많이 사용.
 * 4. 익명 클래스를 이용하는 방법. - 많이 사용됨.
 * 
 * 
 */

// 1. Listener 클래스를 구현하는 방법 
class A implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "시스템이 종료 되었습니다.");
		System.exit(0); // 시스템을 종료시키는 메서드
	}
	
}

public class Ex26_Event extends JFrame{
	
	public Ex26_Event() {
		
		JPanel container1 = new JPanel();
		
		JButton exit = new JButton("종 료");
		
		container1.add(exit);
		
		add(container1);
		
		setBounds(200,200,300,300);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		
		A a = new A();
		
		exit.addActionListener(a); // A라는 객체의 참조변수 a를 해당 메서드에 넣어준다.
		
	}
	
	public static void main(String[] args) {
		new Ex26_Event();
	}
}
