package datetime;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDateTime;

public interface Dater extends Remote {
	public LocalDateTime getDate() throws RemoteException;

}
