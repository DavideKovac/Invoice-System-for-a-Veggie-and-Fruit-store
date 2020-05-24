package uk.ac.forthvalley.gradedunit.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *  This is the class that manage all the queries related to the Clients table
 * @author Davide Kovac 
 *
 */

public class Client {
/**
 * The connection is the Object that connect the class to the db 
 */
private Connection con=null;
/**
 *The url of the database
 */
 final private  String url= "jdbc:mysql://localhost/veggie shop"; 
 /**
  * the database username
  */
 final private  String user = "root"; 
 /**
  * the database password
  */
 final private  String password = "root";
 /**
  * The String of a query that insert a client to the database
  */
 private String insertClientString="INSERT INTO clients VALUES(NULL,?,?,?) ";
 /**
  * This statement execute a query using insertClientString to insert a new client
  */
 private PreparedStatement insertClient=null;
 /**
  * The String of query to select a client using an id
  */
 private String getClientInfoString="SELECT * FROM clients WHERE client_id=?";
 /**
  *  This Statement execute a query to get client info  using getClientInfoString 
  */
 private PreparedStatement getClientInfo=null;
 public Client()
 {
	  
 }
/**
 *<p> This methods insert a client to the Clients table</p>
 * @param companyName the client company name
 * @param companyEmail the client email
 * @param clientPhoneNumber the client number
 * @throws SQLException
 */
 public void insertNewClient(String companyName,String companyEmail,String clientPhoneNumber) throws SQLException {
	 try {
		con=DriverManager.getConnection(url, user, password);
	    insertClient=con.prepareStatement(insertClientString);
		insertClient.setString(1,companyName);
	    insertClient.setString(2,companyEmail);
	    insertClient.setString(3,clientPhoneNumber);
	    insertClient.executeUpdate();
	    con.close();
	} catch (SQLException e) {
		System.out.println("Error in inserting the client");
		e.getMessage();
	}
	 
 }
 /**
  * <p>This methods return the information of the client using an ID</p>
  * @param clientID the id of the client that information are need
  * @return Return a String with the client information
  * @throws SQLException
  */
public String getClientInfo(int clientID) throws SQLException
{ 
	String client="";
	 ResultSet rs;
	 con=DriverManager.getConnection(url, user, password);
	getClientInfo=con.prepareStatement(getClientInfoString);
	getClientInfo.setInt(1,clientID);
	rs = getClientInfo.executeQuery();        
	while (rs.next()) {               
	int clientIDResult= rs.getInt(1);       
	String companyNameResult= rs.getString(2);
	String emailResult=rs.getString(3);
	String phoneNumberResult=rs.getString(4);
	client="Client ID: "+clientIDResult+" Company Name: "+companyNameResult+" Email: "+emailResult+" Phone Number"+phoneNumberResult;
	}
	con.close();
    return client;
}
}


