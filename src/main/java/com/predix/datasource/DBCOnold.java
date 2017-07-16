//package com.predix.datasource;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.Properties;
//
//import org.apache.log4j.Logger;
//
//public class DBConnectionManager {
//
//	Properties props = new Properties();
//	Connection con = null;
//
//	String CLASS_NAME = this.getClass().getName();
//	Logger logger = Logger.getLogger(CLASS_NAME);
//
//	public Connection getConnection() {
//		try {
//	        Class.forName("com.mysql.jdbc.Driver");
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","root");
//			if (con != null) {
//				logger.info("Connection created Successfully !");
//				System.out.println("Connection created Successfully !");
//			} 
//		} catch (SQLException e) {
//			e.printStackTrace();
//			logger.error(e.getMessage());
//		} catch (Exception e) {
//			e.printStackTrace();
//			logger.error(e.getMessage());
//		}
//		return con;
//	}
//	
//	
////	public static void main(String args[]) {
////		DBConnectionManager dbc = new DBConnectionManager();
////		dbc.getConnection();
////	}
//}