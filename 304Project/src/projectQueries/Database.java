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
	private static Statement statement;
	private static final String username = "ora_d8x8";
	private static final String password = "a42701136";

	private Database() {}

	public static void init() throws SQLException {
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:ug", username, password);
		connection.setAutoCommit(false);
		statement = connection.createStatement();
	}
	
	public static void terminate() throws SQLException {
		statement.close();
		connection.close();
	}

	public static List<Passenger> getPassengers() throws SQLException {
		ResultSet rs = statement.executeQuery("SELECT * FROM passengers");
		return renderPassengers(rs);
	}
	
	public static List<Passenger> getPassengersByFlightNumber(String flightNumber) throws SQLException {
		ResultSet rs = statement.executeQuery(
				"SELECT * " +
				"FROM passengers, on_board " +
				"WHERE on_board.passport# = passengers.passport# " +
				"AND on_board.flight# = '" + flightNumber + "'");
		return renderPassengers(rs);
	}
	
	public static List<Airliner> getAirliners() throws SQLException {
		String query = "SELECT * "
				+ "FROM airliner_oo1, airliner_oo2 "
				+ "WHERE airliner_oo1.flight# = airliner_oo2.flight# ";
		ResultSet rs = statement.executeQuery(query);
		return renderAirliners(rs);	
	}
	
	// if airportCode is null, return ALL airliners
	public static List<Airliner> getAirlinersByFromAirport(String airportCode) throws SQLException {
		String query = "SELECT * "
				+ "FROM airliner_oo1, airliner_oo2 "
				+ "WHERE airliner_oo1.flight# = airliner_oo2.flight# ";
		if (airportCode != null) {
			query += "AND from_airport_code = '" + airportCode + "'";
		}
		ResultSet rs = statement.executeQuery(query);
		return renderAirliners(rs);	
	}
	
	public static List<Airliner> getAirlinersByPassportNumber(int passport_num) throws SQLException {
		String query = "SELECT * "
				+ "FROM on_board, airliner_oo1, airliner_oo2 "                                                                        
				+ "WHERE on_board.flight# = airliner_oo1.flight# "
				+ "AND on_board.flight# = airliner_oo2.flight# "
				+ "AND on_board.passport# = " + passport_num;
		ResultSet rs = statement.executeQuery(query);
		return renderAirliners(rs);
	}
	
	// ======================== HELPERS ============================= // 
	
	private static List<Airliner> renderAirliners(ResultSet rs) throws SQLException {
		List<Airliner> airliners = new ArrayList<>();
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
		return airliners;
	}
	
	private static List<Passenger> renderPassengers(ResultSet rs) throws SQLException {
		List<Passenger> list = new ArrayList<>();
		while (rs.next()) {
			Passenger p = new Passenger(rs.getInt(1),
					rs.getString(2));
			list.add(p);
		}
		return list;
	}

}
