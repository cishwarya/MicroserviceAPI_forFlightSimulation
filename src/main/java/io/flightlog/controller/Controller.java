package io.flightlog.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import io.flightlog.dao.DAO;
import io.flightlog.dto.FlightLog;
import io.flightlog.dto.Mapper;

/**
 * The Class Controller.
 * Response to request mapping
 */
@RestController
public class Controller {
	
	/** The collection name in mongoDB. */
	private static final String collectionName = "FlightLog";
	
	
	
	/**
	 * Gets flight log resource.
	 *
	 * @return the response entity
	 */
	/* curl -X GET http://localhost:8080/get/0.03/ */
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> get(@PathVariable String id){
		try {			
			
			/*Following query will be implement with Spring Data MongoDB */	    	
			BasicDBObject query = new BasicDBObject();
			query.put("sNo", id);			
			DBObject dbObj = DAO.getCollectionAccess(collectionName).findOne(query);
	    	
			/*DBObject to json conversion*/
			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			String json = ow.writeValueAsString(dbObj);
			
	    	return ResponseEntity.status(HttpStatus.OK)
	    						 .body(json);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
								 .body(e);
			} 	    	
	}
	
	
	
	
	

	/**
	 * Create resource.
	 *
	 * @param log the flight log data
	 * @return the response body builder
	 */
	/* curl -H "Content-Type: application/json" -X POST -d '{"sNo":"0.03", "pm_iAddrModeS":"2", "pm_dLatitude":"52.308928", "pm_dLongitude":"10.373013", "pm_dAltitudeMSL":"500.000000","pm_dRoll": "0.001500", "pm_dPitch":"0.180390", "pm_dHeading":"1.396260", "pm_dGroundTrack":"1.444650", "pm_dAirSpeed":"66.902228", "pm_dGroundSpeed":"92.341750", "pm_dVerticalSpeed":"0.005334"}' http://localhost:8080/post */
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public ResponseEntity<String> post(@RequestBody FlightLog log){
		try {
			/*Following query will be implement with Spring Data MongoDB */
			//DAO.createDataStore(FlightLog.class).save(log);

			DAO.getCollectionAccess(collectionName)	
			   .insert(Mapper.pojoToJson(log));

			return ResponseEntity
		            .status(HttpStatus.CREATED)
		            .body("Saved");
		} catch (Exception e) {
		    e.printStackTrace();
		    return ResponseEntity
		    		.status(HttpStatus.FORBIDDEN)
		    		.body("Error");
		}
	}	
}
