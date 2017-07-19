package com.predix.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;

import com.google.gson.JsonObject;
import com.predix.datasource.Query;
import com.predix.datasource.QueryInteractor;
//import com.predix.model.Company;

public class TableDataOperations {

	QueryInteractor qi = null;
	
// 	public String createTable() {
//		
//		try {
//			qi = new QueryInteractor();
//			qi.executeUpdateQuery(Query.CREATE_AGRO);
//			
//			return "Table created successfully";
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
 	
 	public String insertGyro(HashMap values) {
 		
 		try {
 			qi = new QueryInteractor();
 			qi.getArrayList(Query.INSERT_GYRO, values);
 			
 			return "Data saved successfully";
 		} catch(Exception e) {
 			e.printStackTrace();
 		}
 		return null;
 	}
 	
 	public String insertAccel(HashMap values) {
 		
 		try {
 			qi = new QueryInteractor();
 			qi.getArrayList(Query.INSERT_ACCEL, values);
 			
 			return "Data saved successfully";
 		} catch(Exception e) {
 			e.printStackTrace();
 		}
 		return null;
 	}
 	
 	public String saveLatlong(HashMap values) {
 		
 		try {
 			qi = new QueryInteractor();
 			qi.getArrayList(Query.INSERT_LAT_LONG, values);
 			
 			return "SUCCESS";
 		} catch(Exception e) {
 			e.printStackTrace();
 		}
 		return null;
 	}

 	public String updateDataTable(HashMap values) {
 		
 		try {
 			qi = new QueryInteractor();
 			qi.getArrayList(Query.UPDATE_AGRO, values);
 			
 			return "Data saved successfully";
 		} catch(Exception e) {
 			e.printStackTrace();
 		}
 		return null;
 	}
 	
 	public String viewData() {
 		
 		try {
 			qi = new QueryInteractor();
 			List<Object> listObject = qi.getList(Query.VIEW_GYRO);
 			
 			Object[] obj = (Object[])listObject.get(1);
 			System.out.println(obj[0].toString()+ ","+obj[1].toString()+ "," + obj[2].toString() + "--" + obj.length);
 			return obj[0].toString();
 			
 		} catch(Exception e) {
 			e.printStackTrace();
 		}
 		return null;
 	}
 	
 	public JSONArray getLatLongValMultiple(HashMap values) {
 		try {
 			qi = new QueryInteractor();
 			List<Object> listObject = qi.getArrayListOnIn(Query.VIEW_LAT_LONG_MULTIPLE, values);
 			
 			int listSize = listObject.size();
 			
 			JSONArray jsonarray = new JSONArray();
 			JSONArray jsonarraySub;
 			for(int k=1; k<listSize; k++) {
 				jsonarraySub = new JSONArray();
 				 
 				Object[] obj = (Object[])listObject.get(k);
 				jsonarraySub.put(new Double(obj[0].toString()));
 				jsonarraySub.put(new Double(obj[1].toString()));
 				
 				jsonarray.put(jsonarraySub);
 				
 			}
 			return jsonarray;
 			
 		} catch(Exception e) {
 			e.printStackTrace();
 		}
 		return null;
 	}
		
 	public JSONArray getLatLongVal() {
 		
 		try {
 			JSONArray jsonarray = new JSONArray();
 			qi = new QueryInteractor();
 			List<Object> listObjectGyro = qi.getList(Query.VIEW_LAT_LONG);
 			
 			Object[] obj = (Object[])listObjectGyro.get(1);
 			jsonarray.put(new Double(obj[0].toString()));
 			jsonarray.put(new Double(obj[1].toString()));
 			
 			return jsonarray;
 			
 		} catch(Exception e) {
 			e.printStackTrace();
 		}
 		return null;
 	}

 	public JSONArray mergeAccelGyro() {
 		
 		try {
 			qi = new QueryInteractor();
 			List<Object> listObjectGyro = qi.getList(Query.VIEW_GYRO);
 			
 			List<Object> listObjectAccel = qi.getList(Query.VIEW_ACCEL);
 			
 			JSONArray jsonarray = new JSONArray();
 			JSONArray jsonarraySub;
 			for(int k=1; k<listObjectAccel.size(); k++) {
 				 jsonarraySub = new JSONArray();
 				 
 				Object[] obj = (Object[])listObjectAccel.get(k);
 				jsonarraySub.put(new Double(obj[0].toString()));
 				jsonarraySub.put(new Double(obj[1].toString()));
 				jsonarraySub.put(new Double(obj[2].toString()));
 				
 				Object[] obj1 = (Object[])listObjectGyro.get(k);
 				jsonarraySub.put(new Double(obj1[0].toString()));
 				jsonarraySub.put(new Double(obj1[1].toString()));
 				jsonarraySub.put(new Double(obj1[2].toString()));
 				
 				jsonarray.put(jsonarraySub);
 				
 			}
// 			Object[] obj = (Object[])listObject.get(1);
// 			System.out.println(obj[0].toString()+ ","+obj[1].toString()+ "," + obj[2].toString() + "--" + obj.length);
 			return jsonarray;
 			
 		} catch(Exception e) {
 			e.printStackTrace();
 		}
 		return null;
 	}
//	public static void main(String args[]) {
//		
//		TableDataOperations tdo = new TableDataOperations();
//		
//		//tdo.createTable();
//		HashMap<Integer, String> hm = new HashMap<Integer, String>();
//		
//		hm.put(new Integer(1), "3.253813693");
//		hm.put(new Integer(2), "3.2358969");
//		hm.put(new Integer(3), "3.258963");
//		hm.put(new Integer(4), new Timestamp(new Date().getTime()).toString());
//		//hm.put(new Integer(5), "1");
//		
//		
//		for(int i=0; i<4; i++)
//		//tdo.insertGyro(hm);
//		//tdo.viewData();
//			System.out.println(tdo.mergeAccelGyro());
//		
//	}
}
