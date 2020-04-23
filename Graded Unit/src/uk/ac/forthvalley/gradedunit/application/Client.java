package uk.ac.forthvalley.gradedunit.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Client {
 private Connection con=null;
 private int clientID=1;
 private String insertClientString="INSERT INTO clients VALUES(?,?,?,?) ";
 private PreparedStatement insertClient=null;
 private String getClientInfoString="SELECT client_id,company_name,e-mail,phone_number FROM clients WHERE client_id=?";
 private PreparedStatement getClientInfo=null;
 public Client()
 {
	  
 }

 public void insertNewClient(String companyName,String companyEmail,String clientPhoneNumber) throws SQLException {
	 try {
		insertClient=con.prepareStatement(insertClientString);
		insertClient.setInt(1,clientID);
		insertClient.setString(2,companyName);
	    insertClient.setString(3,companyEmail);
	    insertClient.setString(4,clientPhoneNumber);
	    clientID++;
	} catch (SQLException e) {
		System.out.println("Error in inserting the client");
		e.getMessage();
	}
	 
 }
public void getClientInfo(int clientID) throws SQLException
{
  try {
	getClientInfo=con.prepareStatement(getClientInfoString);
	getClientInfo.setInt(1,clientID);
} catch (SQLException e) {
	System.out.println("Error retriving client info");
	e.getMessage();
}	
}

}

