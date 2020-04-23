package uk.ac.forthvalley.gradedunit.application;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Order {
Connection con=null;
private int orderID=0;
private Product product=new Product();
private String insertNewOrderString=" ";
private PreparedStatement insertNewOrder=null;
private String getOrderString="SELECT * FROM orders WHERE order_id=?";
private PreparedStatement getOrder=null;

public Order()
{
	
}
public void newOrder(String productName) throws SQLException
{
 boolean isAvailable=product.getProductAvailability(productName);
 if(isAvailable==true)
 {
	 //add product
 }
 else
 {
	 //cant add product
 }
}

public void getOrder(int orderID) throws SQLException
{
	getOrder=con.prepareStatement(getOrderString);
	getOrder.setInt(1,orderID);
	 boolean isAvailable=false;
	 
}
}
