package projectQueries;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirAlliance {
	public final String name;
	
	public AirAlliance(String name) {
		this.name = name;
	}
	/*
	public static List<AirAlliance> render(ResultSet rs) throws SQLException {
		List<AirAlliance> list = new ArrayList<>();
		while(rs.next()){
			list.add(new AirAlliance(rs.getString("aa_name")));
		}
		rs.close();
		return list;
	}
	*/
	public static String[][] render(ResultSet rs) throws SQLException {
		List<String[]> alliances = new ArrayList<>();
		while (rs.next()){
			String[] each = new String[1];
			each[0] = rs.getString(1);
			alliances.add(each);
		}
		rs.close();
		return alliances.toArray(new String[0][]);
	}
}
