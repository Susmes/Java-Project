package busReservation;

import java.sql.*;

public class DbConnection {
	private static final String url = "jdbc:mysql://localhost:3306/busResrv";
	private static final String user = "root";
	private static final String Pass = "1234";
	
	public static Connection getConnection() throws Exception{
		return DriverManager.getConnection(url, user, Pass);
	}
	
}
