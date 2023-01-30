package com.iu.home.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {

	//getConnection
	public static Connection getConnection() throws Exception{ 
		//static 어디서든 사용 가능-객체 생성 없이(클래스에서 공통으로 사용해라) - 클래스 메서드다.
		//1. 연결 정보
		String user="user01" ;
		String password="user01";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String driver="oracle.jdbc.driver.OracleDriver";
		
		//2. Driver을 메모리에 로딩
		Class.forName(driver);
		
		//3. DB 연결
		return DriverManager.getConnection(url, user, password);
		
	}
	
	public static void disConnection(ResultSet rs, PreparedStatement st, Connection connection) throws Exception{
		rs.close();
		st.close();
		connection.close();
		
	}
	public static void disConnection(PreparedStatement st, Connection connection) throws Exception {
		st.close();
		connection.close();
	}
	
	
	//배포전 삭제하세요
//	public static void main(String[] args) {
//		//dbconnecton 사용시, 클래스명.메소드명 - 클래스메서드이기 때문
//		try {
//			Connection con =DBConnection.getConnection();
//			System.out.println(con !=null);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
}
