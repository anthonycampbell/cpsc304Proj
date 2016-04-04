package projectQueries;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Passenger {
	public final int passport_num;
	public final String name;
	
	public Passenger(int passport_num, String name) {
		this.passport_num = passport_num;
		this.name = name;
	}
	/*
	public static List<Passenger> render(ResultSet rs) throws SQLException {
		List<Passenger> list = new ArrayList<>();
		while (rs.next()) {
			Passenger p = new Passenger(rs.getInt(1), rs.getString(2));
			list.add(p);
		}
		rs.close();
		return list;
	}
	*/
	public static String[][] render(ResultSet rs) throws SQLException {
		List<String[]> passengers = new ArrayList<>();
		while (rs.next()){
			String[] each = new String[2];
			each[0] = Integer.toString(rs.getInt(1));
			each[1] = rs.getString(2);
			passengers.add(each);
		}
		rs.close();
		return passengers.toArray(new String[0][]);
	}
	
}
