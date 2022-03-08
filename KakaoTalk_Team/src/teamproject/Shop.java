package teamproject;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Shop extends JFrame{
	
	Connection con = null; // DB와 연결하는 객체
	PreparedStatement pstmt = null; // SQL문을 DB에 전송하는객체
	ResultSet rs = null;   // SQL문 실행결과를 가지고 있는 객체
	String sql = null;
	DefaultTableModel model;
	JTable table;
	
	
	String[] header =
		{"이모티콘 목록"};
	Object[][] contante = {
			{" 1번       따봉하는 라이언"},
			{" 2번       박수치는 라이언"},
			{" 3번       애교부리는 라이언"},
			{" 4번       하트뿅뿅 라이언"},
	};
	
	
	public Shop() {
		
		setTitle("이모티콘샵");
		
		// 컨테이너 구성
		JPanel container1 = new JPanel();
		JPanel container2 = new JPanel();
		JPanel container3 = new JPanel();
		JPanel container4 = new JPanel();
		JPanel container5 = new JPanel();
		
		// 상단 컨테이너에 올릴 컴포넌트 만들기
		JButton back = new JButton("뒤로가기");
		back.setPreferredSize(new Dimension(85,35));
		
		JLabel jltext = new JLabel("라이언 시리즈");
		
		// 중단 컨테이너에 올릴 컴포넌트 만들기
		
		JLabel image1 = new JLabel(ImageChage2.changeIcon1);
		JLabel priceName1 = new JLabel("따봉하는 라이언");
		JLabel price1 = new JLabel("가격 : 2500원");
		
		JLabel image2 = new JLabel(ImageChage2.changeIcon2);
		JLabel priceName2 = new JLabel("박수치는 라이언");
		JLabel price2 = new JLabel("가격 : 2000원");
		
		JLabel image3 = new JLabel(ImageChage2.changeIcon3);
		JLabel priceName3 = new JLabel("애교부리는 라이언");
		JLabel price3 = new JLabel("가격 : 3500원");
		
		JLabel image4 = new JLabel(ImageChage2.changeIcon4);
		JLabel priceName4 = new JLabel("하트뿅뿅 라이언");
		JLabel price4 = new JLabel("가격 : 3000원");
		
		
		model = new DefaultTableModel(contante, header);
		table = new JTable(model);
		JScrollPane jsp = new JScrollPane(
				table,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
				);
		jsp.setPreferredSize(new Dimension(400,110));
		
	
		
		
		// 하단 컨테이너에 올릴 컴포넌트 만들기
		JButton buy = new JButton("구매");
		JButton buket = new JButton("구매목록");
		JButton cancle = new JButton("취소");
		
		
		// 상단 컨테이너에 올리기
		container1.setLayout(new BorderLayout(10,0));
		container1.add(back, BorderLayout.EAST);
		container1.add(jltext,BorderLayout.CENTER);
		jltext.setHorizontalAlignment(JLabel.CENTER);
		
		
		// 중단 컨테이너 올리기
		// 중단 첫번째 그리드
		container2.setLayout(new GridLayout(2,2,20,20));
		container2.add(image1);
		container2.add(priceName1);
		container2.add(price1);
		
		container2.add(image2);
		container2.add(priceName2);
		container2.add(price2);
		
		// 중단 두번째 그리드
		container3.setLayout(new GridLayout(2,2,20,20));
		container3.add(image3);
		container3.add(priceName3);
		container3.add(price3);
		
		container3.add(image4);
		container3.add(priceName4);
		container3.add(price4);
		
		// 하단 컨테이너에 올리기
		container4.setLayout(new BorderLayout(10,10));
		container4.add(buy,BorderLayout.NORTH);
		container4.add(cancle,BorderLayout.SOUTH);
		container4.add(buket, BorderLayout.CENTER);
		container5.add(jsp);
		
		// 그룹화1
		JPanel group1 = new JPanel();
		group1.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 60));
		group1.add(container2, BorderLayout.NORTH);
		group1.add(container3, BorderLayout.CENTER);
		
		// 그룹화2
		JPanel group2 = new JPanel();
		group2.setLayout(new BorderLayout(0,0));
		group2.add(container4, BorderLayout.SOUTH);
		
		// 그룹화3
		JPanel group3 = new JPanel();
		group3.add(container5, BorderLayout.NORTH);
		group3.add(container4, BorderLayout.AFTER_LINE_ENDS);
		
		// 프레임에 올리기
		add(container1, BorderLayout.NORTH);
		add(group1, BorderLayout.CENTER);
		add(group3, BorderLayout.SOUTH);
		
		setBounds(100,120,950,650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		
		
		
		// 글자 폰트 및 색상 조정하기
		Font f1 = new Font("Gothic", Font.BOLD, 35);
		Font f2 = new Font("Gothic", Font.BOLD, 15);
		Font font = new Font("Gothic", Font.BOLD, 13);

		jltext.setFont(f1);
		priceName1.setFont(f2);
		price1.setFont(f2);
		
		priceName2.setFont(f2);
		price2.setFont(f2);
		
		priceName3.setFont(f2);
		price3.setFont(f2);
		
		priceName4.setFont(f2);
		price4.setFont(f2);
		
		buy.setFont(font);
		cancle.setFont(font);
		buket.setFont(font);
		
		// 패널 색 설정하기
		Color color1 = new Color(255,212,0); // 연한 노란색
		Color color2 = new Color(204,204,204); // 연한 그레이
		Color color3 = new Color(255,250,250); // 하얀색
		Color color4 = new Color(204,102,0); // 갈색
		Color color5 = new Color(239,250,46); // 포옐로우1
		
		
		// 상단 색
		container1.setBackground(Color.white);
		group1.setBackground(Color.white);
		back.setBackground(color2);
		back.setFocusPainted(false);
		
		// 중단 색
		container2.setBackground(Color.white);
		container3.setBackground(Color.white);
		
		// 하단 색
		group3.setBackground(color1);
		container4.setBackground(color1);
		container5.setBackground(color1);
		buy.setBackground(color3);
		cancle.setBackground(color3);
		buket.setBackground(color3);
		
		
		
		// 이벤트 처리하기
		// 뒤로가기 버튼을 눌럿을때 채팅창으로 넘어가기
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Main();
				dispose();
			}
		}); // back() 메서드의 end
		
		
		// 취소를 누르는 경우 테이블이 행이 사라지는 이벤트
		cancle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int row[] = table.getSelectedRows();
				for(int i=0; i<row.length; i++) {
					model.removeRow(row[i]);
				}
			}
			
		}); // cancle의 end부분
	
	
		// 구매버튼을 누르면 구매한 행을 구매목록에 보내기
		buy.addActionListener(new ActionListener() {
			int result;
			@Override
			public void actionPerformed(ActionEvent e) {
				int[] row = table.getSelectedRows();
				for(int i=0; i<row.length; i++) {
					result = JOptionPane.showConfirmDialog(null, (row[i] + 1) + "번 이모티콘을 구입하시겠습니까?","구매",JOptionPane.YES_NO_OPTION);
					
					if(result == JOptionPane.NO_OPTION){
						JOptionPane.showMessageDialog(null, "구매를 취소하셨습니다."); 
					} else if(result == JOptionPane.YES_OPTION) {
//						JOptionPane.showMessageDialog(null, (row[i] + 1) + "번 이모티콘을 구매하였습니다.");
						connect(); // 데이터베이스 연동
						insert(); // 데이터 추가
					}
				} // for반복문의 end부분
			}
		});// buy end부분
		
		
		// 구매목록 버튼을 눌럿을 때 구매목록 GUI로 이동하는 기능 만들기
		buket.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Buket();
				setVisible(false);
			}
		});
	} // shop의 end
	
	
	
	// DB베이스를 연동하는 메서드
	void connect() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "web";
		String password = "1234";
		try {
			// 1. 접속할 오라클 데이터베이스 드라이버를 메모리에 올리자. - 동적 작업
			Class.forName(driver);
			// 2. 접속할 오라클 데이터베이스를 연결해보자.
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // connect() 메서드의 end
	
	
	// 구매버튼을 클릭했을때 DB에서 해당행의 정보를 인설트해주는 메서드
	void insert() {
		try {
			// 1. 오라클 데이터베이스에 전송할 SQL문 작성.
			sql = "insert into shop values(?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			int[] row = table.getSelectedRows();
			for(int i=0; i<row.length; i++) {
				if(row[i] == 0) {
					pstmt.setInt(1, 1);
					pstmt.setString(2, "따봉하는 라이언");
					pstmt.setInt(3, 2500);
				} else if(row[i] == 1) {
					pstmt.setInt(1, 2);
					pstmt.setString(2, "박수치는 라이언");
					pstmt.setInt(3, 2000);
				} else if(row[i] == 2) {
					pstmt.setInt(1, 3);
					pstmt.setString(2, "애교부리는 라이언");
					pstmt.setInt(3, 3500);
				} else if(row[i] == 3) {
					pstmt.setInt(1, 4);
					pstmt.setString(2, "하트뿅뿅 라이언");
					pstmt.setInt(3, 3000);
				}
			}
			
			// 2. 오라클 데이터베이스에 SQL문 전송 및 SQl문 실행.
			int res = pstmt.executeUpdate();
			
			if(res > 0) {
				JOptionPane.showMessageDialog(null, "구매 완료");
			} else {
				JOptionPane.showMessageDialog(null, "구매 실패");
			}
			
			// 3. 오라클 데이터베이스 연결되어 있던 자원 종료.
			pstmt.close(); con.close();
		
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "이미 구매하신 상품입니다.");
			e.printStackTrace();
		}
	}
	



	public static void main(String[] args) {
		new Shop();
	}
}
