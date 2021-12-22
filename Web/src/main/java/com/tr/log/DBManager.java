package com.tr.log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// DB관련 작업을 할때 매번 연결코드 쓴 이후 작업 해옴

// 그걸 AOP 하자는거

public class DBManager {
	
	// db작업시엔 어쨋든 연결 해야됨
	public static Connection connect() throws SQLException {
				
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		return DriverManager.getConnection(url, "c##sr", "sr");
		
	}
	
	// 닫을게 많은데 한번에 닫기 
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		
		try {
			if(rs != null) {
				rs.close();				
			}
		} catch (SQLException e) {
		}
		try {
			pstmt.close();
		} catch (SQLException e) {
		}
		try {
			con.close();
		} catch (SQLException e) {
		}
	}
}
