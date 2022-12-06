package datetime;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;

public class Main extends UnicastRemoteObject implements Dater{Main() throws RemoteException 
	{
	super();
	}
	@Override
	public LocalDateTime getDate() throws RemoteException { return 
	java.time.LocalDateTime.now();
	}
}



