package teamproject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Chat extends JFrame{
	
	JPanel inputPanel;
	JPanel displayPanel;
	JPanel backPanel;
	JButton back;
	JTextArea display;
	JTextField input;
	JButton inputButton;
	Color color;
	
	public Chat() {
		setTitle("채팅창");
		color = new Color(051,153,255); // 색 지정해주기
		
		// 컨테이너 만들기
		displayPanel = new JPanel();
		inputPanel = new JPanel();
		backPanel = new JPanel();
		
		// 패널 색 설정하기
		displayPanel.setBackground(color);
		inputPanel.setBackground(Color.white);
		backPanel.setBackground(color);
		
		// 컴포넌트 크기 조절하기
		displayPanel.setPreferredSize(new Dimension(0,450)); // 0 width , 400 height
		
		
		// 상단 컨테이너에 올릴 컴포넌트 만들기
		back = new JButton(ImageChage2.changeIcon5);
		back.setBorderPainted(false);
		back.setContentAreaFilled(false);
		back.setFocusPainted(false);
		
		
		// 중단 컨테이너에 올릴 컴포넌트 만들기
		display = new JTextArea(11,30);
		
		// display 텍스트에어리어 색 넣기
		display.setBackground(color);
		Font displayFont = new Font("Gothic", Font.BOLD, 17);
		JScrollPane scroll = new JScrollPane(
				display,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
				);
		display.setLineWrap(true);
		display.setFont(displayFont);
		display.setEditable(false); // 텍스트에어리어창에 입력을 불가하게함
		
		// 하단 컨테이너에 올릴 컴포넌트 만들기
		input = new JTextField(25);
		inputButton = new JButton("전송");
		inputButton.setBackground(Color.YELLOW);
		Font inputFont = new Font("Gothic", Font.BOLD, 15);
		input.setFont(inputFont);
		inputButton.setBorderPainted(false);
		
		
		// 상단 컨테이너에 컴포넌트 올리기
		backPanel.setLayout(new BorderLayout(0,100));
		backPanel.add(back, BorderLayout.EAST);
		
		
		
		// 중단 컨테이너에 컴포넌트 올리기
		displayPanel.setLayout(new BorderLayout(500,200));
		displayPanel.add(display, BorderLayout.WEST);
		displayPanel.add(scroll);
		
		
		// 하단 컨테이너에 컴포넌트 올리기
		inputPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		inputPanel.add(input);
		inputPanel.add(inputButton);
		inputPanel.setPreferredSize(new Dimension(200,60));
		
		
		/*
		 * 프레임에 두개의 패널 붙이기
		 *
		 */
		add(backPanel, BorderLayout.NORTH);
		add(displayPanel, BorderLayout.CENTER);
		add(inputPanel, BorderLayout.SOUTH);
		
		setBounds(200,200,400,650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		
		
		// 클릭이벤트 처리하기
		inputButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				display.append(input.getText() + "\n");
				input.setText("");
				input.requestFocus();
			}
		});
		
		{	
		}
		// 버튼에 마우스를 갓다 댓을 때 배경색이 변하게끔 조정
		inputButton.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
				inputButton.setBackground(Color.YELLOW);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				inputButton.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
		
		// 엔터를 쳣을 때 이벤트 처리
		input.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					display.append(input.getText() + "\n");
					input.setText("");
					input.requestFocus();
				}
			}
		});
		
		// 뒤로가기 눌럿을 때 이벤트 처리
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Main();
				dispose();
			}
		});
	}
	
		

	public static void main(String[] args) {
		new Chat();
	}
}
