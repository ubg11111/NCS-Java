package teamproject;

import java.awt.*;
//import java.awt.Color;
//import java.awt.FlowLayout;
//import java.awt.GridLayout;
import java.awt.event.*;
import java.sql.Connection;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;


public class Login extends JFrame {

	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Color color;
	String sql;
	
	JTextField id;
	JPasswordField pwd;
	 
	public Login() {
		// 기본생성자
		
		   setTitle("깨깨오톡 로그인");
	   
		   	//1-1. 상단에 들어갈 그림 또는 내용.   
	        JPanel container1 = new JPanel(new FlowLayout(FlowLayout.CENTER,50,90));
	        JLabel image = new JLabel(new ImageIcon("src/images/KakaoTalk2.jpg"));
	        container1.add(image);
		   
		   
		   
	        //1-2 중앙에 들어갈 컴포넌트 및 그룹핑
	        JPanel container2 = new JPanel(new FlowLayout(FlowLayout.CENTER,50,10));
	        JPanel gridGroup = new JPanel(new GridLayout(4,1,15,5));
	        
	        id = new JTextField(20);
	        pwd = new JPasswordField(20);
	        JButton login = new JButton("Login"); 
	        JLabel join = new JLabel("회원가입");
	        JLabel search = new JLabel("아이디 비밀번호 찾기");
	        
	        JPanel join1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
	        JPanel search1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	        join1.add(join);
	        search1.add(search);
	        
	        JPanel group = new JPanel();
	        group.add(join1);
	        group.add(search1);
	        
	        gridGroup.add(id);
	        gridGroup.add(pwd);
	        gridGroup.add(login);
	        gridGroup.add(group);
	        container2.add(gridGroup);
	         
	         
	         //3.프레임에 올리기
	         add(container1,BorderLayout.NORTH);
	         add(container2,BorderLayout.CENTER);

	   
	         setBounds(200, 200, 400, 550);
	         
	         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	         setVisible(true);
	         
	         //배경 색
	         color = new Color(255, 255, 255);
	         container1.setBackground(color);
	         container2.setBackground(color);
	         gridGroup.setBackground(color);
	         group.setBackground(color);
	         join1.setBackground(color);
	         search1.setBackground(color);
	        
	         //버튼색
	         color = new Color(153, 102, 0);
	         login.setBackground(color);
		
	         

	 		//이벤트 처리
	         
	        //로그인 마우스 버튼 클릭시
	 		login.addActionListener(new ActionListener() {
	 			
	 			@Override
	 			public void actionPerformed(ActionEvent e) {
	 				if(id.getText().equals("")) {
	 					JOptionPane.showMessageDialog(null, "아이디를 입력하세요");
	 				}else if(pwd.getText().trim().equals("")) {
	 					JOptionPane.showMessageDialog(null, "패스워드를 입력하세요");
	 				}else {
	 				
	 				connect();
	 				int result = confirm(id.getText(), pwd.getText().trim());
	 				if(result == 1 ) {
	 					//로그인 성공 -- 연동
	 	 				new Main();
		 				dispose();
	 				}else if(result == 2) {
	 					JOptionPane.showMessageDialog(null, "비밀번호가 틀립니다.");
	 				}else if(result == 3) {
	 					JOptionPane.showMessageDialog(null, "존재하지 않는 아이디입니다.");
	 				}
	 				
	 				id.setText("");
	 				pwd.setText("");
	 				id.requestFocus();
	 				}
	 				
	 			}
	 		});
	 		
			// 엔터를 쳣을 때 이벤트 처리
	 		pwd.addKeyListener(new KeyListener() {
				@Override
				public void keyTyped(KeyEvent e) {}
				@Override
				public void keyReleased(KeyEvent e) {}
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyCode() == KeyEvent.VK_ENTER) {
						
						if(id.getText().equals("")) {
		 					JOptionPane.showMessageDialog(null, "아이디를 입력하세요");
		 				}else if(pwd.getText().trim().equals("")) {
		 					JOptionPane.showMessageDialog(null, "패스워드를 입력하세요");
		 				}else {
						
		 				connect();
		 				int result = confirm(id.getText(), pwd.getText().trim());
		 				if(result == 1 ) {
		 					//로그인 성공 -- 연동
		 	 				new Main();
			 				dispose();
		 				}else if(result == 2) {
		 					JOptionPane.showMessageDialog(null, "비밀번호가 틀립니다.");
		 				}else if(result == 3) {
		 					JOptionPane.showMessageDialog(null, "존재하지 않는 아이디입니다.");
		 				}
		 				id.setText("");
		 				pwd.setText("");
		 				id.requestFocus();
		 				}
					}
				}
			});
	 		
	 		
	 		// 회원가입버튼을 누르는경우 이벤트처리
	 		
	 		join.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {}
				
				@Override
				public void mousePressed(MouseEvent e) {}
				
				@Override
				public void mouseExited(MouseEvent e) {}
				
				@Override
				public void mouseEntered(MouseEvent e) {}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					new Join();
					dispose();
					
				}
			});
	 		search.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {}
				
				@Override
				public void mousePressed(MouseEvent e) {}
				
				@Override
				public void mouseExited(MouseEvent e) {}
				
				@Override
				public void mouseEntered(MouseEvent e) {}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					new Search();
					dispose();
				}
			});

	}
	
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
		}	//conect()메서드 end.
		
		public int confirm(String id, String string) {
			int x = 0;
			
			
			try {
				sql = "select user_pwd from kkakkao_member where user_id =?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				
				rs = pstmt.executeQuery();
				if(rs.next()) {
					if(rs.getString(1).equals(string)) {
						x = 1;	//로그인 성공
					}else {
						x = 2; 	//비밀번호 불일치
					}
				}else {
					x = 3;		//아이디 없음
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return x;
		}	//confirm()메소드 end
		
	

	public static void main(String[] args) {
		new Login();
		
		System.out.println();
	}
}
