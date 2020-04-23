package uk.ac.forthvalley.gradedunit.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Supplier {
Connection con=null;
private int supplierId=1;
private String insertSupplierString="INSERT INTO suppliers VALUE(?,?,?,?)";
private PreparedStatement insertSupplier=null;
private String getSupplierInfoString="SELECT supplier_id,company_name,email,phone_number FROM suppliers WHERE supplier_id=?";
private PreparedStatement getSupplierInfo=null;

public Supplier()
{
	
}
public void insertNewSupplier(String companyName,String supplierEmail,String supplierPhoneNumber) throws SQLException{
	try {
	insertSupplier=con.prepareStatement(insertSupplierString);
	insertSupplier.setInt(1,supplierId);
	insertSupplier.setString(2,companyName);
	insertSupplier.setString(3, supplierEmail);
	insertSupplier.setString(4, supplierPhoneNumber);
	supplierId++;
	}
	catch(SQLException e)
	{
		e.getMessage();
	}
}
public void getSupplierInfo(int supplierID) throws SQLException {
	try {
	getSupplierInfo=con.prepareStatement(getSupplierInfoString);
	getSupplierInfo.setInt(1,supplierID);	
	}
	catch(SQLException e)
	{
		e.getMessage();
	}
}

}
