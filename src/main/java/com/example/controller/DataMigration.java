package com.example.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

@RestController
@EnableAutoConfiguration
public class DataMigration {

	@RequestMapping("/")
	String home() throws IOException {
		
		/*Vcapenv vcapenv = new Vcapenv();
		String sendgrid_username = vcapenv.SENDGRID_USERNAME();
		String sendgrid_password = vcapenv.SENDGRID_PASSWORD();*/
		
		Email from = new Email("pai.gurunath@gmail.com");
	    String subject = "Hello World from the SendGrid Java Library!";
	    Email to = new Email("m.gurunathpai@gmail.com");
	    Content content = new Content("text/plain", "Hello, Email!");
	    Mail mail = new Mail(from, subject, to, content);

	    SendGrid sg = new SendGrid("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");
	    Request request = new Request();
	    try {
	      request.method = Method.POST;
	      request.endpoint = "mail/send";
	      request.body = mail.build();
	      Response response = sg.api(request);
	      System.out.println(response.statusCode);
	      System.out.println(response.body);
	      System.out.println(response.headers);
	    } catch (IOException ex) {
	      throw ex;
	    }
		return "Hello World Gurunath from Cloud Foundry : m.gurunathpai!";
	}

	@RequestMapping("/test")
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
	
	@RequestMapping(value="/readUrlString", method=RequestMethod.POST)
	public String readUrlString(@RequestBody String jsonNode ) {
		try {
			
			String responseStr = "";
			System.out.println("before creating the http request");
			String GET_URL = "http://mailtest.cfapps.io";
		    URL obj = new URL(GET_URL);
	        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	        con.setRequestMethod("GET");
	      //  con.setRequestProperty("User-Agent", USER_AGENT);
	        int responseCode = con.getResponseCode();
	        System.out.println("GET Response Code :: " + responseCode);
	        if (responseCode == HttpURLConnection.HTTP_OK) { // success
	            BufferedReader in = new BufferedReader(new InputStreamReader(
	                    con.getInputStream()));
	            String inputLine;
	            StringBuffer response = new StringBuffer();
	 
	            while ((inputLine = in.readLine()) != null) {
	                response.append(inputLine);
	            }
	            in.close();
	 
	            // print result
	            System.out.println("------------------------------------------------------------------------------------");
	            responseStr = response.toString();
	            System.out.println(responseStr);
	            
	            System.out.println("------------------------------------------------------------------------------------");
	        }
	        
	        /*
			Object things = new Gson().fromJson(responseStr, Object.class);
		    List keys = new ArrayList();
		    collectAllTheKeys(keys, things);
		    
		    Iterator iter1 = keys.listIterator();
		    
		    while(iter1.hasNext()) {
		    	System.out.println(iter1.next());
		    }
*/		    System.out.println("all done and executed");
			System.out.println(responseStr);
		    return "completed success";
		} catch(com.google.gson.JsonParseException e) {
			e.printStackTrace();
			return "String parsing failed";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "SUCCESS";
	}
	
	@RequestMapping(value="/gyro", method=RequestMethod.POST)
	public String saveGyroData(@RequestBody String jsonNode ) {
		try {
//	        
//			Object things = new Gson().fromJson(responseStr, Object.class);
//		    List keys = new ArrayList();
//		    collectAllTheKeys(keys, things);
//		    
//		    Iterator iter1 = keys.listIterator();
//		    
//		    while(iter1.hasNext()) {
//		    	System.out.println(iter1.next());
//		    }
//		    System.out.println("all done and executed");
			System.out.println("value from sensor : " + jsonNode);
//		    return "completed success";
		} catch(com.google.gson.JsonParseException e) {
			e.printStackTrace();
			return "String parsing failed";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "SUCCESS";
	}
	
	void collectAllTheKeys(List keys, Object o)
	  {
	    Collection values = null;
	    if (o instanceof Map)
	    {
	      Map map = (Map) o;
	      keys.addAll(map.keySet()); // collect keys at current level in hierarchy
	      values = map.values();
	    }
	    else if (o instanceof Collection)
	      values = (Collection) o;
	    else // nothing further to collect keys from
	      return;

	    for (Object value : values)
	      collectAllTheKeys(keys, value);
	  }
}
