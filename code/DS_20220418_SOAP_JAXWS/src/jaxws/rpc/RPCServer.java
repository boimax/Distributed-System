package jaxws.rpc;
//Remote Server Interface
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

//Service End point Interface
@WebService
@SOAPBinding(style = Style.RPC)

public interface RPCServer {
	@WebMethod String getRPCSServerName(String name);
}
