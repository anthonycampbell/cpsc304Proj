package projectQueries;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirlineCompany {
	public final String name;
	public final String location;
	
	public AirlineCompany(String name, String location){
		this.name = name;
		this.location = location;
	}
/*
	public static List<AirlineCompany> render(ResultSet rs) throws SQLException {
		List<AirlineCompany> airlineCompanies = new ArrayList<>();
		while(rs.next()){
			String name = rs.getString("ac_name");
			String location = rs.getString("location");
			AirlineCompany ac = new AirlineCompany(name, location);
			airlineCompanies.add(ac);
		}
		rs.close();
		return airlineCompanies;
	}
	*/
	
	public static String[][] render(ResultSet rs) throws SQLException {
		List<String[]> companies = new ArrayList<>();
		while (rs.next()){
			String[] each = new String[2];
			each[0] = rs.getString("ac_name");
			each[1] = rs.getString("location");
			companies.add(each);
		}
		rs.close();
		return companies.toArray(new String[0][]);
	}
}
