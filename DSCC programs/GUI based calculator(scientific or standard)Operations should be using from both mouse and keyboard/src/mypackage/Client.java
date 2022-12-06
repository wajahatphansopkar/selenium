package mypackage;

import java.rmi.Naming;

public class Client {
	public static void main(String[] args) { try
	{
	Calculator 
	access=(Calculator)Naming.lookup("rmi://localhost:1900/calculator");
	access.calculate();
	}
	catch(Exception ex)
	{
	System.out.println(ex); }
	}
	}



	
