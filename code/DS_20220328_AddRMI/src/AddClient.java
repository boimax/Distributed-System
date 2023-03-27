import java.rmi.Naming;
import java.util.Scanner;

public class AddClient {
	@SuppressWarnings("resource")
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Enter 1st number: ");
		int a = sc.nextInt();
		System.out.println("Enter 2nd number: ");
		int b = sc.nextInt();
		
		try {
			AddIntf RemObj = (AddIntf)Naming.lookup("rmi://localhost/AddIntf");
			System.out.println("The result: " + RemObj.addNum(a, b));
		}
		catch (Exception e) {
			System.out.println(" AddClient exception: " + e);
		}
	}
}
