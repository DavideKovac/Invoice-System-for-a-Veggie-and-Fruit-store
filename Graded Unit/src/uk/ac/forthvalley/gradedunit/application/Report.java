package uk.ac.forthvalley.gradedunit.application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSetMetaData;
/**
 *  This is the class that manage all the queries related to the Reports table
 * @author Davide Kovac 
 *
 */

public class Report {
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
 * This string execute a query that return the last week orders
 */
private String getWeeklyReportString="SELECT order_id FROM orders WHERE order_date >= curdate() - INTERVAL DAYOFWEEK(CURDATE())+6 DAY AND order_date < CURDATE() - INTERVAL DAYOFWEEK(CURDATE())-1 DAY";
/**
 * This Statement execute a query using the getWeeklyReportString 
 */
private PreparedStatement getWeeklyReport=null;
/**
 * This string execute a query that return the last months orders
 */
private String getMonthlyReportString="SELECT order_id FROM orders WHERE order_date >= curdate() - INTERVAL DAYOFWEEK(CURDATE())+30 DAY AND order_date < CURDATE() - INTERVAL DAYOFWEEK(CURDATE())-1 DAY";
/**
 * This Statement execute a query using the getMonthlyReportString 
 */
private PreparedStatement getMonthlyReport=null;

public Report()
{
	
}
/**
 * <p>This methods return an array list with all the order id from the last week</p>
 * @return An arraylist of last week orderId
 * @throws SQLException
 */
public ArrayList<String> getWeeklyReport() throws SQLException
{ 
	
	ResultSet rs;
	con=DriverManager.getConnection(url, user, password);
	getWeeklyReport=con.prepareStatement(getWeeklyReportString);
	rs=getWeeklyReport.executeQuery();
	ResultSetMetaData rsmd = rs.getMetaData(); 
	int getColumnCount=rsmd.getColumnCount();
	ArrayList <String> weeklyReport=new ArrayList<>(getColumnCount);
    while(rs.next())
    {
    	int x=1;
    	while(x<=getColumnCount)
    	{
    	
    	weeklyReport.add(rs.getString(1));
    	}
    	
    }
    con.close();
    return weeklyReport;
}
/**
 * <p>This methods return an array list with all the order id from the last month</p>
 * @return An arraylist of last month orderId
 * @throws SQLException
 */
public ArrayList<String> getMonthlyReport() throws SQLException
{
	ResultSet rs;
	con=DriverManager.getConnection(url, user, password);
	getMonthlyReport=con.prepareStatement(getMonthlyReportString);
	rs=getMonthlyReport.executeQuery();
	ResultSetMetaData rsmd = rs.getMetaData(); 
	int getColumnCount=rsmd.getColumnCount();
	ArrayList <String> monthlyReport=new ArrayList<>(getColumnCount);
    while(rs.next())
    {
    	int x=1;
    	while(x<=getColumnCount)
    	{
    	
    	monthlyReport.add(rs.getString(1));
    	}
    	
    }
    con.close();
    return monthlyReport;
	
}
}
