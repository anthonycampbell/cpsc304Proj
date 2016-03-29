package projectQueries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class AirlinerQuery {
	
	public Airliner[] getAirlinerAttributes() throws SQLException{
		Airliner[] airliners = new Airliner[10];
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1522:ug", "ora_o3f9", "a76845106");
		con.setAutoCommit(false);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(""
				+ "SELECT * "
				+ "FROM airliner_oo1, airliner_oo2,"
				+ "WHERE airliner_oo1.flight# = airliner_oo2.flight#");
		while (rs.next()){
			int index = 0;
			String flightNumber = rs.getString("flight#");
			Date departureTime = rs.getDate("departure_time#");
			Date arrivalTime = rs.getDate("arrival_time#");
			String modelNumber = rs.getString("model#");
			String departureAirport = rs.getString("from_airport_code#");
			String arrivalAirport = rs.getString("to_airport_code#");
			airliners[index]= new Airliner(flightNumber, departureTime, arrivalTime, modelNumber,
					departureAirport, arrivalAirport);
			index++;
		}
		return airliners;
		
	}
}
