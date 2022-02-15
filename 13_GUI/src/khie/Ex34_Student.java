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
		JTextField jtf1 = new JTextField(10);
		
		// 1-2 상단 컨테이너에 올릴 컴퍼넌트 만들기
		JLabel jl2 = new JLabel("국어 : ");
		JTextField jtf2 = new JTextField(3);
		
		JLabel jl3 = new JLabel("영어 : ");
		JTextField jtf3 = new JTextField(3);
		
		JLabel jl4 = new JLabel("수학 : ");
		JTextField jtf4 = new JTextField(3);
		
		
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
		container1.add(jtf1);
		
		// 1-2 중단 컨테이너에 컴포넌트 올리기
		container2.add(jl2);
		container2.add(jtf2);
		container2.add(jl3);
		container2.add(jtf3);
		container2.add(jl4);
		container2.add(jtf4);
		
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
		
		
		// 계산(result)를 눌럿을 때 이벤트 처리
		result.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String name = jtf1.getText();
				int kor = Integer.parseInt(jtf2.getText());
				int eng = Integer.parseInt(jtf3.getText());
				int mat = Integer.parseInt(jtf4.getText());
				
				//총점을 구하자
				int sum = (kor+eng+mat);
				
				// 평균을 구하자
				double avg = (sum) / 3.0;
				
				// 학점을 구하자.
				String grade = "";
				
				if(90 < avg) {
					grade = "A학점";
				} else if(80 < avg) {
					grade = "B학점";
				} else if(70 < avg) {
					grade = "C학점";
				} else if(60 < avg) {
					grade = "D학점";
				} else {
					grade = "E학점";
				}
				
				jta.append("****" + name + "님 성적결과****" + "\n");
				jta.append("이름 : " + name + "\n");
				jta.append("국어점수 " + kor + "점\n");
				jta.append("영어점수 " + eng + "점\n");
				jta.append("수학점수" + mat + "점\n");
				jta.append("총점" + sum + "점\n");
				jta.append("평균" + String.format("%.2f점",avg) + "\n");
				jta.append("학점" + grade + "\n");
				
				jtf1.setText("");
				jtf2.setText(null);
				jtf3.setText(null);
				jtf4.setText(null);
				
				jtf1.requestFocus();
			}
		});
		// 4-2. 종료(exit) 버튼을 클릭햇을 때 이벤트 처리
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		// 4-3 취소(cancel) 버튼을 클릭했을 때 이벤트 처리
		
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 전체 컴포넌트의 값을 초기화 시키는 작업.
				jtf1.setText(""); 
				jtf2.setText(null);
				jtf3.setText(null);
				jtf4.setText(null);		
				jta.setText(null);
				
				jtf1.requestFocus();
			}
		});
	}
	
	public static void main(String[] args) {
		new Ex34_Student();
	}
}
