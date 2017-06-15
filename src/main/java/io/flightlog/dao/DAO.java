package io.flightlog.dao;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;


@SuppressWarnings("deprecation")
public class DAO {
	/** The mongoDB client. */
	private static MongoClient mongoClient= null;
	
	/** The database. */
	private static DB db = null;
	
	/** The database name. */
	private static final String DBNAME = "testdb";
	
	
	/** The ip. 
	 * uses to connect the database from different host*/
	/*private static String ip = "localhost";*/
	private static String ip = "172.17.0.2";
	
	/** The port to access the database. */
	private static int port = 27017;

	/**
	 * Initialise the database.
	 */
	public static void initDB() {
		try {
			mongoClient = new MongoClient(ip, port);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("could not connected to database");
		}
		db = mongoClient.getDB(DBNAME);
		System.out.println("Database Connection Established");
	}
	
	/**
	 * Gets the database.
	 *
	 * @return the database object. it has the name of the database and other details
	 */
	public static DB getDB() {
		return db;
	}
	
	/**
	 * Close database connection.
	 */
	public static void closeDBConnection() {
		mongoClient.close();
		System.out.println("database connection closed");
	}
	
		
	/**
	 * Gets the collection access.
	 *
	 * @param collectionName the collection name
	 * @return the collection access
	 */
	public static DBCollection getCollectionAccess(String collectionName) {
		return DAO.getDB().getCollection(collectionName);
	}
}
