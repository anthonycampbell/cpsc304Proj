package projectQueries;

import java.sql.SQLException;

public class Main { 

	public static void main(String[] args) {
		try {
			Database.init();
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}

		try {
			for (Passenger p : Database.getPassengersByFlightNumber("AC026")) {
				System.out.println("==========================");
				System.out.println(p.passport_num);
				System.out.println(p.name);
			}

			for (Airliner a : Database.getAirlinersByPassportNumber(950474950)) {
				System.out.println("==========================");
				System.out.println(a.ac_name);
				System.out.println(a.flightNumber);
				System.out.println(a.departureTime);
				System.out.println(a.arrivalTime);
				System.out.println(a.modelNumber);
				System.out.println(a.departureAirport);
				System.out.println(a.arrivalAirport);
			}

			for (AirlineCompany ac : Database.getAirlineCompanies()){
				System.out.println("==========================");
				System.out.println(ac.name);
				System.out.println(ac.location);
				Database.terminate();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
