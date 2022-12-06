package mypackage;

import java.rmi.Naming;

public class Client {
	public static void main(String[] args) { try
	{
	Equator 
	access=(Equator)Naming.lookup("rmi://localhost:1900/equationsolver");
	int answer=access.getEquation(5, 3); System.out.println("(a-b)2= "+answer);
	}
	catch(Exception ex)
	{
	System.out.println(ex); }
	}
	}



