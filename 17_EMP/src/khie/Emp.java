package khie;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Emp extends JFrame{
	
	Connection con = null; // DB와 연결하는 객체
	PreparedStatement pstmt = null; // SQL문을 DB에 전송하는객체
	ResultSet rs = null;   // SQL문 실행결과를 가지고 있는 객체
	String sql = null; // SQL문을 저장하는 문자의변수
	DefaultTableModel model;
	JTable table;
	JTextField jtf1,jtf2,jtf3,jtf4;
	JComboBox<String> jcb1,jcb2,jcb3;
	
	
	public Emp() {
		setTitle("사원관리 화면");
		
		JPanel container1 = new JPanel(); // 상단-1 컨테이너
		JPanel container2 = new JPanel(); // 상단-2 컨테이너
		JPanel container3 = new JPanel(); // 하단 컨테이너
		
		// 1. 컴포넌트들을 만들어 보자.
		// 1-1 상단-1 컨테이너에 들어갈 컴포넌트들을 만들어보자.
		JLabel jl1 = new JLabel("사번 : ");
		jtf1 = new JTextField(4);
		
		JLabel jl2 = new JLabel("이름 : ");
		jtf2 = new JTextField(10);
		
		JLabel jl3 = new JLabel("담당업무 : ");
		jcb1 = new JComboBox<String>();
		
		// 1-2. 상단 -2 컨테이너에 들어갈 컴포넌트들을 만들어보자.
		JLabel jl4 = new JLabel("관리자 No : ");
		jcb2 = new JComboBox<String>();
		
		JLabel jl5 = new JLabel("급여 : ");
		jtf3 = new JTextField(5);

		JLabel jl6 = new JLabel("보너스 : ");
		jtf4 = new JTextField(5);

		JLabel jl7 = new JLabel("부서번호 : ");
		jcb3 = new JComboBox<String>();
		
		jcb1.addItem("선택"); jcb2.addItem("선택"); jcb3.addItem("선택");
		
		// 1-3. 중앙에 위치할 컴포넌트들을 만들어 보자.
		String[] header =
			{"사 번", "이 름", "담당업무", "관리자No.", "입사일", "급 여", "보너스", "부서번호"};
		
		model = new DefaultTableModel(header, 0);
		
		table = new JTable(model);
	
		JScrollPane jsp = new JScrollPane(
				table,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
				);
		
		// 1-4. 하단 컨테이너에 올려질 컴포넌트들을 만들어 보자.
		JButton jb1 = new JButton("사원 목록");
		JButton jb2 = new JButton("사원 추가");
		JButton jb3 = new JButton("사원 수정");
		JButton jb4 = new JButton("사원 삭제");
		
		
		// 2. 컴포넌트들을 컨테이너에 올려주어야 한다.
		// 2.1 상단-1 컨테이너에 1-1 컴포넌트들을 올려야 한다.
		container1.add(jl1);
		container1.add(jtf1);
		
		container1.add(jl2);
		container1.add(jtf2);
		
		container1.add(jl3);
		container1.add(jcb1);
		
		// 2.2 상단-2 컨테이너에 1-2컴포넌트들을 올려야 한다.
		container2.add(jl4);
		container2.add(jcb2);
		
		container2.add(jl5);
		container2.add(jtf3);
		
		container2.add(jl6);
		container2.add(jtf4);
		
		container2.add(jl7);
		container2.add(jcb3);
		
		// 2-3. 하단 컨테이너에 1-4 컴포넌트들을 올려야 한다.
		container3.add(jb1);
		container3.add(jb2);
		container3.add(jb3);
		container3.add(jb4);
		
		// 새로운 컨테이너 하나를 만들어서 기존의 컨테이너들을 올려 주자.
		JPanel group = new JPanel(new BorderLayout());
		
		group.add(container2, BorderLayout.NORTH);
		group.add(jsp, BorderLayout.CENTER);
		group.add(container3, BorderLayout.SOUTH);
		
		// 컨테이너를 프레임에 올려주자.
		add(container1, BorderLayout.NORTH);
		add(group, BorderLayout.CENTER);
		
		
		setBounds(200,200,650,350);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		
		// 4. 부서번호를 화면에 띄워보도록 하자.
		connect();
		comboJob();
		comboMgr();
		comboDept();
		
		
		// 5. 이벤트를 처리해보자
		// 사원 목록(jb1) 버튼을 클릭 시 EMP 테이블에 있는 전체 사원의 
		// 목록을 JTable 화면에 보여주면 됨.
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				connect();			  // 데이터베이스와 연결하는 메서드 호출.
				model.setRowCount(0); // 전체 테이블 화면을 지워주는 메서드.
				select(); 			  // EMP 테이블의 전체 사원 목록을 조회하는 메서드.
				
			}
		});
		
		// 사원 등록(jb2) 버튼을 클릭 시 각각의 텍스트필드에 입력된 데이터를
		// EMP 테이블에 추가해 주고, JTable에는 등록된 사원까지 목록이 나타나면 됨.
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				connect();
				insert(); 			// EMP 테이블에 사원을 등록하는 메서드 호출.
				
				// 입력하는 텍스트 필드 초기화 하기
				jtf1.setText("");
				jtf2.setText("");
				jtf3.setText("");
				jtf4.setText("");
				
				jcb1.setSelectedIndex(0); // 0번째 인덱스를 선택 "선택"이 체크됨.
				jcb2.setSelectedIndex(0);
				jcb3.setSelectedIndex(0);
				jtf1.requestFocus();
				
				
				model.setRowCount(0); // 전체 테이블을 지워주는 메서드
				
				// DB에 사원 등록 후 반영된 전체리스트 메서드를 호출
				select();
			}
		});
		
		// 사원 수정 (jb3) 버튼 클릭시 각각의 텍스트필드에 수정하여 입력된 
		// 데이터를 EMP 테이블에서 수정을 하고, JTable에 수정된 정보가 나타나게 하면 됨.
		jb3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				connect();
				update();
				
				// 입력하는 텍스트 필드 초기화 하기
				jtf1.setText("");
				jtf2.setText("");
				jtf3.setText("");
				jtf4.setText("");
				
				jcb1.setSelectedIndex(0); // 0번째 인덱스를 선택 "선택"이 체크됨.
				jcb2.setSelectedIndex(0);
				jcb3.setSelectedItem("선택");
				jtf1.requestFocus();
				
				
				model.setRowCount(0); // 전체 테이블을 지워주는 메서드
				
				// DB에 사원 등록 후 반영된 전체리스트 메서드를 호출
				select();
			}
		});
		
		// 사원 삭제(jb4) 버튼 클릭 시 JTable에서 특정 행을
		// EMP테이블에서 삭제하는 작업을 진행.
		jb4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "정말로 삭제하시겠습니까?","확인",JOptionPane.YES_NO_OPTION);
				
				if(result == JOptionPane.CLOSED_OPTION) {
					JOptionPane.showMessageDialog(null, "취소하셨습니다.");
				}else if(result == JOptionPane.YES_OPTION){
					connect(); 
					delete();
			
					// 입력하는 텍스트 필드 초기화 하기
					jtf1.setText("");
					jtf2.setText("");
					jtf3.setText("");
					jtf4.setText("");
					
					jcb1.setSelectedIndex(0); // 0번째 인덱스를 선택 "선택"이 체크됨.
					jcb2.setSelectedIndex(0);
					jcb3.setSelectedItem("선택");
					jtf1.requestFocus();
				}
			}
		});
		
		table.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {}
			
			public void mousePressed(MouseEvent e) {}
			
			public void mouseExited(MouseEvent e) {}
			
			public void mouseEntered(MouseEvent e) {}
			
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
			
				jtf1.setText(model.getValueAt(row, 0).toString());
				jtf2.setText(model.getValueAt(row, 1).toString());
				jcb1.setSelectedItem(model.getValueAt(row, 2).toString());
				int empno = (int)model.getValueAt(row, 3);
				if(empno == 0) {
					jcb2.setSelectedIndex(0);
				}else {
					connect();
					// 사원번호에 해당하는 사원명을 검색하는 메서드를 호출.
					String findName = findEname(empno);
					jcb2.setSelectedItem(empno + "[" + findName + "]");
					
					jtf3.setText(model.getValueAt(row, 5).toString());
					jtf4.setText(model.getValueAt(row, 6).toString());
					
					int deptno = (int)model.getValueAt(row, 7);
				
					// 부서번호에 해당하는 부서명을 찾는 메서드 호출
					String findNDname = findDname(deptno);
					jcb3.setSelectedItem(deptno + "[" + findNDname + "]");
				}
			}
		});
	} // 생성자 end
	
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
	
		
	// dept 테이블의 부서번호를 조회하는 메서드
	void comboDept() {
		
		try {
		// 1. 오라클 데이터베이스로 전송할 SQL문 작성.
		sql = "select * from dept order by deptno";
		pstmt = con.prepareStatement(sql);
		
		// 2. 오라클 데이터베이스로 SQl문 전송 및 SQL문 실행
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			int deptno = rs.getInt("deptno");
			String dname = rs.getString("dname");
			jcb3.addItem(deptno + "[" + dname + "]");
			
		}
		// 3. 오라클 데이터베이스에 연결되어 있던 자원 종료.
		rs.close(); pstmt.close(); con.close();
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	} // connect() 메서드 end
	
	// 인자로 넘어온 사원번호로 사원면을 찾는 메서드.
	String findEname(int num) {
		String findName = "";
		
		try {
			sql = "select ename from emp where empno = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				findName = rs.getString("ename");
			}
			
			rs.close(); pstmt.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return findName;
	} // findEname() 메서드 end

	// 인자로 넘어온 부서번호에 해당하는 부서명을 찾는 메서드.
	String findDname(int no) {
		String findDname = "";
		try {
			sql = "select dname from dept where deptno = ?";
			pstmt = con.prepareStatement(sql);
		
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				findDname = rs.getString("dname");
			}
			
			rs.close(); pstmt.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return findDname;
	} // findDname 메서드 end부분
	
	void comboJob() {
		
		try {
			// 1. 오라클 데이터베이스에 전송할 SQL문 작성하기
			sql = "select distinct(job) from emp order by job";
			pstmt = con.prepareStatement(sql);
			
			// 2. 오라클 데이터베이스에 SQL문 전송 및 SQL문 실행
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String job = rs.getString("job");
			
				jcb1.addItem(job);
			}
			
			
			// 3. 오라클 데이터베이스에 연결 되어 있던 자원 종료
			// con.close()는 종료 (X) 다음 메서드인 comboDept가 정상적으로 실행되기 위해서
			pstmt.close(); rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // comboJob()의 end 부분
	
	
	// emp 테이블의 관리자 사원들을 조회하는 메서드
	void comboMgr(){
		
		try {
			sql = "select empno,ename from emp where empno in (select distinct(mgr) from emp)";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
		
			while(rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
			
				jcb2.addItem(empno + "[" + ename + "]");
			}
			
			pstmt.close(); rs.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // combomgr()의 end부분
		
	// EMP 테이블의 전체 사원목록을 조회하는 메서드
	void select() {
		
		try {
			// 1. 오라클 데이터베이스로 전송할 SQL문 작성.
			sql = "select * from emp order by hiredate desc";
			pstmt = con.prepareStatement(sql);
		
			// 2. 오라클 데이터베이스에 SQL문 전송 및 SQL문 실행
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				String hiredate = rs.getString("hiredate").substring(0,10);
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");
				
				// 조상인 오브젝트배열에 각 자료형을 담는다.
				Object[] data = {empno,ename,job,mgr,hiredate,sal,comm,deptno};
				
				// 저장된 한개의 레코드(데이터)를 model에 추가해주면 된다.
				model.addRow(data);
			};
			
			// 3. 데이터베이스에 연결된 자원 종료하기.
			rs.close(); pstmt.close(); con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // select() 메서드 end
	
	// EMP 테이블에 데이터를 추가해주는 메서드
	void insert(){
	
		try {
			// 1. 오라클 데이터베이스에 전송할 SQL문 작성.
			sql = "insert into emp values(?,?,?,?,sysdate,?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			// 문자열로 인식하는 텍스트를 인트로 형변환
			pstmt.setInt(1, Integer.parseInt(jtf1.getText()));
			pstmt.setString(2, jtf2.getText());
			// 인트형을 문자형으로 변환
			pstmt.setString(3, jcb1.getSelectedItem().toString()); // getSelectedItem 메서드를 통해서 콤보박스안에 있는 값을 가져올 수 있다.
			pstmt.setInt
					(4, Integer.parseInt(jcb2.getSelectedItem().toString().substring(0,4)));  // 전체를 int형변환하여 감싸준다 substring은 0,4 번호만 가져온다.
			pstmt.setInt(5, Integer.parseInt(jtf3.getText()));
			pstmt.setInt(6, Integer.parseInt(jtf4.getText()));
			pstmt.setInt
			(7, Integer.parseInt(jcb3.getSelectedItem().toString().substring(0,2)));
			
			
			// 2. 오라클 데이터베이스에 SQL문 전송 및 SQl문 실행.
			int res = pstmt.executeUpdate();
			
			if(res > 0) {
				JOptionPane.showMessageDialog(null, "사원 등록 성공");
			} else {
				JOptionPane.showMessageDialog(null, "사원 등록 실패");
			}
			
			// 3. 오라클 데이터베이스 연결되어 있던 자원 종료.
			// con.close(); 종료하면안됨 전체사원목록을 출력해준상태로 남겨둬야 하기때문.
			pstmt.close(); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// EMP 테이블에 사원의 정보를 수정하는 메서드.
	void update() {

		try {
			// 1. 오라클 데이터베이스에로 전송할 SQL문 작성하기.
			sql = "update emp set job = ? , mgr = ?, sal = ?, comm = ?, deptno = ? where empno = ?";
			pstmt = con.prepareStatement(sql);
			
			
			pstmt.setString(1, jcb1.getSelectedItem().toString()); // getSelectedItem 메서드를 통해서 콤보박스안에 있는 값을 가져올 수 있다.
			pstmt.setInt
					(2, Integer.parseInt(jcb2.getSelectedItem().toString().substring(0,4)));  // 전체를 int형변환하여 감싸준다 substring은 0,4 번호만 가져온다.
			pstmt.setInt(3, Integer.parseInt(jtf3.getText()));
			pstmt.setInt(4, Integer.parseInt(jtf4.getText()));
			pstmt.setInt
			(5, Integer.parseInt(jcb3.getSelectedItem().toString().substring(0,2)));
			pstmt.setInt(6, Integer.parseInt(jtf1.getText()));
			
			// 2. 오라클 데이터베이스에 SQL문 전송 및 SQL문 실행.
			int res = pstmt.executeUpdate();
			
			if(res > 0) {
				JOptionPane.showMessageDialog(null, "사원 정보 수정 성공");
			}else {
				JOptionPane.showMessageDialog(null, "사원 정보 수정 실패");
			}
			
			// 3. 오라클 데이터베이스에 연결되어 있던 자원 종료
			pstmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}	// update() 메서드 end
	
	void delete() {
		
	
		try {
			// 1. 오라클 데이터베이스로 전송할 SQL문을 작성.
			sql = "delete from emp where empno = ?";
			pstmt = con.prepareStatement(sql);
			
			// 테이블의 특정 행을 클릭했을 때 해당 테이블의 값을 가져오는 메서드
			int row = table.getSelectedRow();
			
			// 해당 행의 값을 가져올 때 해당 행의 0번째 열의 값을 가져온다.
			pstmt.setInt(1, (int)model.getValueAt(row, 0));
			
			//2. 오라클 데이터베이스의 SQL문 전송 및 SQL문 실행.
			int res = pstmt.executeUpdate();
			
			if(res > 0) {
				JOptionPane.showMessageDialog(null, "사원 삭제 성공");
			}else {
				JOptionPane.showMessageDialog(null, "사원 삭제 실패");
			}
			
			// 실제로 테이블 상의 클릭한 한 레코드를 삭제.
			model.removeRow(row);
			
			//3. 데이터베이스 연결 종료
			pstmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // delete() 메서드 end
	
	public static void main(String[] args) {
		new Emp();
	}
}
