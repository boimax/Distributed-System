import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


public class SocketClient_HW {
    public static void main(String[] args) throws IOException {
    	
        Socket s = new Socket("localhost",2404);

        InputStream sIn = s.getInputStream();
        DataInputStream socketDIS = new DataInputStream(sIn);
        String testString = new String(socketDIS.readUTF());
        System.out.println(testString);
      
        OutputStream sOut = s.getOutputStream();
        DataOutputStream socketDOS = new DataOutputStream(sOut);
        
        String sent_string, receive;
        
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("\nType your words: ");
            sent_string= sc.nextLine();
            //System.out.println(sent_string);
            
            socketDOS.writeUTF(sent_string);
            receive = socketDIS.readUTF();
            //System.out.println(receive);
            
            if(receive.equals("quit")){
            	System.out.println("\nSystem stopped");
                break;
            }
            
            System.out.println("\n\n->Server reply: "+ receive.toUpperCase());
        }

        socketDIS.close();
        socketDOS.close();
        sIn.close();
        
        s.close();
        sc.close();
        
        
    }
}
