package khie;

import java.awt.Color;

import javax.swing.*;

public class Ex15_JTabbedPane extends JFrame {

	public Ex15_JTabbedPane() {
	
		JTabbedPane tab = new JTabbedPane();
		
		// 1. 탭의 갯수만큼 컨테이너가 있어야 한다.
		JPanel container1 = new JPanel();
		JPanel container2 = new JPanel();
		JPanel container3 = new JPanel();
		
		// 1-1. 컨테이너마다 배경색을 다르게 지정해 보자.
		container1.setBackground(Color.ORANGE);
		container2.setBackground(Color.GRAY);
		container3.setBackground(Color.YELLOW);
		
		// 2. 컴포넌트를 만들어 보자.
		// 2-1. 첫번째 탭에 들어갈 컴포넌트를 만들자.
		JButton button1 = new JButton("버튼1");
		JButton button2 = new JButton("버튼1");
		JButton button3 = new JButton("버튼1");
		
		// 2-1-1. 첫번째 탭에 올려질 컴포넌트를 컨테이너에 올려야 한다.
		container1.add(button1);
		container1.add(button2); container1.add(button3);
		
		// 2-2. 두번째 탭에 들어갈 컴포넌트를 만들자.
		JCheckBox jcb1 = new JCheckBox("여행");
		JCheckBox jcb2 = new JCheckBox("운동");
		JCheckBox jcb3 = new JCheckBox("게임");
		JCheckBox jcb4 = new JCheckBox("잠자기");
		
		// 2-2-1. 두번째 탭에 올려질 컴포넌트를 컨테이너에 올려야 한다.
		container2.add(jcb1); container2.add(jcb2);
		container2.add(jcb3); container2.add(jcb4);
		
		// 2-3. 세번째 탭에 들어갈 컴포넌트를 만들자.
		JLabel jl1 = new JLabel("이  름 : ");
		JTextField name = new JTextField(15);
		
		JLabel jl2 = new JLabel("연락처 : ");
		JTextField phone = new JTextField(15);
		
		JLabel jl3 = new JLabel("주  소 : ");
		JTextField addr = new JTextField(15);
		
		// 2-3-1. 세번째 탭에 올려질 컴포넌트를 컨테이너에 올려야 한다.
		container3.add(jl1); container3.add(name);
		container3.add(jl2); container3.add(phone);
		container3.add(jl3); container3.add(addr);
		
		// 3. 각각의 컨테이너들을 탭에 올려주어야 한다.
		tab.add("버튼 탭", container1);
		tab.add("체크박스 탭", container2);
		tab.add("개인정보 탭", container3);
		
		// 4. 탭을 프레임에 올려야 한다.
		add(tab);
		
		setBounds(200, 200, 300, 300);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
	
		new Ex15_JTabbedPane();

	}

}
