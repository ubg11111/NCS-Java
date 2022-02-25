package khie;

import java.sql.*;
import java.util.Scanner;


public class Delete {

	public static void main(String[] args) {
		Connection con = null;  // DB와 연결하는 객체
		PreparedStatement pstmt = null; // SQL문을 DB에 전송하는 객체
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "web";
		String password = "1234";
	
	
		Scanner sc = new Scanner(System.in);
		
		System.out.print("삭제할 메모 글 번호 : ");
		int num = sc.nextInt();
		
		
		// 1단계 데이터베이스에 로딩하기
		try {
			Class.forName(driver);
		
		// 2단계 데이터베이스에 접속하기
		con = DriverManager.getConnection(url, user, password);
		
		// 3단계 데이터베이스 SQL문에 전송할 SQL문 쿼리 작성하기.
		String sql = "delete from memo where bunho = ? ";
		pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, num);
		
		// 4단계 데이터베이스에 SQL문을 전송 및 실행
		int res = pstmt.executeUpdate();
		
		if(res == 1) {
			System.out.println("삭제가 성공하였습니다.");
		}else {
			System.out.println("삭제가 실패하였습니다.");
		}
		
		// 5단계 : 데이터베이스와 연결되었던 객체 닫기
		pstmt.close(); con.close(); sc.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
