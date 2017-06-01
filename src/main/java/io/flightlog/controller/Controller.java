package io.flightlog.controller;

import java.io.Serializable;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.DBCursor;

import io.flightlog.dao.DAO;
import io.flightlog.dto.FlightLog;

@RestController
public class Controller {
	
	/* curl -X GET http://localhost:8080/get */
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public ResponseEntity<Serializable> get(){
		try {
			System.out.println("connecting...");
			
	    	DBCursor cursor = DAO.getCollectionAccess("Person").find();
	    	String output = null;
	    	
			System.out.println("Starting...");
	    	while(cursor.hasNext()) {
	    		output += cursor.next();
	    	    System.out.println(output);
	    	}
	    	return ResponseEntity.status(HttpStatus.OK)
	    						 .body(output);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
								 .body(e);
			} 	    	
	}
	
	
	
	
	

	/* curl -H "Content-Type: application/json" -X POST -d '{"sNo":0.00, "pm_iAddrModeS":1, "pm_dLatitude":52.308928, "pm_dLongitude":10.373013, "pm_dAltitudeMSL":500.000000,"pm_dRoll": 0.001500, "pm_dPitch":0.180390, "pm_dHeading":1.396260, "pm_dGroundTrack":1.444650, "pm_dAirSpeed":66.902228, "pm_dGroundSpeed":92.341750, "pm_dVerticalSpeed":0.005334}' http://localhost:8080/post */
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public ResponseEntity<String> post(@RequestBody FlightLog log){
		try {
			System.out.println("Body is : ");
			System.out.println("Request body is : "+log.getsNo() +" : "+log.getPm_dAltitudeMSL());
			return ResponseEntity
		            .status(HttpStatus.CREATED)
		            .body("Request body is : "+log.getsNo() +" : "+log.getPm_dAltitudeMSL());
		} catch (Exception e) {
		    e.printStackTrace(); // see note 2
		    return ResponseEntity
		    		.status(HttpStatus.FORBIDDEN)
		            .body("Error Message");
		}
	}	
}
