package jaxws.rpc;
import javax.jws.WebService;
//Service Implementation for the interface
@WebService(endpointInterface = "jaxws.rpc.RPCServer")
public class RPCServerImpl implements RPCServer {

	@Override
	public String getRPCSServerName(String name) {
		// TODO Auto-generated method stub
		return " JAX-WS RPC Server is : " + name;
	}

	
}
