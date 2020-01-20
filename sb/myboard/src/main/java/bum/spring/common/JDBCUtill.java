package bum.spring.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtill {
	
	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1", "genug", "genug");
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return null;
	}
	
	public static void close(PreparedStatement pstmt, Connection conn) {
		if(pstmt != null) try { if(!pstmt.isClosed()) pstmt.close(); }catch(SQLException e) {}finally { pstmt = null;}
		if(conn != null) try { if(!conn.isClosed()) conn.close(); }catch(SQLException e) {}finally { conn = null;}
	}
	public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if(rs != null) try { if(!rs.isClosed()) rs.close(); }catch(SQLException e) {}finally { rs = null;}
		if(pstmt != null) try { if(!pstmt.isClosed()) pstmt.close(); }catch(SQLException e) {}finally { pstmt = null;}
		if(conn != null) try { if(!conn.isClosed()) conn.close(); }catch(SQLException e) {}finally { conn = null;}
	}
}













