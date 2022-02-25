package khie;

import java.sql.*;
import java.util.Scanner;

public class Delete {

	public static void main(String[] args) {
		Connection con = null;  // DB와 연결하는 객체
		PreparedStatement pstmt = null; // SQL문을 DB에 전송하는 객체
	
		Scanner sc = new Scanner(System.in);
		
		System.out.print("삭제할 사원 번호 : ");
		int empno = sc.nextInt();
		
		try {
		// 1+2단계 로딩 및 접속하기	
		con = DBConnection.getConnection();
		
		// 3단계 데이터베이스에 SQL문 작성하여 전달하기
		String sql = "delete from emp where empno = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, empno);
		
		// 4단계 데이터베이스에 전송 및 실행
		int rs = pstmt.executeUpdate();
		
		if(rs > 0) {
			System.out.println("삭제 완료");
		}else {
			System.out.println("삭제 실패");
		}
		
		// 5단계 : 관련 데이터베이스 유틸 종료
		//		con.close(); pstmt.close(); sc.close();
		Close.getClose(pstmt, con, null);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
