package khie;

import java.sql.*;
import java.util.Scanner;

public class Insert {

	public static void main(String[] args) {
		Connection con = null;  // DB와 연결하는 객체
		PreparedStatement pstmt = null; // SQL문을 DB에 전송하는 객체
		
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("사번 입력 : ");
		String empno = sc.nextLine();
	
		System.out.print("이름 입력 : ");
		String ename = sc.nextLine();
		
		System.out.print("담당업무 입력 : ");
		String job = sc.nextLine();
		
		System.out.print("관리자(사번)입력 : ");
		String mgr = sc.nextLine();
		
		System.out.print("급여 입력 : ");
		String sal = sc.nextLine();
		
		System.out.print("보너스 입력 : ");
		String comm = sc.nextLine();
		
		System.out.print("부서번호 입력 : ");
		String deptno = sc.nextLine();
		
		try {
		// 1 + 2단계를 메서드를 통해서 진행
		con = DBConnection.getConnection();
		
		// 3단계 : 데이터베이스에 SQL 쿼리문 작성해서 전송하기
		String sql = "insert into emp values(?,?,?,?,sysdate,?,?,?)";
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, Integer.parseInt(empno));
		pstmt.setString(2, ename);
		pstmt.setString(3, job);
		pstmt.setInt(4, Integer.parseInt(mgr));
		pstmt.setInt(5, Integer.parseInt(sal));
		pstmt.setInt(6, Integer.parseInt(comm));
		pstmt.setInt(7, Integer.parseInt(deptno));
		
		
		// 4단계 : 오라클 데이터베이스에 SQL문 전송 및 실행
		int rs = pstmt.executeUpdate();
		
		if(rs > 0) {
			System.out.println("사원등록 성공");
		} else {
			System.out.println("사원등록 실패");
		}
		
		// 5단계 : 오라클 데이터베이스에 있는 내용 닫기
		con.close(); pstmt.close(); sc.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
