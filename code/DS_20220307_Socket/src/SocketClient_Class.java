import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class SocketClient_Class {
	public static void main (String args[]) throws IOException{
		
		Socket s = new Socket("localhost", 1286);
		
		InputStream socketInStream = s.getInputStream();
		
		DataInputStream socketDIS = new DataInputStream(socketInStream);
		
		String testString = new String(socketDIS.readUTF());
		
		System.out.println(testString);
		
		socketDIS.close();
		
		socketInStream.close();
		
		s.close();
	}
}