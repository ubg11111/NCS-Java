package khie;

import java.sql.*;
import java.util.Scanner;

public class Update2 {

	public static void main(String[] args) {
		Connection con = null;  // DB와 연결하는 객체
		PreparedStatement pstmt = null; // SQL문을 DB에 전송하는 객체
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("아이디 입력 : ");
		String id = sc.nextLine();

		System.out.print("수정 될 직업 입력 : ");
		String job = sc.nextLine();
		
		System.out.print("수정 될 폰번호 입력 : ");
		String phone = sc.nextLine();
		
		System.out.print("수정 될 급여 입력 : ");
		String sal = sc.nextLine();
		
		
	
		try {
			// 데이터베이스에 로딩 및 접속
		con = DBConnection.getConnection();
		
		// SQL문을 작성해서 데이터베이스에 전달하기
		String sql = "update human set job = ?, phone =?, sal = ? where id = ? ";
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, job);
		pstmt.setString(2, phone);
		pstmt.setInt(3, Integer.parseInt(sal));
		pstmt.setInt(4, Integer.parseInt(id));
		
		
		// 데이터베이스 실행 확인하기
		int rs = pstmt.executeUpdate(); // 디폴트값은 1이고 1이 출력이되어야 정상으로 작동이 된것을 의미한다.
		
		// 작동이 되었는지 출력문으로 확인하기위해 조건문을 사용.
		if(rs > 0) {
			System.out.println("정보 변경이 완료 되었습니다.");
		}else {
			System.out.println("정보 변경이 실패 하였습니다.");
		}
		
		// 데이터베이스 관련 유틸 종료.
		Close.getClose(pstmt, con, null);
		sc.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
