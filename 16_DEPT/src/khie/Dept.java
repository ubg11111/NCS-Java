package khie;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Dept extends JFrame{
	
	Connection con = null; // DB와 연결하는 객체
	PreparedStatement pstmt = null; // DB에 SQL문을 전송하는 객체
	ResultSet rs = null; // SQL문의 실행 결과를 저장하고 있는 객체
	String sql = null; // SQL문 저장 문자열 변수
	DefaultTableModel model;
	JTextField jtf1,jtf2,jtf3;
	JTable table;
	
	public Dept() {
		setTitle("부서 테이블");
		
		JPanel container1 = new JPanel(); // 상단 컨테이너
		JPanel container2 = new JPanel(); // 하단 컨테이너
		
		// 1. 컴포넌트를 만들어 보자.
		// 1-1. 상단 컨테이너에 올려질 컴포넌트를 만들자.
		JLabel jl1 = new JLabel("부서번호 :  ");
		jtf1 = new JTextField(2);
		
		JLabel jl2 = new JLabel("부서명 :  ");
		jtf2 = new JTextField(10);
		
		JLabel jl3 = new JLabel("근무지 :  ");
		jtf3 = new JTextField(10);
		
		
		// 1-2 중앙에 들어갈 컴포넌트를 만들자.
		String[] header = {"부서번호", "부서명", "근무지"};
		
		/*
		 * - DefaultTableModel : 테이블을 만들고 난 후 데이터를 넣고
		 * 					     추가, 수정, 삭제 시에도 변경이 가능함.
		 * 
		 * - JTable : 일단은 테이블을 만들고 난 후 데이터를 넣으면 한 번만든
		 * 			  테이블의 데이터는 변경이 불가능.
		 * 			  추가, 수정, 삭제 불가능.
		 * 			  추가, 수정, 삭제 시에는 다시 새로운 객체를 만들어야 함.
		 */
		
		model = new DefaultTableModel(header, 0);
		
		table = new JTable(model);
		JScrollPane jsp = new JScrollPane(
				table,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
				);
		
		
		// 1-3 하단 컨테이너에 들어갈 컴포넌트를 만들자
		JButton jb1 = new JButton("전체 목록");
		JButton jb2 = new JButton("부서 추가");
		JButton jb3 = new JButton("부서 수정");
		JButton jb4 = new JButton("부서 삭제");
		
		
		// 2. 컴포넌트를 컨테이너에 올려주어야 한다.
		// 2-1. 상단 컨테이너에 1-1에 들어갈 컴포넌트들을 올려주자.
		container1.add(jl1);
		container1.add(jtf1);
		container1.add(jl2);
		container1.add(jtf2);
		container1.add(jl3);
		container1.add(jtf3);
		
		// 2-2. 하단 컨테이너에 1-3에 들어갈 컴포넌트들을 올려주자
		container2.add(jb1);
		container2.add(jb2);
		container2.add(jb3);
		container2.add(jb4);
		
		
		// 3. 컨테이너를 프레임에 올려주자
		add(container1, BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);
		add(container2, BorderLayout.SOUTH);
	
	
		setBounds(200, 200, 500, 250);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		
		
		// 4. 이벤트를 처리해보자.
		// 전체목록(jb1) 버튼을 클릭했을 때 DEPT 테이블의 
		// 전체 리스트를 JTable에 출력을 해주면 됨.
	
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				connect(); // 데이터베이스 로딩 및 데이터베이스 연결 시도
				model.setRowCount(0); // 전체 테이블의 화면을 지워주는 메서드
				select(); // DB에서 전체 내역을 조회하는 메서드 호출
				
			}
		});
		
		// 부서추가(jb2) 버튼을 클릭했을 때 각각의 텍스트필드에 입력된 정보를
		// DB에 추가한 후 추가된 전체리스트를 JTable에 다시 보여주면 됨.
		
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				connect(); // 데이터베이스 연결 메서드 호출
				insert();  // 데이터베이스에서 추가 호출
				
				// 입력 텍스트필드 영역 초기화
				jtf1.setText(" ");
				jtf2.setText(" ");
				jtf3.setText(" ");
				jtf1.requestFocus();
				
				model.setRowCount(0); // 전체 테이블의 화면을 지워주는 메서드
				select(); // DB에서 전체 내역을 조회하는 메서드 호출
				
			}
		});
		
		// 부서수정(jb3) 버튼을 클릭했을 때 각각의 텍스트필드에 입력된 정보를
		// 바탕으로 DB에서 수정한 후에 전체리스트를 JTable에 다시 보여줘야 함.
		jb3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				connect(); // 데이터베이스 로딩 및 접속하는 메서드 호출
				update(); //데이터베이스 데이터를 수정하는 메서드 호출
				
				// 입력 텍스트필드 영역 초기화
				jtf1.setText(" ");
				jtf2.setText(" ");
				jtf3.setText(" ");
				jtf1.requestFocus();
				
				model.setRowCount(0); // 전체 테이블의 화면을 지워주는 메서드
				select(); // DB에서 전체 내역을 조회하는 메서드 호출
			}
		});
		
		// JTable의 특정 행을 클릭한 상태로 부서삭제(jb4) 버튼을 눌렀을 때
		// 클릭된 행을 DB에서 삭제시키는 작업 진행 후, DEPT 테이블의 전체 리스트를
		// JTable에 다시 보여주면 됨.
		jb4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int result = JOptionPane.showConfirmDialog(null, "정말로 삭제하시겠습니까?","확인",JOptionPane.YES_NO_OPTION);
				
				if(result == JOptionPane.CLOSED_OPTION) {
					JOptionPane.showMessageDialog(null, "취소하셨습니다.");
				}else if(result == JOptionPane.YES_OPTION){
					connect(); 
					delete();
					// 입력 텍스트필드 영역 초기화
					jtf1.setText(" ");
					jtf2.setText(" ");
					jtf3.setText(" ");
					jtf1.requestFocus();
				}else if(result == JOptionPane.NO_OPTION) {
					JOptionPane.showMessageDialog(null, "아니요를 선택 하셨습니다.");
				}
				
			}
		}); // jb4 end문
		
		// 테이블 컴포넌트가 텍스트필드를 가르키고 그 컴포넌트를 대상으로 이벤트를 준다
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				int row = table.getSelectedRow();
				
				jtf1.setText("");
				jtf2.setText("");
				jtf3.setText("");
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			
			// 테이블필드에 마우스를 클릭을 했을 때 이벤트를 작동할 수 있음.
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				
				jtf1.setText(model.getValueAt(row, 0).toString());
				jtf2.setText(model.getValueAt(row, 1).toString());
				jtf3.setText(model.getValueAt(row, 2).toString());
				
				
			}
		});
		
	}
	
	// DB를 연동하는 메서드
	void connect(){
		
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
	} // connect() end부분
	
	
	// DEPT 테이블의 전체 내역을 조회하는 메서드
	void select() {
		try {
			// 1. 데이터베이스에 전송할 SQL문 작성
			sql = "select * from dept order by deptno";
			pstmt = con.prepareStatement(sql);
			
			// 2. 데이터베이스에 SQL문을 전송 및 실행
			rs = pstmt.executeQuery();
			
			// 3. 레코드 수 만큼 반복하여 데이터를 추출
			while(rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				
				Object[] data = {deptno,dname,loc};
				
				// 저장한 한 개의 레코드(data)를 model에 추가해 주면 됨.
				model.addRow(data);
			}
			
			// 4. 데이터베이스 연결되어 있던 자원 종료
			rs.close(); pstmt.close(); con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // select() 메서드 end부분

	
	// DEPT 테이블에 부서 정보를 추가하는 메서드
	void insert() {
		
		try {
			//1. 데이터베이스에 전송할 SQL문을 작성하기.
			sql = "insert into dept values(?,?,?)";
			pstmt = con.prepareStatement(sql);
		
		
			String deptno = jtf1.getText();
			String dname = jtf2.getText();
			String loc = jtf3.getText();
			
			pstmt.setInt(1, Integer.parseInt(deptno));
			pstmt.setString(2, dname);
			pstmt.setString(3, loc);
			
			// 2. 오라클데이터베이스에 SQL문 전송 및 SQL문 실행
			int res = pstmt.executeUpdate();
			
			if(res > 0) {
				JOptionPane.showMessageDialog(null, "부서 추가 성공");
			}else {
				JOptionPane.showMessageDialog(null, "부서 추가 실패");
			}
			
			// 3. 오라클 데이터베이스에 연결되어 있던 자원 종료.
			pstmt.close(); 
			// con.close(); 데이터베이스 연결을 종료시키게되면 select()메서드가 호출되지 않는다.
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // insert() 메서드 end부분
	
	
	// DEPT 테이블에 부서를 수정하는 메서드
	void update() {
		try {
			// 1. 데이터베이스에 전송할 SQL문 작성
			sql = "update dept set dname = ?, loc = ? where deptno = ?";
			pstmt = con.prepareStatement(sql);
		
			pstmt.setString(1, jtf2.getText());
			pstmt.setString(2, jtf3.getText());
			pstmt.setInt(3, Integer.parseInt(jtf1.getText()));
			
			// 2. 오라클 데이터베이스를 전송 및 실행
			int res = pstmt.executeUpdate();
			
			if(res > 0 ) {
				JOptionPane.showMessageDialog(null, "부서 정보 수정 성공");
			} else {
				JOptionPane.showMessageDialog(null, "부서 정보 수정 실패");
			}
			
			// 3. 데이터베이스 관련 유틸 종료
			pstmt.close();
			// con.close(); 수정 후 전체리스트를 가져와야하기에 데이터베이스는 연결이 되어있어야 한다.
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // update() 메서드의 end 부분
	
	
	// DEPT 테이블에 특정 행을 삭제시키는 메서드
	void delete() {
		try {
			
			//1. 데이터베이스에 전송할 SQL문을 작성
			sql = "delete from dept where deptno = ?";
			pstmt = con.prepareStatement(sql);
			
			// JTable에서 선택된 셀의 row 값을 int형으로 반환해 주는 메서드
			int row = table.getSelectedRow();
			
			// getValueAt(세로인덱스(행), 가로인덱스(열))
			
			pstmt.setInt(1, (int)model.getValueAt(row, 0));
			
			// 2. 오라클 데이터베이스에 SQL문 정송 및 SQL문 실행
			int res = pstmt.executeUpdate();
			
			if(res > 0 ) {
				JOptionPane.showMessageDialog(null, "부서 삭제 성공");
			} else {
				JOptionPane.showMessageDialog(null, "부서 삭제 실패");
			}
			
			model.removeRow(row); // 테이블 상의 한 줄 삭제
			
			// 3. 데이터베이스 관련 유틸 종료
			pstmt.close();
			con.close(); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String[] args) {
		new Dept();
	}
}
