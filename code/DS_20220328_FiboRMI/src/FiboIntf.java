import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FiboIntf extends Remote {
	public int FiboNth (int n) throws RemoteException;
}