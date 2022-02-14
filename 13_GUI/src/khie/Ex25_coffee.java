package khie;

import java.awt.BorderLayout;

import javax.swing.*;

public class Ex25_coffee extends JFrame{
	
	public Ex25_coffee() {
		
		setTitle("커피 자판기");
		
		// 컨테이너 만들기
		JPanel container1 = new JPanel();
		JPanel container2 = new JPanel();
		JPanel container3 = new JPanel();
		JPanel container4 = new JPanel();
		
		// 1-1 상단 컴포넌트 만들기
		JLabel jl1 = new JLabel("원하는 커피 선택");
		
		
		// 1-2 상단 컴포넌트 만들기
		JRadioButton jra1 = new JRadioButton("아메키라노(2500)");
		JRadioButton jra2 = new JRadioButton("카페모카(3500)");
		JRadioButton jra3 = new JRadioButton("에스프레소(2500)");
		JRadioButton jra4 = new JRadioButton("카페라떼(4000)");
		
		// 라디오 버튼 그룹화
		ButtonGroup bg = new ButtonGroup();
		bg.add(jra1);
		bg.add(jra2);
		bg.add(jra3);
		bg.add(jra4);
		
		
		// 1-2 중단 컴포넌트 만들기
		JLabel jl2 = new JLabel("수량 :");
		JTextField amount = new JTextField(10);
		
		JLabel jl3 = new JLabel("입금액 :");
		JTextField money = new JTextField(10);
		
		// 1-3 중단 컴포넌트 만들기
		JTextArea jta = new JTextArea(5,20);
		JScrollPane jsp = new JScrollPane(
				jta,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
				);
		
		jta.setLineWrap(true);
		
		
		// 1-4 하단 컴포넌트 만들기
		JButton result = new JButton("계 산");
		JButton exit = new JButton("종 료");
		JButton cancle = new JButton("취 소 ");
		
		
		// 상단 컴포넌트를 컨테이너에 올리기
		
		container1.add(jl1);

		
		// 1-1 상단 컴포넌트를 컨테이너에 올리기
		
		container2.add(jra1);
		container2.add(jra2);
		container2.add(jra3);
		container2.add(jra4);
		
		// 1-2 중단 컴포넌트를 컨테이너에 올리기
		
		container3.add(jl2);
		container3.add(amount);
		container3.add(jl3);
		container3.add(money);
		
		// 1-4 하단 컴포넌트를 컨테이너에 올리기
		
		container4.add(result);
		container4.add(exit);
		container4.add(cancle);
		
		// 2-1 상단 컨테이너 그룹
		JPanel group1 = new JPanel(new BorderLayout());
		group1.add(container1,BorderLayout.NORTH);
		group1.add(container2,BorderLayout.CENTER);
		
		// 2-2 하단 컨테이너 그룹
		JPanel group2 = new JPanel(new BorderLayout());
		group2.add(container3,BorderLayout.NORTH);
		group2.add(jsp,BorderLayout.CENTER);
		group2.add(container4,BorderLayout.SOUTH);
		
		// 컨테이너를 프레임에 올리기
		add(group1, BorderLayout.NORTH);
		add(group2, BorderLayout.SOUTH);
		
		setBounds(200,200,300,300);
		
		pack();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Ex25_coffee();
	}
}
