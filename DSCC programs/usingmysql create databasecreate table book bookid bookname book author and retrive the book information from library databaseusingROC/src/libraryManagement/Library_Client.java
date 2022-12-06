package libraryManagement;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Library_Client {
	public static void main(String[] args) {
		try
		{
		LibraryDBInf skeleton=new LibraryOperations();
		//create registry
		LocateRegistry.createRegistry(1902);
		Naming.rebind("rmi://localhost:1902/libraryServices", skeleton);
		System.out.println("Server Started......");
		}catch(Exception e)
		{
			System.out.println("error from 1st catch"+e.getMessage());
			}}}




