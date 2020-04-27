package uk.ac.forthvalley.gradedunit.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import uk.ac.forthvalley.gradedunit.application.*;
import uk.ac.forthvalley.gradedunit.gui.menuUI;

public class DatabaseManager {
	final private String url= "database url"; 
    final private String user = "user"; 
    final private String password = "password"; 
    Connection con=null;
    Client client=new Client();
    Supplier supplier=new Supplier();
    Product product=new Product();
    Report report=new Report();
    Order order=new Order();
    menuUI gui = new menuUI();
    int orderID=1;
    public DatabaseManager()
    {}
    
	 public String getClient(int clientID)
	{
		 String clientString="";
		try {
			con=DriverManager.getConnection(url, user, password);
			client.getClientInfo(clientID);
			clientString=client.getClientInfo(clientID);
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return clientString;
	}
	 
	
	 public void insertClient(String companyName,String companyEmail,String clientPhoneNumber)
		{
			
			try {
				con=DriverManager.getConnection(url, user, password);
				client.insertNewClient(companyName, companyEmail, clientPhoneNumber);
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	 
	 public String getSupplier(int supplierID)
	 {
		 String supplierInfo="";
		 try {
			 con=DriverManager.getConnection(url, user, password);
			 supplier.getSupplierInfo(supplierID);
			 supplierInfo=supplier.getSupplierInfo(supplierID);
			 con.close();
			 }catch(SQLException e) {
			e.printStackTrace(); 
		 }
		 return supplierInfo;
	 }
	 
	 public void insertNewSupplier(String companyName,String supplierEmail,String supplierPhoneNumber)
	 {
		 try {
			 con=DriverManager.getConnection(url, user, password);
			 supplier.insertNewSupplier(companyName, supplierEmail, supplierPhoneNumber);
			 con.close();
		 }catch(SQLException e) {
			e.printStackTrace(); 
		 }
	 }
	 
	 public void insertNewProduct(String productName,int productQuantity,double productPrice,String productProvenance,String productDescription,boolean productType,int supplierID)
	 {
		 try {
			 con=DriverManager.getConnection(url, user, password);
			 product.insertNewProduct(productName, productQuantity, productPrice, productProvenance, productDescription, productType, supplierID);
			 con.close();
		 }catch(SQLException e) {
			e.printStackTrace(); 
		 }
	 }
	 
	 public void getWeeklyReport()
	 {
		 try {
			 con=DriverManager.getConnection(url, user, password);
			 report.getWeeklyReport();
			 con.close();
		 }catch(SQLException e) {
			e.printStackTrace(); 
		 }
	 }
	 
	 public void getMonthlyReport()
	 {
		 try {
			 con=DriverManager.getConnection(url, user, password);
			 report.getMonthlyReport();
			 con.close();
		 }catch(SQLException e) {
			e.printStackTrace(); 
		 }
	 }
    
	 public void addOrder(String productName,int productQuantity,int clientID){

		 try { 
			 con=DriverManager.getConnection(url, user, password);
             order.addOrder(orderID, clientID);
			order.newOrderProduct(productName, productQuantity,orderID);
			con.close();
		}catch(SQLException e) {
				 e.printStackTrace();	 
		}
		 
	 }
	 
	 public String getOrder(int orderID)
	 {
		 String orderString="";
		 try {
			 con=DriverManager.getConnection(url, user, password);
			 order.getOrder(orderID);
			 orderString=order.getOrder(orderID);
			 con.close();
		 }catch(SQLException e) {
			e.printStackTrace(); 
		 }
		 return orderString;
	 }
	 public void incrementOrderID()
	 {
		 orderID++;
	 }
	 
	 
}
