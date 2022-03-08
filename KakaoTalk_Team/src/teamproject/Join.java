package teamproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import java.awt.Font;

//import javax.swing.JButton;
//import javax.swing.JComboBox;
import javax.swing.*;
//import javax.swing.JLabel;
//import javax.swing.JTextField;

public class Join extends JFrame {
	
	Color color;
	static Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql;
	
	JTextField name, id, pwd, nick, mail, phone;
	JComboBox<String> domain1;
	
	
	
	public Join() {
		
		JPanel co = new JPanel();

		
		// 컴포넌트 만들기
		JLabel main = new JLabel("회원가입");
		
		
		
		JLabel jl1 = new JLabel("이       름 : ");
		 name = new JTextField(10);	
		
		JLabel jl2 = new JLabel("아  이  디 : ");
		 id = new JTextField(10);
		JButton jb1 = new JButton("중복확인");
		
		JLabel jl3 = new JLabel("비밀번호  : ");
		 pwd = new JTextField(10);
		
		JLabel jl4 = new JLabel("닉  네  임  : ");
		 nick = new JTextField(10);
		
		JLabel jl5 = new JLabel("이  메  일 : ");
		 mail = new JTextField(7);
		JLabel at = new JLabel("@");
		
		String[] domain = {"-선택-","naver.com","gmail.com","hanmail.net","hotmail.com","korea.com","nate.com","yahoo.com"};
		 domain1 = new JComboBox<String>(domain);
		
		JLabel jl6 = new JLabel("전화번호 : ");
		 phone = new JTextField(15);
			
		
		JButton join = new JButton("가입");
		JButton cancel = new JButton("취소");
		
		
		
		add(main);
		
		add(jl1);
		add(jl2);
		add(jl3);
		add(jl4);
		add(jl5);
		add(jl6);
		
		add(name);
		add(id);		add(jb1);
		add(pwd);
		add(nick);
		add(at);		add(mail);
		add(domain1);
		add(phone);
		add(cancel);
		add(join);
		
		int a,b,c;
		a = 70;
		b = 70;
		c = 30;
						
		jl1.setBounds(a, 90, b, c);
		jl2.setBounds(a, 130, b, c);
		jl3.setBounds(a, 170, b, c);
		jl4.setBounds(a, 210, b, c);
		jl5.setBounds(a, 250, b, c);
		jl6.setBounds(a, 290, b, c);
		
		int x,y;
		x = 180;
		y = 150;
		
		name.setBounds(x, 90, y, c);
		id.setBounds(x, 130, y, c);			
		pwd.setBounds(x, 170, y, c);
		nick.setBounds(x, 210, y, c);
		mail.setBounds(x, 250, 100, c);
		phone.setBounds(x, 290, y, c);
		
		
		jb1.setBounds(350, 130, 90 , c);
		at.setBounds(290, 250, 12, c);
		domain1.setBounds(310, 250, 120, c);
		
		main.setBounds(180, 25, 300, 30);
		join.setBounds(130, 370, 100, c);
		cancel.setBounds(270,370,100,c);
		
		//배경색
		color = new Color(255, 255, 255);
		co.setBackground(color);
		
		//버튼색
		color = new Color(153, 102, 0);
		//jb1.setBackground(color);		
		join.setBackground(color);
		cancel.setBackground(color);
		
		//회원가입 글자 색
		main.setForeground(color);
		main.setFont(new Font("SanaSerif", Font.BOLD, 30));
		
		
		
		add(co);
		
		setBounds(200, 200, 500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		//이벤트 처리
		//취소 버튼
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "회원가입을 취소하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);
				
				if(result == JOptionPane.YES_OPTION) {
					new Login();
					dispose();
					
					
				}				
			}
		});
		//가입완료 버튼
		join.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(name.getText().equals("") || id.getText().equals("")
						|| pwd.getText().equals("") || nick.getText().equals("")
						|| phone.getText().equals("") ) {
					
					JOptionPane.showMessageDialog(null, "정보를 모두 입력해 주세요.");										
					
				}else {
					connect();
					insert();
					
					id.setText("");
					name.setText("");
					pwd.setText("");
					nick.setText("");
					mail.setText("");
					domain1.setSelectedIndex(0);
					phone.setText("");
					name.requestFocus();
					
					new Login();
					dispose();
					
				}
				
				
			}
		});
		//중복확인 버튼
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				connect();
				int num = check();
				if(num == 2) {
					JOptionPane.showMessageDialog(null, "사용 가능한 아이디입니다.");				
				}else if(num == 1) {
					JOptionPane.showMessageDialog(null, "이미 사용중인 아이디입니다.");
					id.setText("");
				}
				
				
			}
		});
		
	}
		 static void connect() {		//연동 메서드
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
		
		void insert() {
			
			
			try {
				
				sql = "insert into kkakkao_member values(?,?,?,?,?,?,?)";
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1,name.getText());
				pstmt.setString(2,id.getText());
				pstmt.setString(3,pwd.getText());
				pstmt.setString(4,nick.getText());
				pstmt.setString(5,mail.getText());
				pstmt.setString(6,domain1.getSelectedItem().toString());
				pstmt.setString(7,phone.getText());
				
				int res = pstmt.executeUpdate();
				
				if(res>0) {
					JOptionPane.showMessageDialog(null,	"회원가입 완료되었습니다.");
				}else {
					JOptionPane.showMessageDialog(null,	"다시 입력해주시기 바랍니다.");
				}
				
				pstmt.close();	
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
			
		}	//insert()메소드 end.
		
		//중복확인 메소드
		public int check() {
			int x = 0;
			
			try {
				sql = "select * from kkakkao_member where user_id =?";
				
				pstmt =  con.prepareStatement(sql);
				pstmt.setString(1, id.getText());
				rs = pstmt.executeQuery();
				
				if(rs.next()){
					x = 1;	//중복된 아이디 존재
				}else {
					x = 2;	//사용가능
				}
		
				rs.close(); pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				
			}
			
			return x;
	
		}
		
		

	public static void main(String[] args) {
		new Join();

	}
	
}


