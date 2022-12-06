package datetime;

import java.rmi.Naming;
import java.time.LocalDateTime;

public class Client {

	public static void main(String[] args) { 
		LocalDateTime answer;
		try
		{
		Dater 
		access=(Dater)Naming.lookup("rmi://localhost:1900/datedisplay");
		answer=access.getDate(); System.out.println(answer);
		}
		catch(Exception ex)
		{
		System.out.println(ex); }
		}
		}

