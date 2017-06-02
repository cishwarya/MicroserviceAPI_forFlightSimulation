package io.flightlog.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;


public class Mapper {
	/** The mapper. */
	static ObjectMapper mapper = new ObjectMapper();
	
	/**
	 * Pojo to json.
	 *
	 * @param pojo the pojo
	 * @return the DB object
	 */
	public static DBObject pojoToJson(FlightLog pojo) {
		try {
			Object pojoStr = JSON.parse(mapper.writeValueAsString(pojo));
			DBObject dbObj = (DBObject) pojoStr;
			return dbObj;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
