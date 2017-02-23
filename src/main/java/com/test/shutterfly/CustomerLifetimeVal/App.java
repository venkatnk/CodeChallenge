package com.test.shutterfly.CustomerLifetimeVal;

/**
 * Author: venkat n k
 *
 */

import java.io.BufferedWriter;
import java.io.FileWriter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.test.shutterfly.CustomerLifetimeVal.DAO.*;

public class App 
{
	private static final String FILENAME = "input/input.txt";
	private static HashMap<String, Customer> customersMap;
	private static HashMap<String, Order> ordersMap;
	private static HashMap<String, SiteVisit> siteVisitMap;
	private static HashMap<String, ImageUpload> imageUploadMap;
//	private static HashMap<String, String> tagsMap;
	private static HashMap<String, Double> resultsMap;
	private static BufferedWriter bw = null;
	private static FileWriter fw = null;
	private static DateTimeFormatter dtf = DateTimeFormat.forPattern("YYYY-MM-dd:HH:mm:ss.SSSZ");
    public static void main( String[] args )
    {

//      System.out.println( "Hello World!" );
  	customersMap = new HashMap<String, Customer>();
  	ordersMap = new HashMap<String, Order>();
  	siteVisitMap = new HashMap<String, SiteVisit>();
  	imageUploadMap= new HashMap<String, ImageUpload>();
  	resultsMap= new HashMap<String, Double>();
  	 try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {

			String sCurrentLine, file;
			file="";
			while ((sCurrentLine = br.readLine()) != null) {
				file+=sCurrentLine+"\n";
			}
			
			JSONArray array = new JSONArray(file);
			
			for (int i = 0; i < array.length(); i++)
		    {
		        JSONObject obj= array.getJSONObject(i);
		        ingest(obj.getString("type"), obj);
		    }
			
//			System.out.println("Records inserted");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
  	 	
  	 	topXSimpleLTVCustomers();
  	 	
  	 	try {
			String outputFileName="output/output.txt";
			fw = new FileWriter(outputFileName);
			bw = new BufferedWriter(fw);
			
			for(String customerKey: resultsMap.keySet()){
//	  	 		System.out.println("Customer with "+ customerKey +" LTV is " + resultsMap.get(customerKey));
				bw.write("Customer with "+ customerKey +" LTV is " + resultsMap.get(customerKey));
	  	 	}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
  	 	
		}
        
    }
    
    public static void ingest(String e, JSONObject obj){
    		
    	 if(obj.getString("type").equalsIgnoreCase("CUSTOMER")){
	        	customersMap.put(obj.getString("key"), new Customer(obj.getString("type"),obj.getString("verb"),obj.getString("key"),dtf.parseDateTime(obj.getString("event_time")),obj.getString("last_name"),obj.getString("adr_city"),obj.getString("adr_state"))) ;
	        }else if(obj.getString("type").equalsIgnoreCase("SITE_VISIT")){
	        	siteVisitMap.put(obj.getString("key"), new SiteVisit(obj.getString("type"),obj.getString("verb"),obj.getString("key"),dtf.parseDateTime(obj.getString("event_time")),obj.getString("customer_id")));
	        }else if(obj.getString("type").equalsIgnoreCase("IMAGE")){
	        	imageUploadMap.put(obj.getString("key"), new ImageUpload(obj.getString("type"),obj.getString("verb"),obj.getString("key"),dtf.parseDateTime(obj.getString("event_time")),obj.getString("camera_make"),obj.getString("camera_model"),obj.getString("customer_id")));
	        }else if(obj.getString("type").equalsIgnoreCase("ORDER")){
	        	ordersMap.put(obj.getString("key"), new Order(obj.getString("type"),obj.getString("verb"),obj.getString("key"),dtf.parseDateTime(obj.getString("event_time")),obj.getString("customer_id"),new Double(obj.getString("total_amount").split(" ")[0])));
	        }else{
	        	System.out.println("Invalid Input");
	        }
    }
    
    /*
     * Assumptions
     * Order amount is displayed in USD
     * Customer can place an order at any time from any place of his choice
     * LTV is calculated for the customers orders only if a customer exists with "type:CUSTOMER"
     *  
     */
    public static void topXSimpleLTVCustomers(){
    	
    	int siteVisitCount=0;
    	double orderVal=0,avgOrderVal=0;
    	int orderCount=0;
    	for(String custKey : customersMap.keySet()){
    		for(String siteKey: siteVisitMap.keySet()){
    			if(siteVisitMap.get(siteKey).getCustomer_id().equalsIgnoreCase(custKey)){
    				siteVisitCount++;
    			}
    		}
    		for(String orderKey: ordersMap.keySet()){
    			if(ordersMap.get(orderKey).getCustomer_id().equalsIgnoreCase(custKey)){
    				orderVal+=ordersMap.get(orderKey).getTotal_amount();
    				orderCount++;
    			}
    		}
    		avgOrderVal=orderVal/orderCount;
    		resultsMap.put(custKey, (52*avgOrderVal*siteVisitCount/7));
    		avgOrderVal=0;
    		orderCount=0;
    		siteVisitCount=0;
    	}
    }
}
