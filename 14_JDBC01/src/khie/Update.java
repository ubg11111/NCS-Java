package khie;

import java.sql.*;
import java.util.Scanner;


public class Update {

	public static void main(String[] args) {
		Connection con = null;  // DB와 연결하는 객체
		PreparedStatement pstmt = null; // SQL문을 DB에 전송하는 객체
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "web";
		String password = "1234";

		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("수정할 메모 글 번호 : ");
		String no = sc.nextLine();
		
		System.out.print("메모 수정 제목 : ");
		String reTitle = sc.nextLine();
		
		System.out.print("메모 수정 내용 : ");
		String reCont = sc.nextLine();
		
		// 1단계 : 오라클 드라이버 로딩
		try {
			Class.forName(driver);
		
		// 2단계 : 오라클 데이터베이스에 접속하기
		con = DriverManager.getConnection(url, user, password);
		
		// 3단계 : 오라클데이터베이스 SQL문에 전송할 쿼리문 작성하기
		String sql = "update memo set title = ?, cont = ? where bunho = ?";
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, reTitle);
		
		pstmt.setString(2, reCont);
		
		// 상기 문자형의 no 변수를 int형으로 형변환하여 setInt 저장한다.
		pstmt.setInt(3, Integer.parseInt(no)); 
		
		// 4단계 : 데이터베이스에 SQL문을 전송
		int res = pstmt.executeUpdate();
		
		if(res > 0) {
			System.out.println("메모가 업데이트 완료되었습니다.");
		} else {
			System.out.println("메모가 업데이트 되지 않았습니다.");
		}
		
		// 5단계 : 데이터베이스 연결창 종료
		con.close(); pstmt.close(); sc.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
