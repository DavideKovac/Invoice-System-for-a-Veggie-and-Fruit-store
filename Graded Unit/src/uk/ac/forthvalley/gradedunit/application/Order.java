package uk.ac.forthvalley.gradedunit.application;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Order {
Connection con=null;
private int orderID=1;
private Product product=new Product();
private String insertNewOrderString=" ";
private PreparedStatement insertNewOrder=null;
private String getOrderString="SELECT * FROM orders WHERE order_id=?";
private PreparedStatement getOrder=null;
private String addToOrderedItemsString="INSERT productName,productID INTO ordered products";
private PreparedStatement addToOrderedItems=null;
private String addNewOrderString="INSERT orderID,clientID FROM orders";
private PreparedStatement addNewOrder=null;

public Order()
{
	
}
public void newOrderProduct(String productName,int productQuantity) throws SQLException
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
public void getOrder(int orderID) throws SQLException
{
	getOrder=con.prepareStatement(getOrderString);
	getOrder.setInt(1,orderID);
	 
}
}
