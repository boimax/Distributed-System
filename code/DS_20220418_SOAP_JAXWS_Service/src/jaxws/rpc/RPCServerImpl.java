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

	@Override
	public int getFibonacciNth(int n) {
		// TODO Auto-generated method stub
		return (int) Math.round(Math.pow(((1 + Math.sqrt(5)) / 2), n) / Math.sqrt(5));
	}

	@Override
	public int getExponent(int a, int b) {
		// TODO Auto-generated method stub
		return (int) Math.pow(a, b);
	}
	
	
}
