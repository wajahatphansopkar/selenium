package mypackage;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;

public class Server { public static void 
	main(String[] args) { try
	{
	Calculator cal=new Main();
	LocateRegistry.createRegistry(1900);
	Naming.rebind("rmi://localhost:1900/calculators", (Remote) cal);
	}
	catch(Exception ex)
	{
	System.out.println(ex); }
	}
	}

