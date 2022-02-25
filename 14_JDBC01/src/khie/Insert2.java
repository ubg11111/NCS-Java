package khie;

import java.sql.*;
import java.util.Scanner;

import oracle.net.aso.f;



public class Insert2 {

	public static void main(String[] args) {
		Connection con = null;  // DB와 연결하는 객체
		
		PreparedStatement pstmt = null; // SQL문을 DB에 전송하는 객체
		
		ResultSet rs = null; // SQL문을 실행한 후의 결과값을 가지고 있는 객체
		
		// 드라이버 경로의 드라이버 이름
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		// 오라클데이터베이스의 자신의 계정 URL
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		// 오라클데이터베이스의 user ID
		String user = "web";
		
		// 오라클데이터베이스의 패스워드
		String password = "1234";
		
		// finally 실행을 위해 전역변수로 선언
		int result1 = 0;
		
		// db에서 sql문을 스캐너로 작성하여 전달하기
		Scanner sc = new Scanner(System.in);
		
		System.out.print("메모 제목 : ");
		String title = sc.nextLine();
		
		System.out.print("메모 작성자 : ");
		String writer = sc.nextLine();
		
		System.out.print("메모 내용 : ");
		String content = sc.nextLine();
		
		// 1단계 오라클 데이터베이스 로딩하기 
		try {
			// 예외처리를 무저건 해줘야한다. why? 로딩이 안될수도 있으니까
			Class.forName(driver);
		
		// 2단계 오라클 데이터베이스와 연결 진행하기
			con = DriverManager.getConnection(url, user, password);
		
			
		// 3단계 데이터베이스에 전달할 SQL문을 작성한다.
		// 오라클데이터베이스에서 테이블에 데이터를 넣을때 작성하는 쿼리문이고, 시퀀스를 참고해서 추가하는것이다 (?)는 자료형의 변수를 넣어줌으로써 값을 입력할 수 있다.
		String sql2 = "insert into memo values(memo_seq.nextval, ?, ?, ?, sysdate)";	
		
		pstmt = con.prepareStatement(sql2); // sql문을 db에서 전송하는 작업
		
		// pstmt = db한테 setString 저장한 내용을 전달한다.
		pstmt.setString(1, title); // 1번째의 의미는 sql2 벨류값에 ?값이 첫번째로 시작되는 값에 넣는다는 의미 
		pstmt.setString(2, writer); // 2번째 ? 값에 메모작성자 변수를 넣는다.
		pstmt.setString(3,  content); // 3번째 ? 값에 메모내용의 변수를 넣는다.
		
		// 4단계 데이터베이스에 SQL문을 전송한다.
		result1 = pstmt.executeUpdate(); // default값이 1이고 1이 반환이되어야 전송이 완료되었다는 문구이다.
		
		// 조건문을 활용하여 상기 결과값이 잘 출력되는지 확인절차를 시도한다.
		
		// 5단계 데이터베이스 모두 종료하기
		con.close();
		pstmt.close();
		sc.close();
		
		} catch (Exception e) {
			// Exception을 전체 처리해줌 why? try문에서 발생할 수 있는 모든 예외문제들을 받아내야하니까.
			e.printStackTrace();
		}
		finally {
			if(result1 > 0) {
				System.out.println("데이터베이스 성공");
			}
			else {
				System.out.println("데이터베이스 실패 오류 확인하세요");
			}
		}
	}
}
