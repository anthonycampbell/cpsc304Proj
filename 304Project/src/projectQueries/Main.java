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
			String[][] arr = Database.getAirAllianceByAirCompanyName("Air Canada");
			printArray(arr);
			/*
			arr = Database.getAirliners();
			printArray(arr);
			//System.out.println( " has taken " + count + " flights");
			/*
			for (Passenger p : Database.getPassengersByFlightNumber("AC026")) {
				System.out.println("==========================");
				System.out.println(p.passport_num);
				System.out.println(p.name);
			}
			*/
/*
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
*/
			/*
			Airliner a = new Airliner("AC011", "Air Canada", Date.valueOf("2016-03-11"), Date.valueOf("2016-03-12"), "aaa", "PVG", "YVR");
			Database.insert(a);
			String[][] arr = Database.getAirliners();
			printArray(arr);
			*/
			/*
			for (AirlineCompany ac : Database.getAirlineCompanies()){
				System.out.println("==========================");
				System.out.println(ac.name);
				System.out.println(ac.location);
			}
			
			for (AirAlliance aa : Database.getAirAllianceByAirCompanyName("Korean Air")) {
				System.out.println("==========================");
				System.out.println(aa.name);
			}
			*/
			/*
			long time = System.currentTimeMillis();
			Date d = new Date(time);
			Date d2 = new Date(time + 60 * 60 * 1000);
			Airliner a = new Airliner("A000", "Air China", d, d2, "Death 777", "PEK", "ICN");
			Database.insert(a);
			Database.delete(a);
			*/
			Database.terminate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("abc");
			e.printStackTrace();
		}

	}
	
	public static void printArray(String[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println("==========================");
			for (int j = 0; j < arr[0].length; j++) {
				System.out.println(arr[i][j]);
			}
		}
	}

}
