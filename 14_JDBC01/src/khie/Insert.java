package khie;

import java.sql.*;
import java.util.Scanner;


public class Insert {

	public static void main(String[] args) {
		
		Connection con = null;  // DB와 연결하는 객체
		
		PreparedStatement pstmt = null; // SQL문을 DB에 전송하는 객체
		
		ResultSet rs = null; // SQL문을 실행한 후의 결과값을 가지고 있는 객체
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
	
		String user = "web";
		
		String password = "1234";
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("메모 제목 :  ");
		String title = sc.nextLine();
		
		System.out.print("메모 작성자 : ");
		String writer = sc.nextLine();
		
		System.out.print("메모 내용 : ");
		String content = sc.nextLine();
		
		// 1단계 오라클 드라이버 로딩하기.
		try {
			Class.forName(driver);
		
		// 2단계 : 오라클 데이터베이스와 연결 진행 시도.
			con = DriverManager.getConnection(url, user, password);
		
		// 3단계 : 데이터베이스 SQL문을 전송하기 위한 쿼리문 작성.
		String sql = "insert into memo values(memo_seq.nextval, ?, ?, ?, sysdate)";
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, title); // sql(?)에 들어가야하는 데이터가 스트링인경우 setString / int형인경우 setInt형으로 사용한다.
		
		pstmt.setString(2, writer);
		
		pstmt.setString(3, content);
		
		
		// 4단계 : 데이터베이스에 SQl문을 전송.
		/*
		 * 주의사항
		 * -SQL 문이 select sql문인 경우에는 executeQuery() 메서드를 이용한다.
		 * ==> 반환형이 ResultSet 형이 된다.
		 * -SQL 문이 select가 아닌 insert,update,delete SQL 문인 경우
		 * 	EXEcuteUpdate() 메서드를 이용하면 됨. == 반환형은 int 형
		 * ==> 반환형이 int인 이유 : 행이 삽입, 행 수정, 행 삭제 갯수를 표현한 것.
		 * ==> SQL문이 성공적으로 실행이 되면 반환되는 값은 1이라는 값이 반환
		 * ResultSet rs = null; ==> 반환형이 int이기에 사용하지 않는다.
		 */
		int result = pstmt.executeUpdate();
		
		if(result ==  1) {
			System.out.println("데이터 추가 완료");
		} else {
			System.out.println("데이터 추가 실패");
		}
		
		// 5단계 : 연결된 객체를 종료
		con.close(); pstmt.close(); sc.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
