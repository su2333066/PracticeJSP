package com.cha.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AddrDB {

	String url = "jdbc:mysql://localhost:3306/add?serverTimezone=UTC";
	String user = "root";
	String pass = "";
	String driver = "com.mysql.cj.jdbc.Driver";

	private Connection getConnection() {

		Connection conn = null;

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			System.out.println("Connection error");
		}

		return conn;

	}

	public ArrayList<Addr> selectDatas() {
		
		String sql = "SELECT * FROM addr"; 
		
		Connection conn = getConnection();
		
		ArrayList<Addr> addrList = new ArrayList<>();
		try {
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {							
				int idx = rs.getInt("idx");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				
				Addr addr = new Addr(idx, name, address, phone);
				addrList.add(addr);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return addrList;
	}

	public void insertData() {

		String sql = "INSERT INTO addr SET `name` = '홍길동', address = '대전', phone = '010-9999-8888'";

		Connection conn = getConnection();

		Statement stmt = null;

		try {

			stmt = conn.createStatement();
			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
