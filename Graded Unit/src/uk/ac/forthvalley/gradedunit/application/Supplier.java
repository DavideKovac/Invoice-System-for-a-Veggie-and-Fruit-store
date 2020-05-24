package uk.ac.forthvalley.gradedunit.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *  This is the class that manage all the queries related to the Suppliers table
 * @author Davide Kovac
 *
 */
public class Supplier {
/**
 * The connection is the Object that connect the class to the db 
 */
Connection con=null;
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
 * This String generate a query to insert a new supplier into the database table
 */
private String insertSupplierString="INSERT INTO suppliers VALUES(NULL,?,?,?)";
/**
 * This statement execute a query using the inserSupplierString
 */
private PreparedStatement insertSupplier=null;
/**
 * This String execute the query to get information about the supplier using the ID
 */
private String getSupplierInfoString="SELECT * FROM suppliers WHERE supplier_id=?";
/**
 * This statement execute the query to get the supplier information using the getSupplierInfo String
 */
private PreparedStatement getSupplierInfo=null;

public Supplier()
{
	
}
/**
 * This methods add a supplier to the supplier table in the database
 * @param companyName the name of the supplier company
 * @param supplierEmail the supplier email
 * @param supplierPhoneNumber the supplier phone number
 * @throws SQLException
 */
public void insertNewSupplier(String companyName,String supplierEmail,String supplierPhoneNumber) throws SQLException{
	try {
	con=DriverManager.getConnection(url, user, password);
	insertSupplier=con.prepareStatement(insertSupplierString);
	insertSupplier.setString(1,companyName);
	insertSupplier.setString(2, supplierEmail);
	insertSupplier.setString(3, supplierPhoneNumber);
	insertSupplier.executeUpdate();
	con.close();
	}
	catch(SQLException e)
	{
		e.getMessage();
	}
}
/**
 * This methods return the information about the supplier
 * @param supplierID the id to get the information
 * @return Return the information about the supplier 
 * @throws SQLException
 */
public String getSupplierInfo(int supplierID) throws SQLException {
	String supplier=" ";
	ResultSet rs;
	con=DriverManager.getConnection(url, user, password);
	getSupplierInfo=con.prepareStatement(getSupplierInfoString);
	getSupplierInfo.setInt(1,supplierID);
	rs = getSupplierInfo.executeQuery();        
	while (rs.next()) {               
	int supplierIDResult= rs.getInt(1);       
	String supplierNameResult= rs.getString(2);
	String emailResult=rs.getString(3);
	String phoneNumberResult=rs.getString(4);
	supplier="Supplier ID: "+supplierIDResult+" Supplier Name: "+supplierNameResult+" Email: "+emailResult+" Phone Number"+phoneNumberResult;
	}
	con.close();
	return supplier;
}

}
