package teamproject;

import java.awt.*;
//import java.awt.Color;
//import java.awt.Component;
//import java.awt.FlowLayout;
//import java.awt.Font;
//import java.awt.Graphics;
//import java.awt.GridBagLayout;
//import java.awt.GridLayout;
//import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
//import javax.swing.border.Border;
import javax.swing.border.LineBorder;
//import javax.swing.border.Border;
//import javax.swing.text.StyledEditorKit.UnderlineAction;

public class Search extends JFrame {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	JTextField jtf1, jtf2, jtf3, jtf4;
	JComboBox domain1 = null;
	String X = null;
	
	public Search() {
		setTitle("아이디/비밀번호 찾기");
		
		//1. 상단 컴포넌트
		JLabel main = new JLabel("아이디/비밀번호 찾기");
		JLabel main2 = new JLabel("회원가입시 등록한 이름, 아이디, 이메일을 입력해주세요.");
		
		//1-1. 아이디 찾기 컴포넌트
		JLabel searchId = new JLabel("아이디 찾기                                                                           ");
		JLabel jl1 = new JLabel("이         름 : ");
		JLabel jl2 = new JLabel("전화번호 : ");
		
		 jtf1 = new JTextField(10);
		 jtf2 = new JTextField(10);
		
		JButton jb1 = new JButton("아이디 찾기");
		
		//1-2. 비밀번호 찾기 컴포넌트
		JLabel searchpwd = new JLabel("비밀번호 찾기                                                                       ");
		JLabel jl3 = new JLabel("아  이  디 : ");
		JLabel jl4 = new JLabel("이  메  일 : ");
		
		JLabel at = new JLabel("@");
		
		String[] domain = {"-선택-","naver.com","gmail.com","hanmail.net","hotmail.com","korea.com","nate.com","yahoo.com"};
		domain1 = new JComboBox<String>(domain);
		
		 jtf3 = new JTextField(10);
		 jtf4 = new JTextField(7);
		
		JButton jb2 = new JButton("비밀번호 찾기");
		
		JButton jb3 = new JButton("로그인 화면");
		
		//2. 컨테이너
		//main 컨데이너
		JPanel container1 = new JPanel(new FlowLayout(FlowLayout.LEFT,10,10));
		container1.add(main);
		main.setFont(new Font("맑은고딕", Font.BOLD, 30));
		container1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
		
		//main2 컨테이너
		JPanel container2 = new JPanel(new FlowLayout(FlowLayout.LEFT,10,10));
		container2.add(main2);
		main2.setForeground(Color.gray);
		
		//아이디 컨테이너
		
		JPanel  containerId1 = new JPanel();
		containerId1.add(searchId);
		
		JPanel containerId2 = new JPanel();
		containerId2.add(jb1);
		
		JPanel containerId = new JPanel(new BorderLayout());
		
		JPanel groupId1 = new JPanel(new FlowLayout(FlowLayout.CENTER,20,10));
		JPanel groupId2 = new JPanel(new FlowLayout(FlowLayout.LEFT,20,10));
		JPanel groupId3 = new JPanel(new FlowLayout(FlowLayout.CENTER,20,10));
		JPanel groupId4 = new JPanel(new FlowLayout(FlowLayout.LEFT,20,10));
		
		groupId1.add(jl1);
		groupId3.add(jl2);
		groupId2.add(jtf1);
		groupId4.add(jtf2);
		
		JPanel groupId = new JPanel(new GridLayout(2,2,0,0));
		groupId.add(groupId1);
		groupId.add(groupId2);
		groupId.add(groupId3);
		groupId.add(groupId4);
		
		
		
		containerId.add(containerId1,BorderLayout.NORTH);
		containerId.add(groupId,BorderLayout.CENTER);
		containerId.add(containerId2,BorderLayout.SOUTH);
		
		
		
		//비밀번호 컨데이너
		JPanel  containerpwd1 = new JPanel();
		containerpwd1.add(searchpwd);
		
		JPanel containerpwd2 = new JPanel();
		containerpwd2.add(jb2);
		
		JPanel containerpwd = new JPanel(new BorderLayout());
		
		JPanel groupMail = new JPanel(new BorderLayout());
		groupMail.add(jtf4,BorderLayout.WEST);
		groupMail.add(at,BorderLayout.CENTER);groupMail.add(domain1,BorderLayout.EAST);
		
		
		JPanel grouppwd1 = new JPanel(new FlowLayout(FlowLayout.CENTER,20,10));
		JPanel grouppwd2 = new JPanel(new FlowLayout(FlowLayout.LEFT,20,10));
		JPanel grouppwd3 = new JPanel(new FlowLayout(FlowLayout.CENTER,20,10));
		JPanel grouppwd4 = new JPanel(new FlowLayout(FlowLayout.LEFT,20,10));
		
		grouppwd1.add(jl3);
		grouppwd3.add(jl4);
		grouppwd2.add(jtf3);
		grouppwd4.add(groupMail);
		
		JPanel grouppwd = new JPanel(new GridLayout(2,2,0,0));
		grouppwd.add(grouppwd1);
		grouppwd.add(grouppwd2);
		grouppwd.add(grouppwd3);
		grouppwd.add(grouppwd4);
		
		
		
		containerpwd.add(containerpwd1,BorderLayout.NORTH);
		containerpwd.add(grouppwd,BorderLayout.CENTER);
		containerpwd.add(containerpwd2,BorderLayout.SOUTH);
		
		JPanel containerLogin = new JPanel();
		containerLogin.add(jb3);
		
		//아이디 패스워드 그룹
		JPanel gridgroup = new JPanel(new GridLayout(2,1,50,20));
		gridgroup.add(containerId);
		gridgroup.add(containerpwd);
		
		gridgroup.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		
		
		JPanel grouping = new JPanel(new BorderLayout());
		grouping.add(container2,BorderLayout.NORTH);
		grouping.add(gridgroup,BorderLayout.CENTER);
		
		//프레임에 올리기
		add(container1,BorderLayout.NORTH);
		add(grouping,BorderLayout.CENTER);
		add(containerLogin,BorderLayout.SOUTH);
		
		
		setBounds(200,200,600,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		pack();
		
		
		//색상
		containerId.setBorder(new LineBorder(Color.gray));
		containerpwd.setBorder(new LineBorder(Color.gray));
		
		//배경색
		container1.setBackground(Color.white);
		container2.setBackground(Color.white);
		containerLogin.setBackground(Color.white);
		
		gridgroup.setBackground(Color.white);
		groupMail.setBackground(Color.white);
		
		containerpwd1.setBackground(Color.white);
		containerpwd2.setBackground(Color.white);		
		grouppwd1.setBackground(Color.white);
		grouppwd2.setBackground(Color.white);
		grouppwd3.setBackground(Color.white);
		grouppwd4.setBackground(Color.white);
		
		containerId1.setBackground(Color.white);
		containerId2.setBackground(Color.white);		
		groupId1.setBackground(Color.white);
		groupId2.setBackground(Color.white);
		groupId3.setBackground(Color.white);
		groupId4.setBackground(Color.white);
		
		
		
		//이벤트
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(jtf1.getText().equals("")||jtf2.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "모든 정보를 입력해주세요.");
				}else {
					connect();
					String getId = searchID(jtf1.getText(),jtf2.getText());
					if(getId.equals("A")) {
						JOptionPane.showMessageDialog(null, "휴대번호가 맞지 않습니다.");
					}else if(getId.equals("B")) {
						JOptionPane.showMessageDialog(null, "회원정보가 존재하지 않습니다.");
					}else {
						JOptionPane.showMessageDialog(null, "아이디는 " + getId + "입니다.");
						
					}
				
				}
				jtf1.setText("");
				jtf2.setText("");
				jtf1.requestFocus();
				
			}
		});
		
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(jtf3.getText().equals("")||jtf3.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "모든 정보를 입력해주세요.");
				}else {
					connect();
					String getPwd = searchPWD(jtf3.getText(), jtf4.getText(), domain1.getSelectedItem());
					if(getPwd.equals("A")) {
						JOptionPane.showMessageDialog(null, "이메일이 불일치 합니다.");
					}else if(getPwd.equals("B")){
						JOptionPane.showMessageDialog(null, "회원정보가 존재하지 않습니다.");
					}else {
						JOptionPane.showMessageDialog(null, "회원의 비밀번호는 " + getPwd + "입니다.");
					}
					
				}
				
			}
		});
		jb3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Login();
				dispose();
			}
		});
			
	}
	
	//연동 메소드
	 void connect() {		//연동 메서드
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "web";
		String password = "1234";
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	 //아이디 찾기 메소드
	public String searchID (String name, String phone) {
		try {						
			String sql = "select user_phone, user_id from kkakkao_member where user_name =? ";						
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(phone)) {
						//이름, 핸드폰 동일
					X = rs.getString(2).toString();
					
				}else {
					X = "A";	//핸드폰 번호 다름
				}
			}else {
				X = "B";		//이름이 없음.
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return X;
	
	}
	//비밀번호 찾기 메소드
	String searchPWD(String id, String email, Object object) {
		try {
			
			String sql = "select user_email1, email_domain , user_pwd from kkakkao_member where user_id = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(email) && rs.getString(2).equals(object)) {
					X = rs.getString(3).toString();		//일치
				}else {
					X = "A";		//이메일 불일치
				}
			}else {
				X = "B";			//아이디 없음
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return X;	
		
		
	}

	public static void main(String[] args) {
		new Search();
		
		
		

	}

}
