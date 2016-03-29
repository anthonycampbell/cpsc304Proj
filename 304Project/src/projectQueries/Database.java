package projectQueries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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

	public static List<Passenger> retrievePassengers() throws SQLException {
		Statement s = connection.createStatement();
		ResultSet rs = s.executeQuery("SELECT * FROM passengers");
		List<Passenger> list = new ArrayList<>();
		while (rs.next()) {
			Passenger p = new Passenger(rs.getInt(1),
					rs.getString(2));
			list.add(p);
		}
		return list;
	}

}
