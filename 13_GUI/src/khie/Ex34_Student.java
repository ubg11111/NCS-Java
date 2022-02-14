package khie;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Ex34_Student extends JFrame{
	
	String name;
	
	public Ex34_Student() {
		
		setTitle("성적처리");
		
		// 컨테이너 만들기
		JPanel container1 = new JPanel();
		JPanel container2 = new JPanel();
		JPanel container3 = new JPanel();
		
		
		// 1-1 상단 컨테이너에 올릴 컴포넌트 만들기
		JLabel jl1 = new JLabel("이름 : ");
		JTextField name = new JTextField(10);
		
		// 1-2 상단 컨테이너에 올릴 컴퍼넌트 만들기
		JLabel jl2 = new JLabel("국어 : ");
		JTextField kor = new JTextField(3);
		
		JLabel jl3 = new JLabel("영어 : ");
		JTextField eng = new JTextField(3);
		
		JLabel jl4 = new JLabel("수학 : ");
		JTextField mat = new JTextField(3);
		
		// 1-3 중단 컨테이너에 올릴 컴퍼넌트 만들기
		
		JTextArea jta = new JTextArea(5,20);
		JScrollPane jsp = new JScrollPane(
				jta,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
				);
		
		jta.setLineWrap(true);
		
		
		// 1-4 하단 컨테이너에 올릴 컴포넌트 만들기.
		
		JButton result = new JButton("계 산");
		JButton exit = new JButton("종 료");
		JButton cancel = new JButton("취 소");
		
		// 1-1 상단 컨테이너에 컴포넌트 올리기
		container1.add(jl1);
		container1.add(name);
		
		// 1-2 중단 컨테이너에 컴포넌트 올리기
		container2.add(jl2);
		container2.add(kor);
		container2.add(jl3);
		container2.add(eng);
		container2.add(jl4);
		container2.add(mat);
		
		// 1-3 하단 컨테이너에 컴포넌트 올리기.
		container3.add(result);
		container3.add(exit);
		container3.add(cancel);
		
		// 새로운 컨테이너 생성
		JPanel gruop1 = new JPanel(new BorderLayout());
		
		gruop1.add(container2, BorderLayout.NORTH);
		gruop1.add(jsp, BorderLayout.CENTER);
		gruop1.add(container3, BorderLayout.SOUTH);
		
		// 컨테이너 프레임에 올리기
		
		add(container1, BorderLayout.NORTH);
		add(gruop1, BorderLayout.CENTER);
		
		setBounds(200,200,300,300);
		
		pack();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		
		
		// 4. 이벤트 처리하기
		result.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String result = "";
				
				String name1 = name.getText();
				int kor1 = Integer.parseInt(kor.getText());
				int eng1 = Integer.parseInt(eng.getText());
				int mat1 = Integer.parseInt(mat.getText());
				int sum = (kor1 + eng1 + mat1);
				
				double avg = (sum) / 3.0;
				
				
				if(90 < avg) {
					jta.setText("A학점");
				} else if(80 < avg) {
					jta.setText("B학점");
				} else if(70 < avg) {
					jta.setText("C학점");
				} else if(60 < avg) {
					jta.setText("D학점");
				} else {
					jta.setText("E학점");
				}
				
				jta.append(result + "\n");
				
				
				
			}
		});
		
	}
	
	public static void main(String[] args) {
		new Ex34_Student();
	}
}
