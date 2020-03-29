package uk.ac.forthvalley.gradedunit.application;

import java.sql.PreparedStatement;

public class Product {
private String productName;
private int productQuantity;
private double productPrice;
private String productProvenance;
private String productDescription;
private boolean productType;
private PreparedStatement insertProduct=con.preparedStatement("INSERT INTO Products VALUES(?,?,?,?,?,?,?,?");
private PreparedStatement getProduct=con.preparedStatement("UPDATE Products SET quantity=quantity-? WHERE product_name=?");
private PreparedStatement removeProduct=con.preparedStatement("DELETE FROM Products WHERE product_name=?");
public Product()
{
	
	
}
public void insertNewProduct(String productName,int productQuantity,double productPrice,String productProvenance,String productDescription,boolean productType)
{ 
	insertProduct.setString(1,productName);
	insertProduct.setInt(2, productQuantity);
	insertProduct.setDouble(3, productPrice);
	insertProduct.setString(4, productProvenance);
	insertProduct.setString(5, productDescription);
	insertProduct.setBoolean(6, productType);
}
//Realize the need of change the class diagram depending on the number of product
//adding a statement and a methods
public void getProduct(String productName,int productQuantity)
{
	
	getProduct.setInt(1,productQuantity);
	getProduct.setString(2, productName);
}

public void removeProduct(String productName)
{
	getProduct.setString(1, productName);
}
}

