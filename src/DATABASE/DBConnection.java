package DATABASE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
	static final String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static final String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=Book";
	static final String userName="sa";
	static final String userPwd="jiang1689";
	
	static{
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		try {
			return DriverManager.getConnection(dbURL,userName,userPwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static void closeConnection(Connection dbConn,PreparedStatement pstmt,ResultSet rs){
		try {
			dbConn.close();
			pstmt.close();
			if(rs != null) rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void closeConnection(Connection dbConn,PreparedStatement pstmt){
		closeConnection(dbConn,pstmt,null);
	}
}













