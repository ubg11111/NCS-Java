package teamproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private DBConnection() {
	}
	private static Connection con = null;
		static final String  driver = "oracle.jdbc.driver.OracleDriver";
		static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
		static final String user = "web";
		static final String password = "1234";
		
	public static Connection getConnect() throws Exception {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
	}
}
