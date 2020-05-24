package uk.ac.forthvalley.gradedunit.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *  This is the class that manage all the queries related to the Products table 
 * @author Davide Kovac 
 *
 */
public class Product {
/**
 * The connection is the Object that connect the class to the db 
 */
private Connection con=null;
/**
 * The url of the database
 */
final private  String url= "jdbc:mysql://localhost/veggie shop"; 
/**
 * The database username
 */
final private  String user = "root"; 
/**
 * The database password
 */
final private  String password = "root";
/**
 * This string generate a query to select product quantity
 */
private String checkProductAvailabilityString="SELECT product_quantity FROM products WHERE product_name=?";
/**
 * This is the prepare statement that using checkProductAvailability string execute a query to check product availability
 */
private PreparedStatement checkProductAvailability=null;
/**
 * This string generate a query insert a product into the table
 */
private String insertNewProductString="INSERT INTO products VALUES(?,?,?,?,?,?) ON DUPLICATE KEY UPDATE product_quantity=product_quantity+?";
/**
 * This is the statement that using insertNewProductString execute the query to insert product
 */
private PreparedStatement insertNewProduct=null;
/**
 * This string generate a query to insert product into the new stocks
 */
private String insertNewStocksString="INSERT INTO `new stocks` VALUES(?,(SELECT product_name FROM products WHERE product_name=?),(SELECT supplier_id FROM suppliers WHERE supplier_id=?))";
/**
 * This Statement using insertNewStockString insert a product into new stocks table 
 */
private PreparedStatement insertNewStocks=null;
/**
 * This string update a product quantity id it is added to an order
 */
private String getProductString="UPDATE products SET product_quantity=product_quantity-? WHERE product_name=?";
/**
 * This Statement update product table if a product is ordered, using getProductString
 */
private PreparedStatement getProduct=null;
public Product()
{
	
	
}
/**
 * <p>This methods insert a products to the product table and the new stocks table</p>
 * @param productName the name of the product added to the database
 * @param productQuantity the quantity of the product added to the database
 * @param productPrice the price of the product added to the database
 * @param productProvenance the provenance of the product added to the database
 * @param productDescription the description of the product added to the database
 * @param productType the type of the product added to the database(0 for fruit,1 for veggie)
 * @param supplierID the supplier that supply the new stocks
 * @throws SQLException
 */
public void insertNewProduct(String productName,int productQuantity,double productPrice,String productProvenance,String productDescription,int productType,int supplierID) throws SQLException
{  
	try {
	con=DriverManager.getConnection(url, user, password);
	insertNewProduct=con.prepareStatement(insertNewProductString);
	insertNewStocks=con.prepareStatement(insertNewStocksString);
	insertNewProduct.setString(1,productName);
	insertNewProduct.setString(2, productDescription);
	insertNewProduct.setString(3, productProvenance);
	insertNewProduct.setDouble(4, productPrice);
	insertNewProduct.setInt(5, productQuantity);
	insertNewProduct.setInt(6, productType);
	insertNewProduct.setInt(7,productQuantity);
	insertNewStocks.setInt(1,productQuantity);
	insertNewStocks.setString(2,productName);
	insertNewStocks.setInt(3,supplierID);
	insertNewProduct.executeUpdate();
	insertNewStocks.executeUpdate();
	con.close();
	}
	catch(SQLException e)
	{
		e.getMessage();
	}
}
/**
 * <p>This method get a product to a database, updating the quantity of the product</p>
 * @param productName the name of the product that get updated to the database
 * @param productQuantity the quantity that get take off from the database
 * @throws SQLException
 */
public void getProduct(String productName,int productQuantity) throws SQLException
{
	try {
	con=DriverManager.getConnection(url, user, password);
	getProduct=con.prepareStatement(getProductString);
	getProduct.setInt(1,productQuantity);
	getProduct.setString(2, productName);
	getProduct.executeUpdate();
	con.close();
	}
	catch(SQLException e)
	{
		e.getMessage();
	}
}
/**
 * <p>This methods give if the product quantity is available to get add to an order(quantity 3 or less)</p>
 * @param productName The name of the product that need to be check if is available
 * @return return if the product is available
 * @throws SQLException
 */
public boolean getProductAvailability(String productName)throws SQLException
{
	 boolean isAvailable=false;
	 if(getProductQuantity(productName)>3)
	 {
		 isAvailable=true;
	 }
	 else if(getProductQuantity(productName)<=3)
	 {
		 isAvailable=false;
	 }
	 return isAvailable;
}
/**
 * <p>This method get the product quantity to check if is available</p>
 * @param productName The name of the product that need to be checked
 * @return The quantity of the product
 * @throws SQLException
 */
public int getProductQuantity(String productName) throws SQLException
{
	 int quantity=0;
	 con=DriverManager.getConnection(url, user, password);
	 checkProductAvailability=con.prepareStatement(checkProductAvailabilityString);
	 checkProductAvailability.setString(1,productName);
	 ResultSet rs=checkProductAvailability.executeQuery();
	 while(rs.next()) {
	 quantity=rs.getInt("product_quantity");
	 System.out.println(quantity);
	 }
	 con.close();
	 return quantity;
}
}
