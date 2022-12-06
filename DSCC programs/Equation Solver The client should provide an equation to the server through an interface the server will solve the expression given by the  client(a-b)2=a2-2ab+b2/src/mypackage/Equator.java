package mypackage;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Equator extends Remote{
	public int getEquation(int a,int b) throws RemoteException;
	}
