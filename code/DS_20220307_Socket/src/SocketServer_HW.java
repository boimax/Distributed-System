import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer_HW {
    public static void main(String[] args) throws IOException{
        ServerSocket ss = new ServerSocket(2404);
        
        Socket s = ss.accept();

        OutputStream socketOutputStream = s.getOutputStream();
        DataOutputStream socketDOS = new DataOutputStream(socketOutputStream);

        socketDOS.writeUTF("Server linked");

        InputStream sIn = s.getInputStream();
        DataInputStream socketDIS = new DataInputStream(sIn);
        
        while(true){
            String receive = socketDIS.readUTF();
            String sent_string= receive;
            socketDOS.writeUTF(sent_string);
            if(receive.equals("quit"))
                break;
        }
        socketDOS.close();
        socketDIS.close();
        socketOutputStream.close();

        s.close();
        ss.close();
        
    }
    
}
