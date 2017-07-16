package com.predix.datasource;

public class Query {

	public static String CREATE_AGRO = "CREATE TABLE  IF NOT EXISTS  agro  (appname text not null,status TEXT NOT NULL, primary key (appname))";
	
	public static String UPDATE_AGRO = "UPDATE agro SET status = ? where appname = ?";
	public static String VIEW_AGRO = "SELECT status, appname FROM AGRO where appname=?";
	
	public static String INSERT_DOCTOR = "INSERT INTO public.app_user (name,type) VALUES (?,?)";
	public static String INSERT_APPOINTMENT = "INSERT INTO app_appointment (doctor,intime,outime,patientname) VALUES (?,?,?,?)";
	public static String VIEW_APPOINTMENT_BY_DATE = "";
	
	public static String INSERT_GYRO = "INSERT INTO gyro (gx,gy,gz,createdat) VALUES (?,?,?,?)";
	public static String INSERT_ACCEL = "INSERT INTO accel (ax,ay,az,createdat) VALUES (?,?,?,?)";
	
	public static String VIEW_GYRO = "SELECT gx, gy, gz FROM gyro ORDER BY createdat desc LIMIT 8";
	public static String VIEW_ACCEL = "SELECT ax, ay, az FROM accel ORDER BY createdat desc LIMIT 8";
//	public static String INSERT_GYRO = "INSERT INTO gyro (gx,gy,gz,createdat) VALUES (?,?,?,TIMESTAMP())";
}
