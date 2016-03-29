package projectQueries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Database {
	private static Database instance;

	private static Connection connection;
	private static final String username = "ora_d8x8";
	private static final String password = "a42701136";

	private Database() {}

	public static void init() throws SQLException {
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:ug", username, password);
		connection.setAutoCommit(false);
	}

	public static List<Passenger> getPassengers() throws SQLException {
		Statement s = connection.createStatement();
		ResultSet rs = s.executeQuery("SELECT * FROM passengers");
		List<Passenger> list = new ArrayList<>();
		while (rs.next()) {
			Passenger p = new Passenger(rs.getInt(1),
					rs.getString(2));
			list.add(p);
		}
		s.close();
		return list;
	}
	
	public static List<AirlineCompany> getAirlineCompanies() throws SQLException{
		Statement s = connection.createStatement();
		ResultSet rs = s.executeQuery("SELECT * FROM airline_companies");
		List<AirlineCompany> airlineCompanies = new ArrayList<>();
		while(rs.next()){
			String name = rs.getString("ac_name");
			String location = rs.getString("location");
			AirlineCompany ac = new AirlineCompany(name, location);
			airlineCompanies.add(ac);
		}
		s.close();
		return airlineCompanies;
	}
	
	public static List<Airliner> getAirliners() throws SQLException{
		List<Airliner> airliners = new ArrayList<>();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(""
				+ "SELECT * "
				+ "FROM airliner_oo1, airliner_oo2 "
				+ "WHERE airliner_oo1.flight# = airliner_oo2.flight#");
		while (rs.next()){
			String flightNumber = rs.getString("flight#");
			String ac_name = rs.getString("ac_name");
			Date departureTime = rs.getDate("departure_time");
			Date arrivalTime = rs.getDate("arrival_time");
			String modelNumber = rs.getString("model#");
			String departureAirport = rs.getString("from_airport_code");
			String arrivalAirport = rs.getString("to_airport_code");
			airliners.add(new Airliner(flightNumber, ac_name, departureTime, arrivalTime, modelNumber,
					departureAirport, arrivalAirport));
		}
		stmt.close();
		return airliners;	
	}

}
