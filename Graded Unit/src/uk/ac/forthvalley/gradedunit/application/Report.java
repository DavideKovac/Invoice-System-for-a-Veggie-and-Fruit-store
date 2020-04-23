package uk.ac.forthvalley.gradedunit.application;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Report {
private Connection con=null;
private String getWeeklyReportString="SELECT * FROM orders WHERE ordersdate=sysdate-7";
private PreparedStatement getWeeklyReport=null;
private String getMonthlyReportString="SELECT * FROM orders WHERE ordersdate=sysdate-30";
private PreparedStatement getMonthlyReport=null;
public Report()
{
	
}
public void getWeeklyReprot() throws SQLException
{
	getWeeklyReport=con.prepareStatement(getWeeklyReportString);
}
public void gerMonthlyReport() throws SQLException
{
  getMonthlyReport=con.prepareStatement(getMonthlyReportString);
}
}
