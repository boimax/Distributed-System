import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AddImpl extends UnicastRemoteObject implements AddIntf {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public AddImpl() throws RemoteException {
		
	}
	public int addNum(int a, int b) {
		// TODO Auto-generated method stub
		return (a + b);
	}
	
}
