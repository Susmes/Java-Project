package busReservation;

import java.util.Date;
import java.sql.*;

public class BookingDAO {
	
	public static int getBookedCount(int busNo,Date date) throws Exception {
		
		String query = "select count(passenger_name) from booking where bus_no=? and travel_date=?";
		Connection con = DbConnection.getConnection();
		PreparedStatement pst = con.prepareStatement(query);
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		pst.setInt(1, busNo);
		pst.setDate(2, sqlDate);
		ResultSet rs = pst.executeQuery();
		rs.next();
		return rs.getInt(1);
	}
	public static void addBooking(Booking booking) throws Exception {
		String query = "insert into booking values (?,?,?)";
		Connection con = DbConnection.getConnection();
		PreparedStatement pst = con.prepareStatement(query);
		java.sql.Date sqlDate = new java.sql.Date(booking.date.getTime());
		pst.setString(1, booking.passengerName);
		pst.setInt(2, booking.busNo);
		pst.setDate(3, sqlDate);
		
		pst.executeUpdate();
	}

}
