package mypackage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Main  extends UnicastRemoteObject implements Equator{
	
	protected Main() throws RemoteException { super();
	} private static final long serialVersionUID = 1L;
	@Override
	public int getEquation(int a, int b) throws RemoteException { int 
	result=((a*a)-(2*a*b)+(b*b)); return result;
	}
}

