package khie;

import java.sql.*;
import java.util.Scanner;

public class Update {

	public static void main(String[] args) {
		Connection con = null;  // DB와 연결하는 객체
		PreparedStatement pstmt = null; // SQL문을 DB에 전송하는 객체
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("사번 입력 : ");
		String empno = sc.nextLine();

		System.out.print("수정 될 담당업무 입력 : ");
		String job = sc.nextLine();
		
		System.out.print("수정 될 관리자(사번)입력 : ");
		String mgr = sc.nextLine();
		
		System.out.print("수정 될 급여 입력 : ");
		String sal = sc.nextLine();
		
		System.out.print("수정 될 보너스 입력 : ");
		String comm = sc.nextLine();
		
		System.out.print("수정 될 부서번호 입력 : ");
		String deptno = sc.nextLine();
	
	
		try {
		// 오라클 데이터베이스 로딩 및 접속
		con = DBConnection.getConnection();
		
		// 오라클 데이터베이스에 SQL문 작성하여 전송하기
		String sql = "update emp set job = ?, mgr = ?, sal = ?, comm = ?, deptno = ? where empno = ?";
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, job);
		pstmt.setInt(2, Integer.parseInt(mgr));
		pstmt.setInt(3, Integer.parseInt(sal));
		pstmt.setInt(4, Integer.parseInt(comm));
		pstmt.setInt(5, Integer.parseInt(deptno));
		pstmt.setInt(6, Integer.parseInt(empno));
		
		// 오라클 데이터베이스 전송 확인 여부
		int rs = pstmt.executeUpdate();
		
		if(rs > 0) {
			System.out.println("업데이트 완료");
		}else {
			System.out.println("업데이트 실패");
		}
		
		// 오라클 데이터베이스 관련 유틸 종료
		con.close(); pstmt.close(); sc.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
