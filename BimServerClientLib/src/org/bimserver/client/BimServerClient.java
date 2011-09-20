package org.bimserver.client;

import java.util.HashMap;
import java.util.Map;

import javax.xml.ws.BindingProvider;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.bimserver.pb.ServiceInterfaceReflectorImpl;
import org.bimserver.shared.ServiceInterface;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.pb.Reflector;

import com.google.protobuf.BlockingRpcChannel;
import com.googlecode.protobuf.socketrpc.RpcChannels;
import com.googlecode.protobuf.socketrpc.SocketRpcConnectionFactories;
import com.googlecode.protobuf.socketrpc.SocketRpcController;

public class BimServerClient {
	private ServiceInterface serviceInterface;

	public BimServerClient() {
	}

	public void connectDirect(ServiceInterface serviceInterface) {
		this.serviceInterface = serviceInterface;
	}
	
	public void connectProtocolBuffers(String address, int port) {
		SocketRpcController rpcController;
		BlockingRpcChannel rpcChannel = RpcChannels.newBlockingRpcChannel(SocketRpcConnectionFactories.createRpcConnectionFactory(address, port));
		rpcController = new SocketRpcController();

		Reflector reflector = new Reflector(getClass().getClassLoader().getResource("service.desc"), rpcController, rpcChannel);
		serviceInterface = new ServiceInterfaceReflectorImpl(reflector);
	}
	
	public void connectSoap(final String address) {
		JaxWsProxyFactoryBean cpfb = new JaxWsProxyFactoryBean();
		cpfb.setServiceClass(ServiceInterface.class);
		cpfb.setAddress(address);
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put("mtom-enabled", Boolean.TRUE);
		cpfb.setProperties(properties);

		serviceInterface = (ServiceInterface) cpfb.create();

		Client client = ClientProxy.getClient(serviceInterface);
		HTTPConduit http = (HTTPConduit) client.getConduit();
		((BindingProvider) serviceInterface).getRequestContext().put(BindingProvider.SESSION_MAINTAIN_PROPERTY, Boolean.TRUE);
		http.getClient().setConnectionTimeout(360000);
		http.getClient().setAllowChunking(false);
		http.getClient().setReceiveTimeout(320000);
	}

	public void login(String username, String password) throws ServiceException {
		serviceInterface.login(username, password);
	}
	
	public ServiceInterface getServiceInterface() {
		return serviceInterface;
	}
	
	public Session createSession() {
		if (serviceInterface == null) {
			throw new RuntimeException("Connect first");
		}
		Session session = new Session(serviceInterface);
		return session;
	}
}