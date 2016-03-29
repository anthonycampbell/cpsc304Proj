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
			for (Passenger p : Database.retrievePassengers()) {
				System.out.println("==========================");
				System.out.println(p.passport_num);
				System.out.println(p.name);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
