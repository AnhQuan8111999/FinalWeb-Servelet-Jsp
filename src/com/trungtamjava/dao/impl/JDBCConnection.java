package com.trungtamjava.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnection {
	public Connection getConnection() {
		final String username = "root";
		final String password = "";
		final String url = "jdbc:mysql://localhost:3306/finalweb10";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			System.out.println("Ket noi failed " + e);
		}
		
		return null; 
	}
	
	public static void main(String[] args) {
		JDBCConnection jdbc = new JDBCConnection();
		Connection conn = jdbc.getConnection();
		if (conn == null) {
			System.out.println("THAT BAI");
		} else {
			System.out.println("THANH CONG");
		}
	}
}
