package khie;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

public class Ex39_Event extends JFrame{
	
	public Ex39_Event() {
		
		setTitle("색상 예제");
		
		JMenuBar bar = new JMenuBar();
		
		JMenu menu = new JMenu("글자");
		
		JMenuItem item = new JMenuItem("글자색");
		
		// 1. 메뉴 아이템을 메뉴에 올려주어야 한다.
		menu.add(item);
		
		
		// 2. 메뉴를 메뉴바에 올려주어야 한다.
		bar.add(menu);
		
		
		setJMenuBar(bar);
		
		JPanel container = new JPanel(new BorderLayout());
		
		// 1. 컴포넌트를 만들어 보자.
		JLabel label = new JLabel("방가 방가");
		
		/*
		 * new Font("글자체", "효과", "글자크기");
		 * - 글자체 : 컴퓨터에 설치된 글자체 사용 가능.
		 * - 효과 : Font.BOLD - 진하게 쓸 수 있는 메서드
		 * 		   Font.ITALIC : 기울기 
		 * 		   Font.PLAIN : 보통 글자체
		 */
		
		label.setFont(new Font("맑은 고딕",Font.ITALIC, 25));
		
		
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		// 2. 컴포넌트를 컨테이너에 올려야 한다.
		
		container.add(label);
		
		// 3. 프레임에 컨테이너를 올려야 한다.
		
		add(container, BorderLayout.CENTER);
		
		setBounds(200, 200, 500, 500);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		
		
		// 4. 이벤트를 처리해 보자.
		// "글자색" 이라는 메뉴를 선택했을 때 이벤트 처리.
		
		item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// 이벤트를 발생시킨 객체(컴포넌트)
				String command = e.getActionCommand();
				
				if(command.equals("글자색")) {
					// 컬러 다이얼로그 출력을 하고 사용자가 선택한 색상을 알아오는 직업.
					Color selectedColor = JColorChooser.showDialog(null, "Color", Color.YELLOW);
					
					if(selectedColor != null) {
						label.setForeground(selectedColor);
					}
				}
				
			}
		});
	}
	
	
	public static void main(String[] args) {
		new Ex39_Event();
	}
}
