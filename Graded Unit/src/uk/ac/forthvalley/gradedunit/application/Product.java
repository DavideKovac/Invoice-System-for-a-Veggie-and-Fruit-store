package uk.ac.forthvalley.gradedunit.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Product {
private Connection con=null;
private String checkProductAvailabilityString="SELECT quantity FROM product WHERE product_name=?";
private PreparedStatement checkProductAvailability=null;
private String insertNewProductString="IF EXIST(SELECT * FROM product WHERE product_name=?)BEGIN UPDATE products SET quantity=quantity+? WHERE product_name=? END ELSE BEGIN INSERT INTO products VALUES(?,?,?,?,?,?,?,?) END";
private PreparedStatement insertNewProduct=null;
private String getProductString="UPDATE products SET quantity=quantity-? WHERE product_name=?";
private PreparedStatement getProduct=null;
public Product()
{
	
	
}
public void insertNewProduct(String productName,int productQuantity,double productPrice,String productProvenance,String productDescription,boolean productType,int supplierID) throws SQLException
{  
	try {
	insertNewProduct=con.prepareStatement(insertNewProductString);
	insertNewProduct.setString(1,productName);
	insertNewProduct.setInt(2, productQuantity);
	insertNewProduct.setString(3, productName);
	insertNewProduct.setString(4, productName);
	insertNewProduct.setInt(5, productQuantity);
	insertNewProduct.setDouble(6, productPrice);
	insertNewProduct.setString(7, productProvenance);
	insertNewProduct.setString(8, productDescription);
	insertNewProduct.setBoolean(9, productType);
	insertNewProduct.setInt(10,supplierID);
	}
	catch(SQLException e)
	{
		e.getMessage();
	}
}
//Realize the need of change the class diagram depending on the number of product
//adding two statement and two methods
public void getProduct(String productName,int productQuantity) throws SQLException
{
	try {
	getProduct=con.prepareStatement(getProductString);
	getProduct.setInt(1,productQuantity);
	getProduct.setString(2, productName);
	}
	catch(SQLException e)
	{
		e.getMessage();
	}
}
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
private int getProductQuantity(String productName) throws SQLException
{
	 checkProductAvailability=con.prepareStatement(checkProductAvailabilityString);
	 checkProductAvailability.setString(1,productName);
	 ResultSet rs=checkProductAvailability.executeQuery();
	 int quantity=rs.getInt("quantity");
	 return quantity;
}
}


