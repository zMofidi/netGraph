package netGraph;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Entity_Manager {
	Connection load() {
		try {
			// Load JDBC driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// Make connection
			String url = "jdbc:mysql://127.0.0.1/netgraph?user=root&password=mofidi";
			Connection conn = DriverManager.getConnection(url);
			return conn;
		} catch (Exception e) {
			System.out.println("load exception " + e.getMessage());
			return null;
		}
	}

	void loadPages_toDB(String[] fileData) throws SQLException {
		Connection conn = load();
		
		for(int lineNum = 0; lineNum<5; lineNum++){
			String [] temp = fileData[lineNum].split(":");
			fileData[lineNum]=temp[1];
		}
		
		String loadPage = "insert into `page` value (?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(loadPage,PreparedStatement.RETURN_GENERATED_KEYS);
		
		pstmt.setString(1, fileData[0]);
		pstmt.setString(1, fileData[1]);
		pstmt.setInt(1, Integer.parseInt(fileData[2]));
		pstmt.setString(1, fileData[3]);
		pstmt.setString(1, fileData[4]);
		pstmt.executeUpdate();
	}

}
