import java.rmi.Naming;
import java.util.Scanner;

public class FiboClient {
	public static void main (String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter your selected Fibonacci_th: ");
		int n = sc.nextInt();
		
		try {
			FiboIntf RemObj = (FiboIntf)Naming.lookup("rmi://localhost/FiboIntf");
			System.out.println("The " + n + "th Fibonacci is: " + RemObj.FiboNth(n));
			
		}
		catch (Exception e) {
			System.out.println("FiboLClient exception: " + e);
		}
	}
}