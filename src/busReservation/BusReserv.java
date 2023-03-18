package busReservation;

import java.util.Scanner;

import java.util.ArrayList;

public class BusReserv {

	public static void main(String[] args) {
			try{
				BusDataAccessObject.displayBusInfo();
			
				int userOpt = 1;
				Scanner scanner = new Scanner(System.in);
			
				while(userOpt == 1) {
			
				System.out.println("Enter 1 to Book and 2 to Exit");
			
				userOpt = scanner.nextInt();
				
				if(userOpt == 1) {
					Booking booking = new Booking();
					
					if(booking.isAvailable()) {
						BookingDAO.addBooking(booking);
						System.out.println("Your Booking is Confirmed");
					}else
						System.out.println("Bus is full. Try another bus or date. \nThank You");
				}
			}
				scanner.close();
		}
			catch(Exception e) {
				System.out.println(e);
			}
  }
}	

