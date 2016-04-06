package projectQueries;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Database {
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
	
	// ========================== GET ===============================

	public static String[][] getPassengers() throws SQLException {
		ResultSet rs = statement.executeQuery("SELECT * FROM passengers");
		return Passenger.render(rs);
	}
	
	public static String[][] getPassengersByFlightNumber(String flightNumber) throws SQLException {
		ResultSet rs = statement.executeQuery(
				"SELECT * " +
				"FROM passengers, on_board " +
				"WHERE on_board.passport# = passengers.passport# " +
				"AND on_board.flight# = '" + flightNumber + "'");
		return Passenger.render(rs);
	}
	
	public static String[][] getAirliners() throws SQLException {
		String query = "SELECT * "
				+ "FROM airliner_oo1, airliner_oo2 "
				+ "WHERE airliner_oo1.flight# = airliner_oo2.flight# ";
		ResultSet rs = statement.executeQuery(query);
		return Airliner.render(rs);
	}
	
	public static String[][] getAirlinersByFromAirport(String airportCode) throws SQLException {
		String query = "SELECT * "
				+ "FROM airliner_oo1, airliner_oo2 "
				+ "WHERE airliner_oo1.flight# = airliner_oo2.flight# "
				+ "AND from_airport_code = '" + airportCode + "'";
		ResultSet rs = statement.executeQuery(query);
		return Airliner.render(rs);
	}
	
	public static String[][] getAirlinersByPassportNumber(int passport_num) throws SQLException {
		String query = "SELECT * "
				+ "FROM on_board, airliner_oo1, airliner_oo2 "                                                                        
				+ "WHERE on_board.flight# = airliner_oo1.flight# "
				+ "AND on_board.flight# = airliner_oo2.flight# "
				+ "AND on_board.passport# = " + passport_num;
		ResultSet rs = statement.executeQuery(query);
		return Airliner.render(rs);
	}

	public static String[][] getAirlineCompanies() throws SQLException{
		ResultSet rs = statement.executeQuery("SELECT * FROM airline_companies");
		return AirlineCompany.render(rs);
	}
	
	public static String[][] getAirAllianceByAirCompanyName(String ac_name) throws SQLException {
		String query = "SELECT * "
				+ "FROM member_companies "
				+ "WHERE ac_name = '" + ac_name + "'";
		ResultSet rs = statement.executeQuery(query);
		return AirAlliance.render(rs);
	}
	
	// =========================== INSERT ===========================
	
	public static void insert(Airliner a) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("INSERT INTO airliner_oo1 VALUES (?, ?, ?, ?, ?)");
		ps.setString(1, a.flightNumber);
		ps.setString(2, a.ac_name);
		ps.setString(3, a.arrivalAirport);
		ps.setString(4, a.departureAirport);
		ps.setString(5, a.modelNumber);
		ps.executeUpdate();
		
		ps = connection.prepareStatement("INSERT INTO airliner_oo2 VALUES (?, ?, ?)");
		ps.setString(1, a.flightNumber);
		ps.setDate(2, a.departureTime);
		ps.setDate(3, a.arrivalTime);
		ps.executeUpdate();
		
		ps.close();
	}
	
	// ============================= DELETE ===========================
	
	public static void delete(String flightNumber, Date departureTime) throws SQLException {
		statement.executeUpdate("DELETE FROM airliner_oo1 " +
				"WHERE flight# = '" + flightNumber + "'");
		PreparedStatement ps = connection.prepareStatement("DELETE FROM airliner_oo2 " +
				"WHERE flight# = '" + flightNumber + "' AND departure_time = ?");
		ps.setDate(1, departureTime);
		ps.executeUpdate();
		ps.close();
	}
	
	// =============================== COUNT ============================
	public static int countFlightNumber(int passportNum) throws SQLException {
		String query = "SELECT COUNT(*) "
				+ "FROM on_board, airliner_oo1, airliner_oo2 "                                                                        
				+ "WHERE on_board.flight# = airliner_oo1.flight# "
				+ "AND on_board.flight# = airliner_oo2.flight# "
				+ "AND on_board.passport# = " + passportNum;
		ResultSet rs = statement.executeQuery(query);
		rs.next();
		return rs.getInt(1);
	}
	/*
	public static String findMostFlightCompany() {
		String query = "SELECT COUNT(*) "
				+ "FROM airliner_oo1, airliner_oo2 "
				+ "WHERE airliner_oo1.flight# = airliner_oo2.flight# "
				+ "GROUP BY airliner_oo1.ac_name";
		ResultSet rs = statement.executeQuery(query);
		rs.next();
		return rs.getInt(1);
	}
*/
	public static String[][] findFrequentTraveller() throws SQLException {
		String query = "SELECT * "
				+ "FROM passengers "
				+ "WHERE NOT EXISTS ((SELECT ac_name "
				+ "FROM airline_companies) "
				+ "minus "
				+ "(SELECT airliner_oo1.ac_name "
				+ "FROM airliner_oo1, on_board "
				+ "WHERE on_board.passport# = passengers.passport# "
				+ "AND on_board.flight# = airliner_oo1.flight#";
		ResultSet rs = statement.executeQuery(query);
		return Passenger.render(rs);
	}
}
