import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class SocketClient_UDP {
	public static void main (String args[]) {
		DatagramSocket dgSocket = null;
		String hostName = "localhost";
		int port = 18;
		String clientMsg = "Hello!";
		
		try {
			dgSocket = new DatagramSocket();
			byte[] bytes = clientMsg.getBytes();
			InetAddress serverHost = InetAddress.getByName(hostName);
			
			DatagramPacket dgRequest = new DatagramPacket(bytes, bytes.length, serverHost, port); //serverPortnumber;
			dgSocket.send(dgRequest);
			
			byte[] byteBuffer = new byte[1000];
			DatagramPacket dgResponse = new DatagramPacket(byteBuffer, byteBuffer.length);
			dgSocket.receive(dgResponse); //receive response from server
			System.out.println("Datagram Response: " + new String(dgResponse.getData()));
		}
		catch (SocketException e) {
			System.out.println("Socket Exception: " + e.getMessage());
		}
		catch (IOException e) {
			System.out.println("IO Exception: " + e.getMessage());
		}
		finally {
			if (dgSocket != null) {
				dgSocket.close(); //close socket
			}
		}
	}
}