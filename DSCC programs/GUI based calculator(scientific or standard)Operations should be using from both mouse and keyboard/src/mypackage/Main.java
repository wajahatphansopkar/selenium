package mypackage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Main extends UnicastRemoteObject implements Calculator{
	protected Main() throws RemoteException { super();
	} private static final long serialVersionUID = 1L;
	@Override
	public void calculate() throws RemoteException { new calculators();


	}

}
