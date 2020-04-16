package uk.ac.forthvalley.gradedunit.application;
import java.sql.PreparedStatement;
public class Report {

public Report()
{
	
}
public void getWeeklyReprot()
{
	PreparedStatement getWeeklyReport=con.preparedStatement("SELECT * FROM orders WHERE ordersdate=sysdate-7");
}
public void gerMonthlyReport()
{
	PreparedStatement getMonthlyReport=con.preparedStatement("SELECT * FROM orders WHERE ordersdate=sysdate-30");
}
}