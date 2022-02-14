package khie;

import javax.swing.*;

public class Ex13_JLabel_JTextField extends JFrame {

	public Ex13_JLabel_JTextField() {
	
		setTitle("JLabel&JTextField 예제");
		
		// 컨테이너를 만들자.
		JPanel container = new JPanel();
		
		// 1. 컴포넌트를 만들어 보자.
		JLabel jl1 = new JLabel("이  름 : ");
		JTextField name = new JTextField(15);
		
		JLabel jl2 = new JLabel("학  과 : ");
		JTextField major = new JTextField(15);
		
		JLabel jl3 = new JLabel("주  소 : ");
		JTextField address = new JTextField(15);
		
		// 2. 컴포넌트를 컨테이너에 올려야 한다.
		container.add(jl1); container.add(name);
		container.add(jl2); container.add(major);
		container.add(jl3); container.add(address);
		
		// 3. 컨테이너를 프레임에 올려야 한다.
		add(container);
		
		setBounds(200, 200, 250, 200);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new Ex13_JLabel_JTextField();

	}

}
