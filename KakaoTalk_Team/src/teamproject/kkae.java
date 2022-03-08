package teamproject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

public class kkae extends JFrame{
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;
	DefaultTableModel model;
	
	JTextField nickn,phone,email,id;
	JPasswordField pwd;
	JComboBox<String>email2;
	
	public kkae() {
		
		setTitle("회원정보수정");
		JLabel title = new JLabel("회원정보수정");
		title.setForeground(new Color(153,102,000));
		title.setFont(new Font("나눔고딕OTF", Font.ITALIC, 25));
		title.setBorder(BorderFactory.createMatteBorder(0,0,5,0,Color.GRAY));		


		id = new JTextField(10);
		pwd = new JPasswordField(10);
		nickn = new JTextField(10);
		phone = new JTextField(10);
		email = new JTextField(10);
	    email2 = new JComboBox<String>();
	    
	    JPanel jp1 = new JPanel(new FlowLayout(FlowLayout.LEFT,20,5));
	    JPanel jp2 = new JPanel(new FlowLayout(FlowLayout.LEFT,20,5));
	    JPanel jp3 = new JPanel(new FlowLayout(FlowLayout.LEFT,20,5));
	    JPanel jp4 = new JPanel(new FlowLayout(FlowLayout.LEFT,20,5));
	    JPanel jp5 = new JPanel(new FlowLayout(FlowLayout.LEFT,20,5));
	    
		
	    RoundedButton join = new RoundedButton("정보수정");
		join.setFont(new Font("나눔고딕OTF", Font.BOLD, 13));
		RoundedButton cancel = new RoundedButton("취소");
		cancel.setFont(new Font("나눔고딕OTF", Font.BOLD, 13));
		RoundedButton login = new RoundedButton("로그인");
		login.setFont(new Font("나눔고딕OTF", Font.BOLD, 13));
		RoundedButton rollback = new RoundedButton("뒤로가기");
        rollback.setFont(new Font("나눔고딕OTF", Font.BOLD, 13));
		
		JPanel jp = new JPanel();
		jp.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		jp.setBackground(Color.WHITE);
		jp.add(title);

		JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,20,20));
        idPanel.add(new JLabel("아 이 디"));
        idPanel.setBackground(Color.WHITE);
        jp1.add(id);
        jp1.setBackground(Color.WHITE);
       
		
		JPanel nicknPanel = new JPanel();
		nicknPanel.setLayout(new FlowLayout(FlowLayout.LEFT,20,15));
		nicknPanel.add(new JLabel("닉 네 임"));
		nicknPanel.setBackground(Color.WHITE);
		jp2.add(nickn);
		jp2.setBackground(Color.WHITE);
				
		JPanel emailPanel = new JPanel();
		emailPanel.setLayout(new FlowLayout(FlowLayout.LEFT,20,15));
		emailPanel.add(new JLabel("이 메 일"));
		emailPanel.setBackground(Color.WHITE);
		jp3.add(email);
		jp3.add(new JLabel("@"));
		jp3.add(email2);
		jp3.setBackground(Color.WHITE);
		email2.addItem(" - 선 택 - ");
		
		JPanel phonePanel = new JPanel();
		phonePanel.setLayout(new FlowLayout(FlowLayout.LEFT,20,15));
		phonePanel.add(new JLabel("연 락 처"));
		phonePanel.setBackground(Color.WHITE);
		jp4.add(phone);
		jp4.setBackground(Color.WHITE);
		
		JPanel pwdPanel = new JPanel();
		pwdPanel.setLayout(new FlowLayout(FlowLayout.LEFT,20,15));
		pwdPanel.add(new JLabel("비밀번호"));
		pwdPanel.setBackground(Color.WHITE);
		jp5.add(pwd);
	    jp5.setBackground(Color.WHITE);
		
		JPanel con1 = new JPanel();
		con1.setLayout(new GridLayout(10,0));		
		con1.add(idPanel);  				con1.add(jp1);
		con1.add(nicknPanel);   		con1.add(jp2);
		con1.add(pwdPanel);   		con1.add(jp5);  
		con1.add(emailPanel);  		con1.add(jp3);
		con1.add(phonePanel);  		con1.add(jp4);
		     
		
		JPanel con2 = new JPanel();
		con2.setLayout(new FlowLayout(FlowLayout.CENTER,10,15));
		con2.add(login); con2.add(join); con2.add(cancel); con2.add(rollback);
		con2.setBackground(Color.WHITE);
		con2.setBorder(BorderFactory.createMatteBorder(2,0,0,0,Color.GRAY));


		add(jp,BorderLayout.NORTH);
		add(con1, BorderLayout.CENTER);
		add(con2, BorderLayout.SOUTH);
	
		
		setBounds(100, 100, 400, 550);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		
		connect();		
		comboEmail();
		
		
		join.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// join 누르면 정보수정 
				connect();
				update();
								
				id.setText(""); nickn.setText("");
				pwd.setText(""); email.setText("");
				phone.setText("");
				email2.setSelectedItem(" - 선 택 - ");
				id.requestFocus();			

				
				
			}
		});
		
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 로그인 누르면 로그인 화면으로 가기
				new Login();
				dispose();
			}
		});
		
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// 입력 받은 컴포넌트들은 모두 초기화 해 주자.
				id.setText(""); nickn.setText("");
				pwd.setText(""); email.setText("");
				phone.setText("");
				email2.setSelectedItem(" - 선 택 - ");
				id.requestFocus();	
				
			}
		});
		
		rollback.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 뒤로가기 누르면 가는 화면 
				new Main();
				dispose();
			}
		});	
	}	

	void connect() {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "web";
		String password = "1234";

		try {
			// 1. 접속할 오라클 데이터베이스 드라이버를 메모리에 올리자. - 동적 작업
			Class.forName(driver);			
			// 2. 오라클 데이터베이스와 연결을 시도.
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}  // connect() 메서드 end
			
	void comboEmail() {

		try {
			sql = "select distinct (EMAIL_DOMAIN) from  kkakkao_member order by EMAIL_DOMAIN";
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				String EMAIL_DOMAIN=rs.getString("EMAIL_DOMAIN");
				email2.addItem(EMAIL_DOMAIN);
	}
			rs.close(); pstmt.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	
	
	void update() {

		try {
			sql = "update kkakkao_member set "
					+ "USER_NICKNAME=?, USER_PWD =?, USER_EMAIL1=?, "
					+ "EMAIL_DOMAIN =?,USER_PHONE=? where USER_ID=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,nickn.getText());
			pstmt.setString(2, pwd.getText());
			pstmt.setString(3,email.getText());
			pstmt.setString(4, email2.getSelectedItem().toString());
			pstmt.setString(5, phone.getText());
			pstmt.setString(6, id.getText());
			
			int res = pstmt.executeUpdate();
			
			if(res>0) {
				JOptionPane.showMessageDialog(null, "정보가 수정되었습니다.");
			}else {
				JOptionPane.showMessageDialog(null, "정보가 수정되지않았습니다.");
			}
		pstmt.close(); 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		
		new kkae();
		
	}

}
