package projectQueries;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberCompany {
	public final String aa_name;
	public final String ac_name;
	
	public MemberCompany(String aa_name, String ac_name) {
		this.aa_name = aa_name;
		this.ac_name = ac_name;
	}
	
	public static String[][] render(ResultSet rs) throws SQLException {
		List<String[]> members = new ArrayList<>();
		while (rs.next()){
			String[] each = new String[2];
			each[0] = rs.getString(1);
			each[1] = rs.getString(2);
			members.add(each);
		}
		rs.close();
		return members.toArray(new String[0][]);
	}

}
