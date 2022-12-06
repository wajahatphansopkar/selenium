package datetime;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {

	public static void main(String[] args) {try
	{
		Dater dt=new Main();
		LocateRegistry.createRegistry(1900);
		Naming.rebind("rmi://localhost:1900/datedisplay", dt);

	}
	catch(Exception ex)
	{
	System.out.println(ex); 
	}


	}

}