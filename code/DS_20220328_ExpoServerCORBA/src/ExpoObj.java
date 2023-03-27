/**
*
* @author Ho Cat Tuong
*/
import ExpoModule.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
import java.util.Properties;

class ExpoObj extends ExpoPOA {
	private ORB orb;
	public void setORB(ORB orb_val) {
		orb = orb_val; 
	}
	
	// implement add() method
	public int expo(int a, int b) {
		return (int) Math.pow(a, b);
	}
}
