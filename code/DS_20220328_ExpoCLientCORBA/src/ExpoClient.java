
/**
 *
 * @author Ho Cat Tuong
 */
import ExpoModule.*;

import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import java.io.*;
import java.util.*;

public class ExpoClient {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		try {
			ORB orb = ORB.init(args, null);
			org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
			Expo expoobj = (Expo) ExpoHelper.narrow(ncRef.resolve_str("Expo"));

			Scanner sc = new Scanner(System.in);
			System.out.println("Hi! My name is ExpoSystem:");
			for (;;) {

				System.out.println("Enter number a:");
				int a = sc.nextInt();
				System.out.println("Enter number b:");
				int b = sc.nextInt();

				System.out.println("The result of " + a + "^" + b + " is: " + expoobj.expo(a, b));
				System.out.println("-----------------------------------");
			}

		} catch (Exception e) {
			System.out.println("ExpoClient exception: " + e);
			e.printStackTrace();
		}
	}
}