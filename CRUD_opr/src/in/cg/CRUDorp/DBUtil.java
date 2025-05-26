package in.cg.CRUDorp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static final String url="jdbc:mysql://localhost:3306/student_db";
	private static final String user="root";
	private static final String paswd="root";
	public static Connection getConnection() throws SQLException{
		Connection conn=DriverManager.getConnection(url,user,paswd);
		return conn;
	}
}

