package libraryManagement;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class LibraryOperations  extends UnicastRemoteObject implements LibraryDBInf {
	
	Connection con;
	Statement stmt;
	ResultSet rs;
	ResultSetMetaData rsmd;
	String colStr,resultStr;
	private static final long serialVersionUID = 1L;
	protected LibraryOperations() throws RemoteException {
	super();
	colStr="";
	resultStr="";
	con=null;
	stmt=null;

		
	rs=null;
	rsmd=null;
	}
	//set Database connection
	public void setDbConn()
	{
	try 
	{
	//protocol //server //portNo //Database
	String url="jdbc:mysql://localhost:3306/library";
	//loading of driver
	Class.forName("com.mysql.cj.jdbc.Driver");
	//get connection
	con=DriverManager.getConnection(url,"root","");
	}catch(Exception e) {
	System.out.println(e.getMessage());
	}
	}
	@Override
	public String getData(String StrQuery) {
	try 
	{setDbConn();
	System.out.println("Database Connected");
	//create Statement
	stmt=con.createStatement();
	rs=stmt.executeQuery(StrQuery);
	//getting metadata info about result set;
	rsmd=rs.getMetaData();
	//getting the columns of table which is stored in rsmd
	for(int i=1;i<=rsmd.getColumnCount();i++)
	{
		System.out.println(i);
		colStr=colStr + rsmd.getColumnName(i)+"\t\t\t";
		}
		//getting all records from result set
		while(rs.next()) 
		{
		for(int i=1;i<=rsmd.getColumnCount();i++)
		{
		resultStr=resultStr + rs.getString(i)+ "\t\t";
		}
		resultStr=resultStr + "\n";
		}}
		catch(Exception e) {
		System.out.println(e.getMessage());
		}
		return colStr + "\n" +resultStr;
}
}
