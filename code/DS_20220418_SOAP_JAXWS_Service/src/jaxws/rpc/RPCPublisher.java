package jaxws.rpc;
import javax.xml.ws.Endpoint;

//End point publisher
public class RPCPublisher {
	public static void main (String[] args) {
		
		Endpoint.publish("http://localhost:7779/jaxws/rpcservice", new RPCServerImpl());
	}
}
