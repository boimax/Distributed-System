import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class SocketServer_UDP {
	public static void main (String args[]) {
		DatagramSocket dgSocket = null;
		
		try {
			
			int socketNumber = 18;
			dgSocket = new DatagramSocket(socketNumber);
			byte[] byteBuffer = new byte[1000]; //buffer holds and receives data
			while (true) {
				DatagramPacket dgRequest = new DatagramPacket(byteBuffer, byteBuffer.length); //to prepare to save the request that 
				//we get from the client and save it into dgRequest
				dgSocket.receive(dgRequest);
				
				String receivedMsg = new String (dgRequest.getData());
				receivedMsg = receivedMsg.toUpperCase();
				byte[] responseBytes = receivedMsg.getBytes(); //convert string to bytes do something in response to the client request, then send the response to client
				DatagramPacket dgResponse = new DatagramPacket(responseBytes, responseBytes.length, dgRequest.getAddress(), dgRequest.getPort());
				dgSocket.send(dgResponse);
			}
			
		} catch (SocketException e) {
			System.out.println("Socket Exception: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO Exception: " + e.getMessage());
		} finally {
			if (dgSocket != null)
				dgSocket.close();
		}
	}
}