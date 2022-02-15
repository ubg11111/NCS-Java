package khie;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.FontUIResource;


public class Ex41_Join extends JFrame{
	
	
	JRadioButton client;
	JRadioButton manager;
	JRadioButton etc;
	
	
	public Ex41_Join() {
		
		setTitle("제품관리 시스템");
		
		JLabel title = new JLabel("회원가입", JLabel.CENTER);
		
		title.setForeground(new Color(5,0,153));
		title.setFont(new FontUIResource("휴먼편지체", Font.BOLD, 25));
		
		
		JButton join = new JButton("회원가입");
		JButton cancel = new JButton("취소");
		
		JTextField id = new JTextField(10);
		JPasswordField pwd = new JPasswordField(10);
		JTextField name = new JTextField(10);
		JTextField phone = new JTextField(10);
		
		client = new JRadioButton("고객");
		manager = new JRadioButton("관리자");
		etc = new JRadioButton("기타");
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(client);
		bg.add(manager);
		bg.add(etc);
		
		
		//radio 패널
		JPanel radioPanel = new JPanel();
		radioPanel.add(client);
		radioPanel.add(manager);
		radioPanel.add(etc);
		
		// form panel
		JPanel idPanel = new JPanel();
		idPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		idPanel.add(new JLabel("아이디 : "));
		idPanel.add(id);
		
		JPanel pwPanel = new JPanel();
		pwPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pwPanel.add(new JLabel("비밀번호 : "));
		pwPanel.add(pwd);
		
		JPanel namePanel = new JPanel();
		namePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		namePanel.add(new JLabel("이름 : "));
		namePanel.add(name);
		
		JPanel phonePanel = new JPanel();
		phonePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		phonePanel.add(new JLabel("연락처 : "));
		phonePanel.add(phone);
		
		JPanel formPanel = new JPanel();
		formPanel.setLayout(new GridLayout(4,1));
		formPanel.add(idPanel);
		formPanel.add(pwPanel);
		formPanel.add(namePanel);
		formPanel.add(phonePanel);
		
		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(new FlowLayout());
		contentPanel.add(radioPanel);
		contentPanel.add(formPanel);
		
		JPanel panel = new JPanel();
		panel.add(join);
		panel.add(cancel);
		
		// 프레임에 올리기
		add(title, BorderLayout.NORTH);
		add(contentPanel, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
		
		setBounds(200, 200, 250, 300);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		
		
		// 이벤트 처리하기
		
		// 고객
		client.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, client.getText() + "를(을)선택했군요.");
			}
		}); 
		// 관리자
		manager.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, manager.getText() + "를(을)선택했군요.");
				
			}
		});
		//기타
		etc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, etc.getText() + "를(을)선택했군요.");
			}
		});
		
		// 회원가입 버튼 클릭시 메시지 출력
		join.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id1 = id.getText();
				String pw1 = new String(pwd.getPassword());
				String name1 = name.getText();
				String phone1 = phone.getText();
				String pp1 = client.getText();
				String pp2 = manager.getText();
				String pp3 = etc.getText();
				
				
				// 조건문으로 해당 라디오버튼이 체크되어 있을 때 해당 라디오버튼의 텍스트값을 가져온다
				if(client.isSelected()) {
					JOptionPane.showMessageDialog(null, id1 + pw1 + name1 + phone1 + pp1);
				} else if(manager.isSelected()) {
					JOptionPane.showMessageDialog(null, id1 + pw1 + name1 + phone1 + pp2);
				} else if(etc.isSelected()) {
					JOptionPane.showMessageDialog(null, id1 + pw1 + name1 + phone1 + pp3);
				}
				
			}
		});
		
		
		// 취소버튼 클릭시
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Ex40_Login();
				dispose();
			}
		});
	}
	
	public static void main(String[] args) {
		new Ex41_Join();
	}
}
