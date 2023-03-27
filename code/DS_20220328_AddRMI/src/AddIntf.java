import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AddIntf extends Remote {
	public int addNum (int a, int b) throws RemoteException;
}
