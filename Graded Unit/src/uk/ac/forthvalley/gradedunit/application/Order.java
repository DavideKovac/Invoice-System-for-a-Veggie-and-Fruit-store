package uk.ac.forthvalley.gradedunit.application;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *  This is the class that manage all the queries related to the Orders table
 *
 * @author Davide Kovac
 *
 */
public class Order {
/**
 *The connection is the Object that connect the class to the db 
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
 * The product class reference
 */
private Product product=new Product();
/**
 * This string select the order information 
 */
private String getOrderString="SELECT * FROM orders WHERE order_id=?";
/**
 * This is the statement where the getOrderString get added and execute the query
 */
private PreparedStatement getOrder=null;
/**
 * The string insert into the ordered product the product of an order 
 */
private String addToOrderedItemsString="INSERT INTO `ordered products` VALUES(?,?,(SELECT product_name FROM products WHERE product_name=?))";
/**
 * This is the statement where the addToOrderedItemsString get added and execute the query
 */
private PreparedStatement addToOrderedItems=null;
/**
 * This string generate a new order
 */
private String addNewOrderString="INSERT INTO orders VALUES(NULL,?,CURRENT_DATE)";
/**
 * This is the statement where the addNewOrderString get added and execute the query
 */
private PreparedStatement addNewOrder=null;
/**
 * This string select the max id for order in the database
 */
private String getOrderIDSting="SELECT MAX(order_id) FROM orders";
/**
* This is the statement where the  getOrderID string get added and execute the query
*/
private PreparedStatement getOrderID=null;

public Order()
{
	
}
/**
 * <p> This methods ,when receive the information send them to the database to add a order
 * the product get added just if is available checking with the method @link uk.ac.forthvalley.application.product.getProductAvailability(String ,int) getProductAvailability
 * </p>
 * 
 * @param productName is the name of the product added to the order
 * @param productQuantity is the quantity of product added to the order
 * @throws SQLException
 */
public void newOrderProduct(String productName,int productQuantity) throws SQLException
{
 boolean isAvailable=product.getProductAvailability(productName);
 con=DriverManager.getConnection(url, user, password);
 addToOrderedItems=con.prepareStatement(addToOrderedItemsString);
 if(isAvailable==true && productQuantity<=product.getProductQuantity(productName))
 {   
	 int orderID=getOrderID();
	 product.getProduct(productName, productQuantity);
	 addToOrderedItems.setInt(1,productQuantity);
	 addToOrderedItems.setInt(2,orderID);
	 addToOrderedItems.setString(3,productName);
	 addToOrderedItems.execute();
 }
 else
 {
	 System.out.println("Unavailable product");
 }
 con.close();
}
/**
 * <p>
 * This methods add an order to the database
 * </p>
 * @param clientID get the client id to add to the order
 * @throws SQLException
 */
public void addOrder(int clientID) throws SQLException
{ 
	con=DriverManager.getConnection(url, user, password);
    addNewOrder=con.prepareStatement(addNewOrderString);	;
    addNewOrder.setInt(1, clientID);
    addNewOrder.execute();
    con.close();
}
/**
 * <p> This return the information of the order request on the getinfo method</p>
 *
 * @param orderID
 * @return a string with the information of the Order 
 * @throws SQLException
 */
public String getOrder(int orderID) throws SQLException
{ 
	String order="";
	ResultSet rs;
	con=DriverManager.getConnection(url, user, password);
	getOrder=con.prepareStatement(getOrderString);
	getOrder.setInt(1,orderID);
	rs = getOrder.executeQuery();        
	while (rs.next()) {               
	int orderIDResult= rs.getInt(1);       
	int clientIDResult= rs.getInt(2);
	Date DateResult=rs.getDate(3);
	order="Order ID: "+orderIDResult+" Client ID: "+clientIDResult+" Order Date: "+DateResult;
	}
	con.close();
	return order;
}
/**
 * <p> this methods give the order id+1, to add order items to the database</p>
 * @return current OrderID+1
 * @throws SQLException
 */
public int getOrderID() throws SQLException
{
	con=DriverManager.getConnection(url, user, password);
	getOrderID=con.prepareStatement(getOrderIDSting);
	int orderID=0;
	ResultSet rs;
	rs=getOrderID.executeQuery();
	while(rs.next())
	{
	 orderID=rs.getInt(1);
	 System.out.println(orderID);
	}
	con.close();
	orderID=orderID+1;
	return orderID;
}
}
