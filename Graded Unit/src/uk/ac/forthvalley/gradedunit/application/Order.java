package uk.ac.forthvalley.gradedunit.application;
import java.sql.PreparedStatement;

public class Order {
private int orderID=0;
private PreparedStatement insertNewOrder=con.preparedStatement("  ");
private PreparedStatement getOrder=con.preparedStatement("SELECT * FROM orders WHERE order_id=?");

public Order()
{
	
}
public void getOrder(int orderID)
{
	getOrder.setInt(1,orderID);
	
}
}
