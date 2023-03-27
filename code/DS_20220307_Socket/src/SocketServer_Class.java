import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;	

public class SocketServer_Class {
	public static void main (String args[]) throws IOException{
		ServerSocket ss = new ServerSocket(1286);
		
		Socket s = ss.accept(); //wait client to connect to server, and then the code block below (line 15-24) will run
		//System.out.println("The server is running");
		
		OutputStream socketOutStream = s.getOutputStream();
		DataOutputStream socketDOS = new DataOutputStream(socketOutStream);
		
		socketDOS.writeUTF("Hello World!");
		
		socketDOS.close();
		socketOutStream.close();
		s.close();
		
		ss.close();
	}
}