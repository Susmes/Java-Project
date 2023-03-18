package busReservation;

import java.sql.*;

public class BusDataAccessObject {
	
	public static void displayBusInfo() throws Exception{
		
		String query = "select * from bus";
		Connection con = DbConnection.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next()) {
			System.out.println("Bus No : " + rs.getInt(1));
			
			if(rs.getInt(2) == 0) {
				System.out.println("AC : No ");
			}else
				System.out.println("AC : YES ");
			
			System.out.println("Capacity : " + rs.getInt(3));			
		}
		System.out.println("--------------------------------------------");
	}
	
	public static int getCapacity(int id) throws Exception{
		String query = "select CAPACITY from bus where ID=" + id;
		Connection con = DbConnection.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
		return rs.getInt(1);
	}
}
