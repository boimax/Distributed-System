import java.rmi.Naming;

public class AddServer {
	public static void main (String[] args) {
		try {
			AddImpl LocObj = new AddImpl();
			Naming.rebind("rmi:///AddIntf", LocObj);
			System.out.println("Server is ready!");
		}
		catch (Exception e) {
			System.out.println("AddServer failed: " + e);
		}
	}
}
