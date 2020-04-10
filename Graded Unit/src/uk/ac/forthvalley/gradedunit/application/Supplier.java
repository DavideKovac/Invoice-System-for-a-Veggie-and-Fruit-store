package uk.ac.forthvalley.gradedunit.application;

import java.sql.PreparedStatement;

public class Supplier {
private int supplierId=1;
private String companyName;
private String supplierEmail;
private String supplierPhoneNumber;
private PreparedStatement insertSupplier=con.preparedStatement("INSERT INTO suppliers VALUE(?,?,?,?)");
private PreparedStatement getSupplierInfo=con.preparedStatement("SELECT supplier_id,company_name,email,phone_number FROM suppliers WHERE supplier_id=?");

public Supplier()
{
	
}
public void insertNewSupplier(int supplierID,String companyName,String supplierEmail,String supplierPhoneNumber) {
	insertSupplier.setInt(1,supplierID);
	insertSupplier.setString(2,companyName);
	insertSupplier.setString(3, supplierEmail);
	insertSupplier.setString(4, supplierPhoneNumber);
	supplierID++;
}
public void getSupplierInfo(int supplierID) {
	getSupplierInfo.setInt(1,supplierID);	
}

}
