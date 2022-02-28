package khie;

import java.sql.*;
import java.util.Scanner;

public class Delete2 {

	public static void main(String[] args) {
		Connection con = null;  // DB와 연결하는 객체
		PreparedStatement pstmt = null; // SQL문을 DB에 전송하는 객체
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "web";
		String pwd = "1234";
		
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제하실 ID를 입력해주세요 : ");
		int delete = sc.nextInt();
		
		try {
			// 오라클데이터베이스에 로딩 및 접속하기
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pwd);
			
			// 데이터베이스에 전달할 SQL문 작성하기
			String sql = "delete human where id = ?";
			pstmt = con.prepareCall(sql);
			pstmt.setInt(1, delete);
			
			// 데이터베이스에 요청이 잘 전달되었는지 확인하기.
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				System.out.println("삭제 완료");
			} else {
				System.out.println("삭제 실패");
			}
			
			// 관련 데이터베이스 유틸 종료하기
			con.close(); pstmt.close(); sc.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
