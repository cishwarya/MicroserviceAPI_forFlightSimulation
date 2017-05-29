package io.flightlog.init;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

import io.flightlog.dao.DAO;

@RestController
public class Controller {
	
	/* curl -X GET http://localhost:8080/get */
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public String get(){
		System.out.println("connecting...");
/*		MongoClient mongoClient = new MongoClient("172.17.0.2", 27017);
		DB database = mongoClient.getDB("testdb");*/
		
		
    	DBCursor cursor = DAO.getCollectionAccess("Person").find();
    	String output = null;
    	
		System.out.println("Starting...");
    	while(cursor.hasNext()) {
    		output += cursor.next();
    	    System.out.println("hello : "+output);
    	}		
		return "Hello World! "+output;
	}
	
	
	/* curl -H "Content-Type: application/json" -X POST -d '{"name" : "Thishanth", "age" : 16}' http://localhost:8080/post */
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public void post(@RequestBody Person person){
		System.out.println("Body is : ");
		System.out.println("Request body is : "+person.getAge() +" : "+person.getName());
	}	
}
