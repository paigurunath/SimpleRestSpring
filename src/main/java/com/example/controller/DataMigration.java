package com.example.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;

import org.json.JSONArray;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.predix.dao.TableDataOperations;

@CrossOrigin
@RestController
@EnableAutoConfiguration
public class DataMigration {

	TableDataOperations tdo = new TableDataOperations();
	
//	@RequestMapping("/")
//	String home() throws IOException {
//		
//		/*Vcapenv vcapenv = new Vcapenv();
//		String sendgrid_username = vcapenv.SENDGRID_USERNAME();
//		String sendgrid_password = vcapenv.SENDGRID_PASSWORD();*/
//		
//		Email from = new Email("pai.gurunath@gmail.com");
//	    String subject = "Hello World from the SendGrid Java Library!";
//	    Email to = new Email("m.gurunathpai@gmail.com");
//	    Content content = new Content("text/plain", "Hello, Email!");
//	    Mail mail = new Mail(from, subject, to, content);
//
//	    SendGrid sg = new SendGrid("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");
//	    Request request = new Request();
//	    try {
//	      request.method = Method.POST;
//	      request.endpoint = "mail/send";
//	      request.body = mail.build();
//	      Response response = sg.api(request);
//	      System.out.println(response.statusCode);
//	      System.out.println(response.body);
//	      System.out.println(response.headers);
//	    } catch (IOException ex) {
//	      throw ex;
//	    }
//		return "Hello World Gurunath from Cloud Foundry : m.gurunathpai!";
//	}

	@RequestMapping("/")
	String home1() {
		return "Hello World Gurunath from Cloud Foundry : m.gurunathpai!";
	}
	@RequestMapping(value="/readUrl", method=RequestMethod.POST)
	public String readUrl(@RequestBody JsonNode jsonNode ) {
		try {
			System.out.println(jsonNode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "SUCCESS";
	}
	
	@RequestMapping(value="/accel", method=RequestMethod.POST)
	public String saveAccelData(@RequestBody JsonNode jsonNode ) {
		try {
			System.out.println("accel data : " + jsonNode);
			HashMap<Integer, String> hm = new HashMap<Integer, String>();
			hm.put(new Integer(1), jsonNode.get("accelx").toString());
			hm.put(new Integer(2), jsonNode.get("accely").toString());
			hm.put(new Integer(3), jsonNode.get("accelz").toString());
			hm.put(new Integer(4), new Timestamp(new Date().getTime()).toString());
			tdo.insertAccel(hm);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "SUCCESS";
	}
	
	@RequestMapping(value="/gyro", method=RequestMethod.POST)
	public String saveGyroData(@RequestBody JsonNode jsonNode ) {
		try {
			System.out.println("gyro data : " + jsonNode);
			HashMap<Integer, String> hm = new HashMap<Integer, String>();
			hm.put(new Integer(1), jsonNode.get("gyrox").toString());
			hm.put(new Integer(2), jsonNode.get("gyroy").toString());
			hm.put(new Integer(3), jsonNode.get("gyroz").toString());
			hm.put(new Integer(4), new Timestamp(new Date().getTime()).toString());
			tdo.insertGyro(hm);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "SUCCESS";
	}
	
	@RequestMapping(value="/saveLatLong", method=RequestMethod.POST)
	public String saveLatLong(@RequestBody JsonNode jsonNode ) {
		try {
			System.out.println("lat long : " + jsonNode);
			HashMap<Integer, String> hm = new HashMap<Integer, String>();
			hm.put(new Integer(1), jsonNode.get("latval").toString());
			hm.put(new Integer(2), jsonNode.get("longval").toString());
			hm.put(new Integer(3), new Timestamp(new Date().getTime()).toString());
			tdo.saveLatlong(hm);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "SUCCESS";
	}
	
	@RequestMapping(value="/getLatLong", method=RequestMethod.GET)
	public @ResponseBody String getLatLong() {
		try {
			return tdo.getLatLongVal().toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value="/getLatLongMultiple", method=RequestMethod.POST)
	public @ResponseBody String getLatLongMultiple(@RequestBody JsonNode jsonNode) {
		try {
			System.out.println("lat long : " + jsonNode);
			HashMap<Integer, String> hm = new HashMap<Integer, String>();
			hm.put(new Integer(1), jsonNode.get("limit").toString());
			
			return tdo.getLatLongValMultiple(hm).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value="/getGyroAccel", method=RequestMethod.GET)
	public @ResponseBody String getAccelGyroData() {
		try {
			return tdo.mergeAccelGyro().toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
//	@RequestMapping(value="/readUrlString", method=RequestMethod.POST)
//	public String readUrlString(@RequestBody String jsonNode ) {
//		try {
//			
//			String responseStr = "";
//			System.out.println("before creating the http request");
//			String GET_URL = "http://mailtest.cfapps.io";
//		    URL obj = new URL(GET_URL);
//	        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//	        con.setRequestMethod("GET");
//	      //  con.setRequestProperty("User-Agent", USER_AGENT);
//	        int responseCode = con.getResponseCode();
//	        System.out.println("GET Response Code :: " + responseCode);
//	        if (responseCode == HttpURLConnection.HTTP_OK) { // success
//	            BufferedReader in = new BufferedReader(new InputStreamReader(
//	                    con.getInputStream()));
//	            String inputLine;
//	            StringBuffer response = new StringBuffer();
//	 
//	            while ((inputLine = in.readLine()) != null) {
//	                response.append(inputLine);
//	            }
//	            in.close();
//	 
//	            // print result
//	            System.out.println("------------------------------------------------------------------------------------");
//	            responseStr = response.toString();
//	            System.out.println(responseStr);
//	            
//	            System.out.println("------------------------------------------------------------------------------------");
//	        }
//	        
//	        /*
//			Object things = new Gson().fromJson(responseStr, Object.class);
//		    List keys = new ArrayList();
//		    collectAllTheKeys(keys, things);
//		    
//		    Iterator iter1 = keys.listIterator();
//		    
//		    while(iter1.hasNext()) {
//		    	System.out.println(iter1.next());
//		    }
//*/		    System.out.println("all done and executed");
//			System.out.println(responseStr);
//		    return "completed success";
//		} catch(com.google.gson.JsonParseException e) {
//			e.printStackTrace();
//			return "String parsing failed";
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return "SUCCESS";
//	}
//	
//	
//	void collectAllTheKeys(List keys, Object o)
//	  {
//	    Collection values = null;
//	    if (o instanceof Map)
//	    {
//	      Map map = (Map) o;
//	      keys.addAll(map.keySet()); // collect keys at current level in hierarchy
//	      values = map.values();
//	    }
//	    else if (o instanceof Collection)
//	      values = (Collection) o;
//	    else // nothing further to collect keys from
//	      return;
//
//	    for (Object value : values)
//	      collectAllTheKeys(keys, value);
//	  }
}
