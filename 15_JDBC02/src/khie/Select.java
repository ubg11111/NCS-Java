package khie;

import java.sql.*;


public class Select {

	public static void main(String[] args) {
		
		Connection con = null;  // DB와 연결하는 객체
		PreparedStatement pstmt = null; // SQL문을 DB에 전송하는 객체
		ResultSet rs = null; // SQL문을 실행한 후의 결과값을 가지고 있는 객체
		
		try {
			// 1단계 + 2단계 : 오라클 드라이버 로딩 및 오라클 데이터베이스 연결 시도.
			con = DBConnection.getConnection();
			
			//			if(con != null) {
			//			System.out.println("데이터 베이스 연결 성공");
			//		} else {
			//			System.out.println("데이터 베이스 연결 실패");
			//		}
			
			// 3단계 : 데이터베이스에 전송할 SQL문 쿼리작성
			String sql = "select * from emp order by empno desc";
			
			pstmt = con.prepareStatement(sql);
			
			
			// 4단계 : 데이터베이스에 SQL문 전송 및 SQL문 실행
			rs = pstmt.executeQuery();
			
			// 5단계 : while 반복문을 이용하여 데이터를 가져와서 출력
			
			while(rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				String hiredate = rs.getString("hiredate").substring(0,10);
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");
				
				System.out.println("사원번호\t이름\t담당업무\t매니저\t입사일\t급여\t보너스\t부서번호");
				System.out.println(empno+"\t"+ename+"\t"+job+"\t"+mgr+"\t"+hiredate+"\t"+sal+"\t"+comm+"\t"+deptno);
				System.out.println("==============================================================================");
			}
			
			// 6단계 : 데이터베이스 실행문 종료하기
			con.close(); pstmt.close(); rs.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
