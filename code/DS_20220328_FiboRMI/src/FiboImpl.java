import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class FiboImpl extends UnicastRemoteObject implements FiboIntf {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FiboImpl() throws RemoteException {

	}

	@Override
	public int FiboNth(int n) {
		// TODO Auto-generated method stub
		return (int) Math.round(Math.pow(((1 + Math.sqrt(5)) / 2), n) / Math.sqrt(5));
	}
}