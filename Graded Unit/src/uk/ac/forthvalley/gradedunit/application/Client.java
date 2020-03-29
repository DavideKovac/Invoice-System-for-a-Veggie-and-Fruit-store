package uk.ac.forthvalley.gradedunit.application;

import java.sql.PreparedStatement;

public class Client {
 private int clientID=1;
 private String companyName;
 private String companyEmail;
 private String clientPhoneNumber;
 private PreparedStatement insertClient=con.preparedStatement("INSERT INTO Clients VALUES(?,?,?,?) ");
 private PreparedStatement getClientInfo=con.preparedStatement("SELECT client_id,company_name,e-mail,phone_number FROM Clients WHERE client_id=?");
 
 public Client()
 {
	 
 }
 public void insertNewClient(int clientID,String companyName,String companyEmail,String clientPhoneNumber) {
	 insertClient.setInt(1,clientID);
	 insertClient.setString(2,companyName);
	 insertClient.setString(3,companyEmail);
	 insertClient.setString(4,clientPhoneNumber);
	 clientID++;
 }
public void getClientInfo(int clientID)
{
  getClientInfo.setInt(1,clientID);	
}

}
