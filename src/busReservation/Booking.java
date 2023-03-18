package busReservation;

import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.SQLException;

public class Booking {
	
	String passengerName;
	int busNo;
	Date date;
	
	Booking(){
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Name of Passenger : ");
		passengerName = scanner.next();
		System.out.println("Enter the Bus No : ");
		busNo = scanner.nextInt();
		System.out.println("Enter the Date(dd-mm-yyyy) : ");
		String dateInput = scanner.next();
		SimpleDateFormat dateFormat = new SimpleDateFormat ("dd-mm-yyyy");
		
		try {
			date = dateFormat.parse(dateInput);
		}catch(ParseException e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean isAvailable() throws Exception{
		
		int capacity = BusDataAccessObject.getCapacity(busNo);
		
		int booked = BookingDAO.getBookedCount(busNo,date);
		
		return booked<capacity;
	}
	

}
