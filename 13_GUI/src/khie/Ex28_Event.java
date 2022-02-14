package khie;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

/*
 * 3. Frame 클래스에 Listener를 구현하는 방법. - 가장 많이 사용.
 */


public class Ex28_Event extends JFrame implements MouseListener{
	
	public Ex28_Event() {
		
		JPanel container1 = new JPanel();
		
		JButton exit = new JButton("종 료");
		
		container1.add(exit);
		
		add(container1);
		
		setBounds(200,200,300,300);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		
		
		exit.addMouseListener(this); // 객체 자기자신을 가리키는 this문을 사용
	
	}
	
	public static void main(String[] args) {
		
		new Ex28_Event();
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.exit(0);
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}
}
