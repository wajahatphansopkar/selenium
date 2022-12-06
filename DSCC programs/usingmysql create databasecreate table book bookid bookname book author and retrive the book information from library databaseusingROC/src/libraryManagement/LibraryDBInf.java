package libraryManagement;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LibraryDBInf extends Remote {
	
	public String getData(String StrQuery) throws RemoteException;}


