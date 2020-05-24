package uk.ac.forthvalley.gradedunit.dataaccess;

import java.sql.SQLException;
import java.util.ArrayList;
import uk.ac.forthvalley.gradedunit.application.*;
import uk.ac.forthvalley.gradedunit.gui.menuUI;
/**
 * This is the class that connect the GUI(uk.ac.forthvallley.gradedunit.gui) and the data access(uk.ac.forthvalley.gradedunit.dataaccess)
 * @author Davide Kovac 
 *
 */
public class DatabaseManager {
	/**
	 * Client object from the data access package
	 */
    Client client=new Client();
    /**
	 * Supplier object from the data access package
	 */
    Supplier supplier=new Supplier();
    /**
	 * Product object from the data access package
	 */
    Product product=new Product();
    /**
	 * Report object from the data access package
	 */
    Report report=new Report();
    /**
	 * Order object from the data access package
	 */
    Order order=new Order();
    /**
	 * MenuUI object from the GUI package
	 */
    menuUI gui = new menuUI();
    public DatabaseManager()
    {}
    /**
     *<p>Connect the GUI and the data access to execute the getClientInfo() method in Client class</p>
     * @param clientID got from the GUI
     * @return Return the information from the client class that the method got from the database and send them to the GUI
     */
	 public String getClient(int clientID) 
	{
		 String clientString=null;
		try {
			clientString=client.getClientInfo(clientID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return clientString;
	}
	 
	/**
	 * <p>Conncet the GUI and the dataacces to execute the Client.insertNewClient() method</p>
	 * @param companyName got from the GUI
	 * @param companyEmail got from the GUI
	 * @param clientPhoneNumber got from the GUI
	 */
	 public void insertClient(String companyName,String companyEmail,String clientPhoneNumber) 
	    {	
			try {
				client.insertNewClient(companyName, companyEmail, clientPhoneNumber);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	 /**
	  * <p>Connect the GUI and the dataacces to execute the Supplier.getSupplierInfo() method</p>
	  * @param supplierID got from the GUI
	  * @return Return the information from the supplier class that the method got from the database and send them to the GUI
	  */
	 public String getSupplier(int supplierID) 
	 {
		 String supplierInfo="";
		 try {
			 supplierInfo=supplier.getSupplierInfo(supplierID);
			 }catch(SQLException e) {
			e.printStackTrace(); 
		 }
		 return supplierInfo;
	 }
	 /**
	  * <p>Connect the GUI and the dataacces to execute the Supplier.insertNewSupplier() method</p>
	  * @param companyName got from the GUI
	  * @param supplierEmail got from the GUI
	  * @param supplierPhoneNumber got from the GUI
	  */
	 public void insertNewSupplier(String companyName,String supplierEmail,String supplierPhoneNumber) 
	 {
		 try {
			 supplier.insertNewSupplier(companyName, supplierEmail, supplierPhoneNumber);
		 }catch(SQLException e) {
			e.printStackTrace(); 
		 }
	 }
	 /**
	  * <p>Connect the GUI and the dataacces to execute the Product.insertNewProduct() method</p>
	  * @param productName got from the GUI
	  * @param productQuantity got from the GUI
	  * @param productPrice got from the GUI
	  * @param productProvenance got from the GUI
	  * @param productDescription got from the GUI
	  * @param productType got from the GUI
	  * @param supplierID got from the GUI
	  */
	 public void insertNewProduct(String productName,int productQuantity,double productPrice,String productProvenance,String productDescription,int productType,int supplierID) 
	 {
		 try {
			 product.insertNewProduct(productName, productQuantity, productPrice, productProvenance, productDescription, productType, supplierID);
		 }catch(SQLException e) {
			e.printStackTrace(); 
		 }
	 }
	 /**
	  * <p>Connect the GUI and the dataacces to execute the Report.getWeeklyReport() method </p>
	  * @return Return the information from the report class that the method got from the database and send them to the GUI
	  */
	 public ArrayList<String> getWeeklyReport() 
	 {  
	    ArrayList <String> weeklyReport=new ArrayList<>();
		 try {
			 weeklyReport=report.getWeeklyReport();
		 }catch(SQLException e) {
			e.printStackTrace(); 
		 }
		return weeklyReport;
	 }
	 /**
	  * <p>Connect the GUI and the dataacces to execute the Report.getMonthlyReport() method </p>
	  * @return  Return the information from the report class that the method got from the database and send them to the GUI
	  */
	 public ArrayList<String> getMonthlyReport() 
	 {
		 ArrayList <String> monthlyReport=new ArrayList<>();
		 try {
			monthlyReport=report.getMonthlyReport();
		 }catch(SQLException e) {
			e.printStackTrace(); 
		 }
		return monthlyReport;
	 }
    /**
     * <p>Connect the GUI and the dataacces to execute the Order.addOrder() method</p>
     * @param clientID got from the GUI
     */
	 public void addOrder(int clientID) {

		 try { 
             order.addOrder( clientID);
		}catch(SQLException e) {
				 e.printStackTrace();	 
		}
		 
	 }
	 /**
	  * <p>Connect the GUI and the dataacces to execute the Order.getOrder() method</p>
	  * @param orderID got from the GUI
	  * @return  Return the information from the report class that the method got from the database and send them to the GUI
	  */
	 public String getOrder(int orderID) 
	 {
		 String orderString="";
		 try {
			 orderString=order.getOrder(orderID);
		 }catch(SQLException e) {
			e.printStackTrace(); 
		 }
		 return orderString;                                                  
	 }
	 /**
	  * <p>Connect the GUI and the dataacces to execute the Order.newOrderedProduct() method</p>
	  * @param productName got from the GUI
	  * @param productQuantity got from the GUI
	  */
	 public void addToOrderedItems(String productName, int productQuantity)
	 {
		 try {
			 order.newOrderProduct(productName, productQuantity);
		 }
		 catch(SQLException e)
		 {
			 e.printStackTrace();
		 }
	 }
	 
	
}
