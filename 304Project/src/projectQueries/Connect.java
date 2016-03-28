package projectQueries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect { 
	Connection con = null;
	public Connect(String username,String password) throws SQLException{
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		this.con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1522:ug", username, password);
		con.setAutoCommit(false);
	}
	
	public Connection getCon(){
		return this.con;
	}
	
}
