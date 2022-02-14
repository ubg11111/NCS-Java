package khie;

import java.awt.BorderLayout;

import javax.swing.*;


public class Ex22_Layout02 extends JFrame {

	public Ex22_Layout02() {
		setTitle("계산기 예제 - 2");
		
		// 컨테이너를 만들자 .
		
		JPanel container1 = new JPanel();
		JPanel container2 = new JPanel();
		
		
		// 1. 컴포넌트를 만들어 보자.
		// 1-1 상단 컨테이너에 들어갈 컴포넌트들을 만들자.
		JLabel jl1 = new JLabel("수 1 : ");
		JTextField su1 = new JTextField(5);
		
		JLabel jl2 = new JLabel("수 1 : ");
		JTextField su2 = new JTextField(5);
		
		JLabel jl3 = new JLabel("연산자 : ");
		JRadioButton jrb1 = new JRadioButton("+");
		JRadioButton jrb2 = new JRadioButton("-");
		JRadioButton jrb3 = new JRadioButton("*");
		JRadioButton jrb4 = new JRadioButton("/");
		JRadioButton jrb5 = new JRadioButton("%");
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);
		bg.add(jrb3);
		bg.add(jrb4);
		bg.add(jrb5);
		
		// 1-2 중앙에 들어갈 컴포넌트들을 만들자.
		JTextArea jta = new JTextArea(5,20);
		JScrollPane js = new JScrollPane(
				jta,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
				);
		
		jta.setLineWrap(true);
		
		// 1-3 하단 컨테이너에 들어갈 컴포넌트들을 만들자.
		JButton result = new JButton("계 산");
		JButton exit = new JButton("종 료");
		JButton cancel = new JButton("취 소");
	
	
		// 2. 컴포넌트들을 컨테이너에 올려줘야 한다.
		// 2-1 상단 컨테이너에 올려질 컴포넌트들을 추가해 주자.
		container1.add(jl1);
		container1.add(jl2);
		container1.add(jl3);
		container1.add(su1);
		container1.add(su2);
		container1.add(jrb1);
		container1.add(jrb2);
		container1.add(jrb3);
		container1.add(jrb4);
		container1.add(jrb5);
		
		// 2-2 하단 컨테이너에 올려질 컴포넌트들을 추가해 주자.
		container2.add(result);
		container2.add(exit);
		container2.add(cancel);
		
		// 3. 컨테이너를 프레임에 올려 줄 때 배치관리자를 통해서 올려 주자.
		add(container1, BorderLayout.NORTH);
		add(js,BorderLayout.CENTER);
		add(container2, BorderLayout.SOUTH);
		
		setBounds(200,200,450,200);
		
		pack();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new Ex22_Layout02();
	}
}
