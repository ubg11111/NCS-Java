package khie;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

// 2.Adapter를 이용한 


class B extends MouseAdapter {
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		JOptionPane.showMessageDialog(null, "시스템을 종료 하였습니다.");
		
		System.exit(0);
	}
}

public class Ex27_Event extends JFrame{
	
	public Ex27_Event() {
			
			JPanel container1 = new JPanel();
			
			JButton exit = new JButton("종 료");
			
			container1.add(exit);
			
			add(container1);
			
			setBounds(200,200,300,300);
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			setVisible(true);
			
			B b = new B();
			
			exit.addMouseListener(b); // A라는 객체의 참조변수 a를 해당 메서드에 넣어준다.
		
	}
	
	public static void main(String[] args) {
		
		new Ex27_Event();
		
	}
}

