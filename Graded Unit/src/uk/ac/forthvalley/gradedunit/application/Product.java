package uk.ac.forthvalley.gradedunit.application;

import java.sql.PreparedStatement;

public class Product {
private String productName;
private int productQuantity;
private double productPrice;
private String productProvenance;
private String productDescription;
private boolean productType;
private PreparedStatement insertNewProduct=con.preparedStatement("IF EXIST(SELECT * FROM product WHERE product_name=?)BEGIN UPDATE products SET quantity=quantity+? WHERE product_name=? END ELSE BEGIN INSERT INTO products VALUES(?,?,?,?,?,?,?) END");
private PreparedStatement getProduct=con.preparedStatement("UPDATE products SET quantity=quantity-? WHERE product_name=?");
public Product()
{
	
	
}
public void insertNewProduct(String productName,int productQuantity,double productPrice,String productProvenance,String productDescription,boolean productType,int supplierID)
{ 
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
//Realize the need of change the class diagram depending on the number of product
//adding two statement and two methods
public void getProduct(String productName,int productQuantity)
{
	
	getProduct.setInt(1,productQuantity);
	getProduct.setString(2, productName);
}
}

