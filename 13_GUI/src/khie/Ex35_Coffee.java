package khie;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Ex35_Coffee extends JFrame{
	
	public Ex35_Coffee() {
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
		JTextField jtp1 = new JTextField(10);
		
		JLabel jl3 = new JLabel("입금액 :");
		JTextField jtp2 = new JTextField(10);
		
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
		JButton window = new JButton("새 창 ");
		
		
		// 상단 컴포넌트를 컨테이너에 올리기
		
		container1.add(jl1);

		
		// 1-1 상단 컴포넌트를 컨테이너에 올리기
		
		container2.add(jra1);
		container2.add(jra2);
		container2.add(jra3);
		container2.add(jra4);
		
		// 1-2 중단 컴포넌트를 컨테이너에 올리기
		
		container3.add(jl2);
		container3.add(jtp1);
		container3.add(jl3);
		container3.add(jtp2);
		
		// 1-4 하단 컴포넌트를 컨테이너에 올리기
		
		container4.add(result);
		container4.add(exit);
		container4.add(cancle);
		container4.add(window);
		
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
		
		
		// 4 이벤트 작업
		
		// 계산을 눌럿을때 이벤트 작업
		result.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String coffeeStr = ""; // 커피 종류가 저장될 변수 선언
				int coffeePrice = 0; // 커피의 단가
				
				if(jra1.isSelected()) {
					coffeeStr = "아메리카노";
					coffeePrice = 2500;
				}  else if(jra2.isSelected()) {
					coffeeStr = "카페모카";
					coffeePrice = 3500;
				} else if(jra3.isSelected()) {
					coffeeStr = "에스프레소";
					coffeePrice = 2500;
				} else if(jra4.isSelected()) {
					coffeeStr = "카페라떼";
					coffeePrice = 4000;
				}
				
				int amount = Integer.parseInt(jtp1.getText());
				int money = Integer.parseInt(jtp2.getText());
				
				// 공급가액을 계산하기 : 수량 * 단가
				int sum = amount * coffeePrice;
				
				// 부가세액 계산 : 공급가액 * 0.1
				int vat = (int)(sum * 0.1);
				
				// 총금액 계산 : 공급가액 + 부가세액
				int total = sum + vat;
				
				// 잔액(거스름돈) 계산 : 입금액 - 총금액
				int result = money - total;
				
				// 결과를 출력해보자.
				
				jta.append("커피종류 : " + coffeeStr + "\n");
				jta.append("커피단가 : " + coffeePrice + "원\n");
				jta.append("수량 : " + amount + "\n");
				jta.append("공급가액 : " + sum + "원\n");
				jta.append("부가세액 : " + vat + "원\n");
				jta.append("총금액 : " + total + "원\n");
				jta.append("입금액 : " + money + "원\n");
				jta.append("거스름돈 : " + result + "원\n");
				
				
				// 각각의 컴포넌트 초기화 작업
				jtp1.setText("");
				jtp2.setText("");
				bg.clearSelection();
				
			}
		});
		
		// 종료 버튼 클릭시 이벤트 처리
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		// 취소 버튼 클릭 시 이벤트 처리
		cancle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jtp1.setText("");
				jtp2.setText("");
				jta.setText("");
				bg.clearSelection();
			}
		});
		
		// 새창(window) 버튼을 클릭 했을 때 이벤트처리
		window.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new Ex15_JTabbedPane();
				
			}
		});
	}

	
	public static void main(String[] args) {
		new Ex35_Coffee();
	}
}
