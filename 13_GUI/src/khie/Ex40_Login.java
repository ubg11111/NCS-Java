package khie;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.security.auth.login.LoginContext;
import javax.swing.*;
import javax.swing.border.Border;

public class Ex40_Login extends JFrame{
	
	public Ex40_Login() {
		
		setTitle("제품관리 시스템");
		
		// 컨테이너 만들기
		JPanel container1 = new JPanel();
		JPanel container2 = new JPanel();
		JPanel container3 = new JPanel();
		JPanel container4 = new JPanel();
		
		
		
		// 상단 컴포넌트 만들기
		JLabel login = new JLabel("로그인 화면");
		login.setForeground(new Color(5,0,153));
		login.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		
		
		
		// 중단 컴포넌트 만들기
		JLabel jl1 = new JLabel("아이디 :     ");
		JTextField jt1 = new JTextField(10);
		JLabel jl2 = new JLabel("비밀번호 : ");
		JPasswordField jt2 = new JPasswordField(10);
		
		
		// 하단 컴포넌트 만들기
		JButton jbt1 = new JButton("로그인");
		JButton jbt2 = new JButton("회원가입");
		
	
		
		
		// 컴포넌트를  상단 컨테이너에 올리기
		container1.add(login);
		
		
		// 컴포넌트를 중단 컨테이너에 올리기
		container2.add(jl1);
		container2.add(jt1);
		container3.add(jl2);
		container3.add(jt2);
		
		
		// 컴포넌트를 하단 컨테이너에 올리기
		container4.add(jbt1);
		container4.add(jbt2);
		
		// 그룹화 하기
		JPanel group1 = new JPanel();
		
		group1.add(container2, BorderLayout.NORTH);
		group1.add(container3, BorderLayout.SOUTH);
		
		
		// 컨테이너를 프레임에 올리기
		add(container1, BorderLayout.NORTH);
		add(group1, BorderLayout.CENTER);
		add(container4, BorderLayout.SOUTH);
		
		
		
		setBounds(200, 200, 400, 250);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		
		setResizable(false);
		
		// 이벤트 적용하기
		
		
		// 로그인버튼클릭시 화면 출력하기
		jbt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String id = jt1.getText();
				String pw = new String(jt2.getPassword());
				
				JOptionPane.showMessageDialog(null, "아이디 : " + id + "," + "비밀번호 : " + pw);
			}
		});
		
		// 회원가입으로 넘어가기
		jbt2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new Ex41_Join();
				dispose(); // 해당 로그인 페이지 프레임을 종료
			}
		});
	}
	
	public static void main(String[] args) {
		new Ex40_Login();
	}
}
