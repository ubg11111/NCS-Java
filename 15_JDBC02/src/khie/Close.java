package khie;

import java.sql.*;


public class Close {
	public static void getClose(PreparedStatement psmt, Connection con, ResultSet rs) {
			
			try {
				if(psmt != null) { 
					psmt.close();
				} 
				if(con != null) {
					con.close();
				}
				if(rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
}

