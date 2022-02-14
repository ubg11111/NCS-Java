package khie;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Ex32_Event extends JFrame{
	
	JLabel label;
	
	public Ex32_Event() {
		
		setTitle("키 이벤트 처리");
		
		JPanel container = new JPanel();
		
		// 1. 컴포넌트를 만들어 보자.
		
		label = new JLabel();
		
		
		// 2. 컴포넌트를 컨테이너에 올려야 한다.
		container.add(label);
		
		// 3. 컨테이너를 프레임에 올려야 한다.
		
		add(container);
		
		
		/*
		 * 키 이벤트는 포커스가 위치해 있어야 키 이벤트가 발생을 함.
		 * 강제적으로 포커스를 설정해 주어야 함.
		 * 키 이벤트는 포커스를 받을 수 있는 컴포넌트를
		 * 우선적으로 입력을 받기 위해 setFocuesable(true);
		 * 
		 */
		
		container.setFocusable(true);
		
		
		setBounds(200,200,500,500);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		
		
		//4. 이벤트 처리
		container.addKeyListener(new KeyListener() {
			
			
			// 키보드 자판의 어떤 키의 문자가 눌렸을 때 실행되는 메서드
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			
			// 키보드가 눌렷다가 떼어졋을 때 실행되는 메서드
			@Override
			public void keyReleased(KeyEvent e) {
				
				String str = 
						KeyEvent.getKeyText(e.getKeyCode());
				
				label.setText(str + "키가 입력 되었습니다.");
				
				if(e.getKeyCode() == KeyEvent.VK_F1) {
					container.setBackground(Color.BLUE);
				} else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					container.setBackground(Color.YELLOW);
				} else {
					container.setBackground(Color.WHITE);
				}
			}
			
			// 키보드의 키가 눌러졋을 때 실행되는 메서드
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public static void main(String[] args) {
		new Ex32_Event();
	}

}
