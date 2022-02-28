package khie;

import java.sql.*;
import java.util.Scanner;



public class Insert2 {
	
	public static void main(String[] args) {
		Connection con = null;  // DB와 연결하는 객체
		PreparedStatement pstmt = null; // SQL문을 DB에 전송하는 객체
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("추가할 ID를 입력해주세요 : ");
		String id = sc.nextLine();
		
		System.out.print("추가할 이름을 입력해주세요 : ");
		String name = sc.nextLine();
		
		System.out.print("추가할 직업을 입력해주세요 : ");
		String job = sc.nextLine();
		
		System.out.print("추가할 나이를 입력해주세요 : ");
		String age = sc.nextLine();
		
		System.out.print("추가할 주소를 입력해주세요 : ");
		String addr = sc.nextLine();
		
		System.out.print("추가할 번호를 입력해주세요 : ");
		String phone = sc.nextLine();
		
		System.out.print("추가할 급여를 입력해주세요 : ");
		String sal = sc.nextLine();
		
		
		
		try {
			// 데이터베이스 로딩 및 접속하기
			con = DBConnection.getConnection();
			
			// 데이터베이스에 전달할 SQL문 작성하기
			String sql = "insert into human values(?,?,?,?,?,?,?,sysdate)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, Integer.parseInt(id));
			pstmt.setString(2, name);
			pstmt.setString(3, job);
			pstmt.setInt(4, Integer.parseInt(age));
			pstmt.setString(5, addr);
			pstmt.setString(6, phone);
			pstmt.setInt(7, Integer.parseInt(sal));
			
			// 데이터베이스 접속 확인하기
			int res = pstmt.executeUpdate();
			
			if(res > 0) {
				System.out.println("휴먼 테이블에 값을 추가하였습니다.");
			}else {
				System.out.println("휴먼 테이블에 값 추가를 실패하였습니다.");
			}
			
			// 데이터베이스 연결 종료하기
			pstmt.close(); con.close(); sc.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
