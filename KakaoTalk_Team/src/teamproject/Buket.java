package teamproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class Buket extends JFrame{
	
	
	Connection con = null; // DB와 연결하는 객체
	PreparedStatement pstmt = null; // SQL문을 DB에 전송하는객체
	ResultSet rs = null;   // SQL문 실행결과를 가지고 있는 객체
	String sql = null;
	DefaultTableModel model;
	JTable table;
	
	
	
	Buket(){
		setTitle("구매목록");
		
		JPanel container1 = new JPanel();
		JPanel container2 = new JPanel();
		JPanel container3 = new JPanel();
		
		// 상단 컨테이너에 컴포넌트 올리기
		JLabel jl1 = new JLabel("구매 목록");
		jl1.setHorizontalAlignment(JLabel.CENTER);
		
		// 중단 컨테이너에 컴포넌트 올리기
		String[] header =
			{"이모티콘번호", "이모티콘명", "이모티콘가격"};
		model = new DefaultTableModel(header, 0);
		table = new JTable(model);
		JScrollPane jsp = new JScrollPane(
				table,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
				);
		jsp.setPreferredSize(new Dimension(300,400));
		
		
		
		// 하단 컨테이너에 컴포넌트 올리기
		JButton select1 = new JButton("조회");
		JButton delete = new JButton("삭제");
		JButton back = new JButton("뒤로");
		back.setPreferredSize(new Dimension(70,30));
		select1.setPreferredSize(new Dimension(70,30));
		delete.setPreferredSize(new Dimension(70,30));
		
		// 상단 컨테이너에 컴포넌트 올리기
		container1.setLayout(new BorderLayout(0,100));
		container1.add(jl1);
		container1.setBounds(100,100,400,300);
		
		
		
		// 중단 컨테이너에 컴포넌트 올리기
		container2.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		container2.add(jsp);
		
		
		// 하단 컨테이너에 컴포넌트 올리기
		container3.setLayout(new FlowLayout(FlowLayout.CENTER, 35, 10));
		container3.add(select1);
		container3.add(delete);
		container3.add(back);
		
		
		// 프레임에 컨테이너 올리기
		add(container1,BorderLayout.NORTH);
		add(container2,BorderLayout.CENTER);
		add(container3,BorderLayout.SOUTH);
		
		setBounds(30,120,400,550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		
		
		// 폰트 및 글자 크기 조정하기
		Font f1 = new Font("Gothic", Font.BOLD, 35);
		Font f2 = new Font("Gothic", Font.BOLD, 20);
		Font f3 = new Font("Gothic", Font.BOLD, 12);
		jl1.setFont(f2);
		select1.setFont(f3);
		delete.setFont(f3);
		back.setFont(f3);
		
		
		// 색 설정하기
		Color color1 = new Color(192,192,192); // 연한 노란색
		Color color2 = new Color(204,204,204); // 연한 그레이
		Color color3 = new Color(255,250,250); // 하얀색
		
		container1.setBackground(color3);
		container2.setBackground(color3);
		container3.setBackground(color3);
		select1.setBackground(color1);
		delete.setBackground(color1);
		back.setBackground(color1);
		
		
		// 이벤트 처리하기
		// 돌아가기 버튼을 누르면 shop으로 돌아가는 기능 만들기
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Shop();
				dispose();
			}
		}); 
		
		// 조회하기 버튼을 누르면 구매목록 조회
		select1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(table != null) {
					connect();
					model.setRowCount(0); // 전체 테이블 화면을 지워주는 메서드.
					select();
				} else if(table == null){
					JOptionPane.showMessageDialog(null, "조회할 상품이 없습니다.");
				}
	
			}
		});
		
		// 삭제버튼을 누르면 구매목록 삭제
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				connect();
				delete();
			}
		});
	}
	
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
	
	// 상품조회 버튼을 클릭시 DB에서 상품정보를 가져오는 메서드
	void select() {
		
		try {
			sql = "select * from shop order by productid";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int productid = rs.getInt("productid");
				String productname = rs.getString("productname");
				int productprice = rs.getInt("productprice");
				Object[] data = {productid,productname,productprice};
				model.addRow(data);
			}
			// 4. 데이터베이스 연결되어 있던 자원 종료
			rs.close(); pstmt.close(); con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 삭제하기 버튼을 클릭시 DB에서 해당 상품목록을 삭제하는 메서드
	void delete() {
		
		try {
			sql = "delete from shop where productid = ?";
			pstmt = con.prepareStatement(sql);
			
			// 테이블의 특정 행을 클릭했을 때 해당 테이블의 값을 가져오는 메서드
			int row = table.getSelectedRow();
			
			// 해당 행의 값을 가져올 때 해당 행의 0번째 열의 값을 가져온다.
			pstmt.setInt(1, (int)model.getValueAt(row, 0));
			
			//2. 오라클 데이터베이스의 SQL문 전송 및 SQL문 실행.
			int res = pstmt.executeUpdate();
			
			if(res > 0) {
				JOptionPane.showMessageDialog(null, "선택한 구매목록을 삭제하였습니다.");
			}else {
				JOptionPane.showMessageDialog(null, "선택한 구매목록을 삭제실패하였습니다.");
			}
			
			// 실제로 테이블 상의 클릭한 한 레코드를 삭제.
			model.removeRow(row);
			
			//3. 데이터베이스 연결 종료
			pstmt.close();
			con.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		new Buket();
	}
}
