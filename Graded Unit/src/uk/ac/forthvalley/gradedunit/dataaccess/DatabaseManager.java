package uk.ac.forthvalley.gradedunit.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import uk.ac.forthvalley.gradedunit.application.*;

public class DatabaseManager {
	final private String url= "database url"; 
    final private String user = "user"; 
    final private String password = "password"; 
    Connection con=null;
    Client client=new Client();
    Supplier supplier=new Supplier();
    Product product=new Product();
    Report report=new Report();
    public DatabaseManager()
    {}
    
	 public void getClient(int clientID)
	{
		
		try {
			con=DriverManager.getConnection(url, user, password);
			client.getClientInfo(clientID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	 public void insertClient(String companyName,String companyEmail,String clientPhoneNumber)
		{
			
			try {
				con=DriverManager.getConnection(url, user, password);
				client.insertNewClient(companyName, companyEmail, clientPhoneNumber);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	 
	 public void getSupplier(int supplierID)
	 {
		 try {
			 con=DriverManager.getConnection(url, user, password);
			 supplier.getSupplierInfo(supplierID);
		 }catch(SQLException e) {
			e.printStackTrace(); 
		 }
		 
	 }
	 
	 public void insertNewSupplier(String companyName,String supplierEmail,String supplierPhoneNumber)
	 {
		 try {
			 con=DriverManager.getConnection(url, user, password);
			 supplier.insertNewSupplier(companyName, supplierEmail, supplierPhoneNumber);
		 }catch(SQLException e) {
			e.printStackTrace(); 
		 }
	 }
	 
	 public void insertNewProduct(String productName,int productQuantity,double productPrice,String productProvenance,String productDescription,boolean productType,int supplierID)
	 {
		 try {
			 con=DriverManager.getConnection(url, user, password);
			 product.insertNewProduct(productName, productQuantity, productPrice, productProvenance, productDescription, productType, supplierID);
		 }catch(SQLException e) {
			e.printStackTrace(); 
		 }
	 }
	 
	 public void getWeeklyReport()
	 {
		 try {
			 con=DriverManager.getConnection(url, user, password);
			 report.getWeeklyReport();
		 }catch(SQLException e) {
			e.printStackTrace(); 
		 }
	 }
	 
	 public void getMonthlyReport()
	 {
		 try {
			 con=DriverManager.getConnection(url, user, password);
			 report.getMonthlyReport();
		 }catch(SQLException e) {
			e.printStackTrace(); 
		 }
	 }

}
