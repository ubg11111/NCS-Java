package khie;

import java.sql.*;



public class Select {

	public static void main(String[] args) {
		
		Connection con = null;  // DB와 연결하는 객체
		
		PreparedStatement pstmt = null; // SQL문을 DB에 전송하는 객체
		
		ResultSet rs = null; // SQL문을 실행한 후의 결과값을 가지고 있는 객체
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
	
		String user = "web";
		
		String password = "1234";
		
		
		// 오라클드라이버가 없을 수도 있어서 예외처리를 해줘야 함.
		try {
			// 1단계 : 오라클 드라이버를 로딩.
			// ==> 동적으로 로딩 : 프로그램 실행 시에 오라클 드라이버를 로딩한다는 의미.
			Class.forName(driver);
			System.out.println("드라이버 로딩 성공!!!!");
			
			// 2단계 : 오라클 데이터베이스와 연결 시도.
			con = DriverManager.getConnection(url, user, password);
			if(con != null) {
				System.out.println("오라클 데이터베이스와 연결 성공");
			}
			
			// 3단계 : 데이터베이스 SQL문을 전송하기 위한 쿼리문 작성.
			String sql = "select * from memo order by bunho desc";
			
			pstmt = con.prepareStatement(sql);
			
			// 4단계 : 데이터베이스에 SQL문을 전송.
			rs = pstmt.executeQuery(); // 실제로 DB에서 SQL문을 실행하는 메서드.
			
			// 5단계 : 데이터를 가져와서 출력 (레코드 가져오기)
			// rs.next는 행을 기준으로 한칸씩 출력을 하게된다. 즉 
			// while 반복문 특성상 한개씩 내려가면서 정보들을 출력하는데 맞는 데이터가 없는경우 false로 확인되어 데이터값이 출력이 안된다.
			while(rs.next()) {
				int bunho = rs.getInt("bunho");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String cont = rs.getString("cont");
				String regdate = rs.getString("regdate").substring(0,10);
				
				System.out.println(bunho+"\t"+title+"\t"+writer+"\t"+cont+"\t"+regdate);
			}
			
			// 6단계 : 연결되어 있던 객체들은 종료해 주는 것이 좋다.
			rs.close(); pstmt.close(); con.close();
			
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
