package io.flightlog.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.DBCursor;

import io.flightlog.dao.DAO;
import io.flightlog.dto.Person;

@RestController
public class Controller {
	
	/* curl -X GET http://localhost:8080/get */
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public String get(){
		System.out.println("connecting...");
		
    	DBCursor cursor = DAO.getCollectionAccess("Person").find();
    	String output = null;
    	
		System.out.println("Starting...");
    	while(cursor.hasNext()) {
    		output += cursor.next();
    	    System.out.println(output);
    	}		
		return "Record from database "+output;
	}
	
	
	
	
	

	/* curl -H "Content-Type: application/json" -X POST -d '{"name" : "Thishanth", "age" : 16}' http://localhost:8080/post */
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public void post(@RequestBody Person person){
		System.out.println("Body is : ");
		System.out.println("Request body is : "+person.getAge() +" : "+person.getName());
	}	
}
