package khie;

import java.awt.BorderLayout;

import javax.swing.*;

// 간단하게 계산기 화면을 구성해 보자.

public class Ex21_Layout01 extends JFrame {

	public Ex21_Layout01() {
	
		setTitle("간단한 계산기");
		
		// 컨테이너를 3개를 만들자.
		JPanel container1 = new JPanel();  // 상단 컴포넌트들이 들어갈 컨테이너
		JPanel container2 = new JPanel();  // 중앙 컴포넌트들이 들어갈 컨테이너
		JPanel container3 = new JPanel();  // 하단 컴포넌트들이 들어갈 컨테이너
		
		// 1. 컴포넌트들을 만들어 보자.
		// 1-1. 상단 컨테이너에 들어갈 컴포넌트들을 만들자.
		JLabel jl1 = new JLabel("수 1 : ");
		JTextField su1 = new JTextField(5);
		
		JLabel jl2 = new JLabel("수 2 : ");
		JTextField su2 = new JTextField(5);
		
		JLabel jl3 = new JLabel("연산자 : ");
		JTextField op = new JTextField(1);
		
		// 1-2. 중앙 컨테이너에 들어갈 컴포넌트들을 만들자.
		JTextArea jta = new JTextArea(5, 20);
		JScrollPane jsp = new JScrollPane(
				jta, 
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		jta.setLineWrap(true);   // 자동 줄바꿈 기능 설정
		
		// 1-3. 하단 컨테이너에 들어갈 컴포넌트들을 만들자.
		JButton result = new JButton("계  산");
		JButton exit = new JButton("종  료");
		JButton cancel = new JButton("취  소");
		
		
		// 2. 컴포넌트들을 컨테이너에 추가해 주어야 한다.
		// 2-1. 상단 컨테이너에 들어갈 컴포넌트들을 추가해 주자.
		container1.add(jl1); container1.add(su1);
		container1.add(jl2); container1.add(su2);
		container1.add(jl3); container1.add(op);
		
		// 2-2. 중앙 컨테이너에 들어갈 컴포넌트들을 추가해 주자.
		container2.add(jsp);
		
		// 2-3. 하단 컨테이너에 들어갈 컴포넌트들을 추가해 주자.
		container3.add(result);
		container3.add(exit); container3.add(cancel);
		
		// 3. 컨테이너를 프레임에 올려주어야 한다.
		// 프레임에 3개의 컨테이너를 올려야 함. 배치를 해서 올리면 됨.
		add(container1, BorderLayout.NORTH);
		add(container2, BorderLayout.CENTER);
		add(container3, BorderLayout.SOUTH);
		
		setBounds(200, 200, 100, 300);
		
		// pack() : JFrame에 올라온 컴포넌트(내용물)를 알맞게 
		//          프레임의 크기를 조절해 주는 메서드
		pack();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
	
		new Ex21_Layout01();

	}

}
