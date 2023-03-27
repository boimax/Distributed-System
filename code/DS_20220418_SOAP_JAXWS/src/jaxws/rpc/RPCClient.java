package jaxws.rpc;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class RPCClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		URL url = new URL ("http://localhost:7779/jaxws/rpcservice?wsdl");
		
		//1st argument is the service URI as per the wsdl
		//2nd argument is the service name as per the wsdl
		QName qname = new QName("http://rpc.jaxws/", "RPCServerImplService");
		Service service = Service.create(url, qname);
		RPCServer rpcWebService = service.getPort(RPCServer.class);
		System.out.println(rpcWebService.getRPCSServerName("Packt RPC"));
	}

}
