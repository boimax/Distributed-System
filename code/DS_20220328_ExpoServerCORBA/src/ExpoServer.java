
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

public class ExpoServer {

  public static void main(String args[]) {
    try {

      ORB orb = ORB.init(args, null);
      POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
      rootpoa.the_POAManager().activate();

      ExpoObj expoobj = new ExpoObj();
      expoobj.setORB(orb);

      org.omg.CORBA.Object ref = rootpoa.servant_to_reference(expoobj);
      Expo href = ExpoHelper.narrow(ref);

      org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
      NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

      NameComponent path[] = ncRef.to_name("Expo");
      ncRef.rebind(path, href);

      System.out.println("ExpoServer ready and waiting ...");

      for (;;) {
        orb.run();
      }
    }

    catch (Exception e) {
      System.err.println("ERROR: " + e);
      e.printStackTrace(System.out);
    }

    System.out.println("ExpoServer Exiting ...");

  }
}