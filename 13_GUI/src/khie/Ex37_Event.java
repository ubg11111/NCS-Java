package khie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * 다이얼로그
 * - 다이얼로그는 보여주고자 하는 내용을 스크린에 출력을 하고,
 * 	 사용자로부터 입력을 받는 대화상자임.
 * 
 * 
 * 팝업 다이얼로그
 * - 사용자에게 메세지를 전달하거나 간단한 문자열을 입력 받는 유용한 다이얼로그임.
 * 	 1)입력 다이얼로그 : JOptionPance.showInputDialog()
 * 						==> 한 줄 문자열을 입력 받는 다이얼로그.
 * 						
 * 	 2)확인 다이얼로그 : JoptionPance.showConfirmDialog()
 * 						==> 사용자로부터 확인 / 취소를 입력받는 다이얼로그.
 * 
 * 	 3)메시지 다이얼로그 : JOptionPance.showMessageDialog()
 * 						==> 사용자에게 문자열 메세지를 출력 하기 위한 다이얼로그.
 * 
 */


public class Ex37_Event extends JFrame{
	
	public Ex37_Event() {
		
		setTitle("다이얼로그 예제");
		
		JPanel container = new JPanel();
		
		//1. 컴포넌트를 만들어 보자.
		JButton inputbtButton = new JButton("Input Name");
		JButton confirmButton = new JButton("Confirm");
		JButton messageButton = new JButton("Message");
		
		JTextField field = new JTextField(20);
		
		//2. 컴포넌트를 컨테이너에 올려야 한다.
		container.add(inputbtButton);
		container.add(confirmButton);
		container.add(messageButton); 
		container.add(field); 
		
		
		//3. 컨테이너를 프레임에 올려야 한다.
		add(container);
		
		setBounds(200, 200, 500, 200);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		
		
		//4. 이벤트 처리
		inputbtButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 입력 다이얼로그 생성
				String name =
						JOptionPane.showInputDialog("이름을 입력하세요");
				
				if(name != null) {
					// 사용자가 입력한 문자열을 텍스트필드 컴포넌트에 출력하는 메서드
					field.setText(name);
				} else {
					JOptionPane.showMessageDialog(null, "이름을 입력하세요");
				}
			}
		});
		
		//확인 버튼
		confirmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 확인 다이얼로그 창 생성
				
				int result = 
						JOptionPane.showConfirmDialog(null, "계속 하실 건가요?","Confirm", JOptionPane.YES_NO_OPTION);
				
				if(result == JOptionPane.YES_OPTION) {
					field.setText("YES");
				} else {
					field.setText("NO");
				}
			}
		});
		
		
		// 메시지버튼
		messageButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				JOptionPane.showMessageDialog(null, "조심하세요", "Message", JOptionPane.WARNING_MESSAGE);
				
				
			}
		});
	}
	
	
	public static void main(String[] args) {
		new Ex37_Event();
	}
}
