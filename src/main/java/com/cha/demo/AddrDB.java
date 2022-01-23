package com.cha.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AddrDB {

	// JDBC
	// 1. DBMS 접속정보 세팅

	// DBMS 주소
	String url = "jdbc:mysql://localhost:3306/add?serverTimezone=UTC";
	// 인증정보
	String user = "root";
	String pass = "";

	// 드라이버 정보(자바 클래스)
	String driver = "com.mysql.cj.jdbc.Driver"; // 다운로드 받아야 함.

	private Connection getConnection() {

		Connection conn = null;

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			System.out.println("Connection 가져오는 중 문제 발생");
		}

		return conn;

	}

	public ArrayList<Addr> selectDatas() {
		
		
		// 1. 하고 싶은 sql 문자열로 작성
		String sql = "SELECT * FROM addr"; 
		
		// Connection이 필요.
		Connection conn = getConnection();
		
		ArrayList<Addr> addrList = new ArrayList<>();
		try {
			// Statement가 필요.
			Statement stmt = conn.createStatement();
			
			// sql 전달 결과 ResultSet 반환.
			ResultSet rs = stmt.executeQuery(sql);
			
			// 주소록 데이터를 구조화한 후에
			// ArrayList 담아서 사용.
			while(rs.next()) {							
				int idx = rs.getInt("idx"); // 현재 가리키는 행의 idx 컬럼값을 int 반환
				String name = rs.getString("name"); // 현재 가리키는 행의 name 컬럼값을 String 반환
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				
				Addr addr = new Addr(idx, name, address, phone);
				addrList.add(addr);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return addrList;
	}

	// 데이터를 DB에 저장하는 메서드
	public void insertData(String name, String address, String phone) {

		String sql = String.format("INSERT INTO addr SET `name` = '%s', address = '%s', phone = '%s'", name, address, phone);
		Connection conn = getConnection();

		// Statement -> sql을 넘겨주고 결과 받아오는 역할
		Statement stmt = null;

		try {

			stmt = conn.createStatement();
			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}