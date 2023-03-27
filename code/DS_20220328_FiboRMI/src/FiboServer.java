import java.rmi.Naming;

public class FiboServer {
	public static void main (String[] args) {
		try {
			FiboImpl LocObj = new FiboImpl();
			Naming.rebind("rmi:///FiboIntf", LocObj);
			System.out.println("System is ready!");
		}
		catch (Exception e) {
			System.out.println("FiboServer failed: " + e);
		}
	}
}