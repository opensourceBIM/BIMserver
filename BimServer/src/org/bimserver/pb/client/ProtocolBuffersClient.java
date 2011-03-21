package org.bimserver.pb.client;

import org.bimserver.pb.Service.GetAllProjectsRequest;
import org.bimserver.pb.Service.GetAllProjectsResponse;
import org.bimserver.pb.Service.LoginRequest;
import org.bimserver.pb.Service.LoginResponse;
import org.bimserver.pb.Service.SProject;
import org.bimserver.pb.Service.ServiceInterface;
import org.bimserver.pb.Service.GetAllProjectsRequest.Builder;
import org.bimserver.pb.Service.ServiceInterface.BlockingInterface;

import com.google.protobuf.BlockingRpcChannel;
import com.google.protobuf.ServiceException;
import com.googlecode.protobuf.socketrpc.RpcChannels;
import com.googlecode.protobuf.socketrpc.SocketRpcConnectionFactories;
import com.googlecode.protobuf.socketrpc.SocketRpcController;

public class ProtocolBuffersClient {
	private SocketRpcController rpcController;
	private BlockingInterface service;

	public static void main(String[] args) {
		new ProtocolBuffersClient().start();
	}

	private void start() {
		BlockingRpcChannel rpcChannel = RpcChannels.newBlockingRpcChannel(SocketRpcConnectionFactories.createRpcConnectionFactory("localhost", 8020));
		rpcController = new SocketRpcController();

		service = ServiceInterface.newBlockingStub(rpcChannel);
		try {
			login("admin@logic-labs.nl", "admin");
			getAllProjects();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		    
		if (rpcController.failed()) {
		  System.err.println(String.format("Rpc failed %s : %s", rpcController.errorReason(),
		      rpcController.errorText()));
		}
	}

	private void getAllProjects() throws ServiceException {
		Builder getAllProjectsRequestBuilder = GetAllProjectsRequest.newBuilder();
		GetAllProjectsRequest getAllProjectsRequest = getAllProjectsRequestBuilder.build();
		
		GetAllProjectsResponse getAllProjectsResponse = service.getAllProjects(rpcController, getAllProjectsRequest);
		if (getAllProjectsResponse != null) {
			for (SProject sProject : getAllProjectsResponse.getValueList()) {
				System.out.println(sProject.getName());
			}
		}
	}

	private void login(String username, String password) throws ServiceException {
		LoginRequest.Builder loginRequestBuilder = LoginRequest.newBuilder();
		loginRequestBuilder.setUsername(username);
		loginRequestBuilder.setPassword(password);
		LoginRequest loginRequest = loginRequestBuilder.build();
		LoginResponse loginResponse = service.login(rpcController, loginRequest);
		if (loginResponse != null && loginResponse.getValue()) {
			System.out.println("Login successfull");
		} else {
			System.out.println("Error logging in");
		}
	}
}