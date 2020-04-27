package uk.ac.forthvalley.gradedunit.application;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Order {
Connection con=null;
private Product product=new Product();
private String getOrderString="SELECT * FROM orders WHERE order_id=?";
private PreparedStatement getOrder=null;
private String addToOrderedItemsString="INSERT INTO ordered products VALUES(?,?)";
private PreparedStatement addToOrderedItems=null;
private String addNewOrderString="INSERT INTO orders VALUES(?,?,sysdata)";
private PreparedStatement addNewOrder=null;

public Order()
{
	
}
public void newOrderProduct(String productName,int productQuantity,int orderID) throws SQLException
{
 boolean isAvailable=product.getProductAvailability(productName);
 addToOrderedItems=con.prepareStatement(addToOrderedItemsString);
 if(isAvailable==true)
 {
	 product.getProduct(productName, productQuantity);
	 addToOrderedItems.setString(1,productName);
	 addToOrderedItems.setInt(2,orderID);
	 
 }
 else
 {
	 System.out.println("Unavailable product");
 }
}
public void addOrder(int orderID,int clientID) throws SQLException
{
    addNewOrder=con.prepareStatement(addNewOrderString);	
    addNewOrder.setInt(1, orderID);
    addNewOrder.setInt(2, clientID);

}
public String getOrder(int orderID) throws SQLException
{ 
	String order="";
	getOrder=con.prepareStatement(getOrderString);
	getOrder.setInt(1,orderID);
	order=getOrder.toString();
	return order;
}
}
