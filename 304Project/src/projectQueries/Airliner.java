package projectQueries;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class Airliner {
	public final String flightNumber;
	public final String ac_name;
	public final Date departureTime;
	public final Date arrivalTime;
	public final String modelNumber;
	public final String departureAirport;
	public final String arrivalAirport;
	
	public Airliner(String flightNumber, String ac_name, Date departureTime, Date arrivalTime,
			String modelNumber, String departureAirport, String arrivalAirport){
		this.flightNumber = flightNumber;
		this.ac_name = ac_name;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.modelNumber = modelNumber;
		this.departureAirport = departureAirport;
		this.arrivalAirport = arrivalAirport;
	}
	/*
	public static List<Airliner> render(ResultSet rs) throws SQLException {
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
		rs.close();
		return airliners;
	}
	*/
	public String[] toArray() {
		String[] result = {
				flightNumber,
				ac_name, 
				departureTime.toString(), 
				arrivalTime.toString(),
				modelNumber, 
				departureAirport,
				arrivalAirport};
		return result;
	}
	
	public static String[][] render(ResultSet rs) throws SQLException {
		List<String[]> airliners = new ArrayList<>();
		while (rs.next()){
			String[] each = new String[7];
			each[0] = rs.getString("flight#");
			each[1] = rs.getString("ac_name");
			each[2] = rs.getDate("departure_time").toString();
			each[3] = rs.getDate("arrival_time").toString();
			each[4] = rs.getString("model#");
			each[5] = rs.getString("from_airport_code");
			each[6] = rs.getString("to_airport_code");
			airliners.add(each);
		}
		rs.close();
		return airliners.toArray(new String[0][]);
	}
	
}
